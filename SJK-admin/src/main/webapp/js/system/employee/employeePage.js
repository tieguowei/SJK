
/**
 * 员工管理
 */

//系统管理--员工管理的单例对象
var Employee = {
    seItem: null		//选中的条目
};

$(function (){
	//select2 多选
    $("#employee_rid").select2({
        language: "zh-CN", //设置 提示语言
        maximumSelectionLength: 1000,  //设置最多可以选择多少项
        //width: "100%", //设置下拉框的宽度
        placeholder: "请选择",
        tags: false  //输入无效
    });
    Employee.formValidator();
    Employee.init();
    $('.close').click(function(){
    	Employee.closeDlg();
	 });
});
//表格数据展示
var Employee = function (){
    return{
        init:function (){
            $('#employee-table').bootstrapTable({
                url: "employee/getEmployeeList",
                method:"post",
                dataType: "json",
                contentType: "application/x-www-form-urlencoded",
                striped:true,//隔行变色
                cache:false,  //是否使用缓存
                showColumns:false,// 列
                toobar:'#toolbar',
                pagination: true, //分页
                sortable: false, //是否启用排序
                singleSelect: false,
                search:false, //显示搜索框
                buttonsAlign: "right", //按钮对齐方式
                showRefresh:false,//是否显示刷新按钮
                sidePagination: "server", //服务端处理分页
                pageSize : 5, //默认每页条数
                pageNumber : 1, //默认分页
                pageList : [ 5, 10, 20, 50],//分页数
                toolbar:"#toolbar",
                showColumns : false, //显示隐藏列
                uniqueId: "employee_id", //每一行的唯一标识，一般为主键列
                queryParamsType:'',
                queryParams: Employee.queryParams,//传递参数（*）
                columns : [{
                    checkbox: true
                	},{
                    field : "name",
                    title : "姓名",
                    align : "center",
                    valign : "middle",
                    sortable : "true"
                }, {
                    field : "sex",
                    title : "性别",
                    align : "center",
                    valign : "middle",
                    sortable : "true"
                }, {
                    field : "employee_no",
                    title : "员工编号",
                    align : "center",
                    valign : "middle",
                    sortable : "true"
                }, {
                    field : "mobile",
                    title : "手机号码",
                    align : "center",
                    valign : "middle",
                    sortable : "true"
                }, {
                    field : "activated_state",
                    title : "状态",
                    align : "center",
                    valign : "middle",
                    sortable : "true"
                }],
                formatLoadingMessage : function() {
                    return "请稍等，正在加载中...";
                },
                formatNoMatches : function() {
                    return '无符合条件的记录';
                }
            });
        },
        queryParams:function(params){
            var temp = {
                pageSize: params.pageSize,  //页面大小
                pageNumber: params.pageNumber, //页码
                employeeNo: $("#search_employee_no").val(),
                employeeName:$("#search_employee_name").val(),
            };
            return temp;
        },
        /**
         * 检查是否选中单条记录
         */
        checkSingleData:function () {
            var selected = $('#employee-table').bootstrapTable('getSelections');
            if (selected.length == 0) {
            	 $.alert({
                     title: '提示信息！',
                     content: '至少选择一条记录！',
                     type: 'red'
                 });
                return false;
            }else if (selected.length > 1){
            	 $.alert({
                     title: '提示信息！',
                     content: '该操作只能选择一条记录!',
                     type: 'blue'
                 });
            }else {
            	Employee.seItem = selected[0];
                return true;
            }
        },
        //角色分配
        getRole:function(){
        	if(this.checkSingleData()) {
        		var employeeId = Employee.seItem.employee_id;
                $.ajax({
                    url:'employee/getRole',
                    dataType:'json',
                    type:'post',
                    traditional:true,
                    data:{
                    	employeeId:employeeId
                    },
                    success:function(data){
                        $("#employee_rid").empty();
                        $.each(data.role,function(index,items){
                            $("#employee_rid").append("<option value='"+items.id+"'>"+items.roleName+"</option>");
                        });
                        if((data.userRole!=null)){
                            $.each(data.userRole,function(index,items){
                                $("#employee_rid").val(data.userRole).trigger("change");//select2 选中
                            });
                        }else{
                            $("#employee_rid").val(0).trigger("change");
                        }
                        $("#employeeRoleDlg").modal('show');
                    },
                    error:function(){
                        $.alert({
                            title: '提示信息！',
                            content: '请求失败！',
                            type: 'red'
                        });
                    }
                })
                
        	}
        },
        //保存修改角色
        saveRole:function(){
        	var employeeId = Employee.seItem.employee_id;
            var rids=$("#employee_rid").val();//select2 获取多选值
            $.ajax({
                url:'employee/updateEmployeeRole',
                dataType:'json',
                type:'post',
                traditional:true,
                data:{
                    employeeId:employeeId,
                    rid:rids
                },
                success:function(data){
                    if(data){
                        $.alert({
                            title: '提示信息！',
                            content: '保存成功！',
                            type: 'blue'
                        });
                        Employee.closeDlg();
                        $("#employee-table").bootstrapTable('refresh');
                    }else{
                        $.alert({
                            title: '提示信息！',
                            content: '保存失败！',
                            type: 'red'
                        });
                       
                    }
                }
            })
        },
        //修改前，打开模态框
        openUpdateModal:function(){
        	if (this.checkSingleData()) {
        		var employeeId = Employee.seItem.employee_id;
        		 $.ajax({
                     url:'employee/getEmployeeById',
                     dataType:'json',
                     type:'post',
                     data:{
                     	employeeId:employeeId
                     },
                     success:function(data){
                         $("#update_employee_id").val(data.employee.employeeId);
                         $("#update_employee_name").val(data.employee.name);
                         $("#update_employee_no").val(data.employee.employeeNo);
                         $("#update_email").val(data.employee.email);
                         $("#update_telephone").val(data.employee.telephone);
                         $("#update_card_no").val(data.employee.cardNo);
                         $("#update_entry_time").val(data.employee.entryTime);
                         $("#employee_update_dept_id").val(data.employee.deptId);
                         $("#update_departmentname").val(data.employee.departmentname);
                         if(data.employee.sex==0){
                         	  document.getElementById("update_employee_sex0").checked = true;
                         	}
                         	if(data.employee.sex==1){
                         	  document.getElementById("update_employee_sex1").checked = true;
                         	}
                         $("#update_employee_mobile").val(data.employee.mobile);
                         $("#employeeUpdateDlg").modal('show');
                     },
                     error:function(){
                         $.alert({
                             title: '提示信息！',
                             content: '请求失败！',
                             type: 'red'
                         });
                     }
                 });
        	}
           
        },
        //修改用户
        updateEmployee:function(){
            if($("#employeeUpdateForm").data("bootstrapValidator").validate().isValid()){
                $.ajax({
                    url:'employee/updateEmployee',
                    dataType:'json',
                    type:'post',
                    data:$("#employeeUpdateForm").serialize(),
                    success:function(data){
                        if(data){
                            $.alert({
                                title: '提示信息！',
                                content: '修改成功！',
                                type: 'blue'
                            });
                            Employee.closeDlg();
                            $("#employee-table").bootstrapTable('refresh');
                        }else{
                            $.alert({
                                title: '提示信息！',
                                content: '修改失败！',
                                type: 'red'
                            });
                        }
                       
                    }
                });
            }
        },
        
        //删除
        deleteEmployee:function(activatedState){
        	
        	if (this.checkSingleData()) {
        		var employeeId = Employee.seItem.employee_id;
        		$.confirm({
                    title: '提示信息!',
                    content: '您确定要提交更改吗？',
                    type: 'blue',
                    typeAnimated: true,
                    buttons: {
                        确定: {
                            action: function(){
                            	
                               $.ajax({
                                    url:'employee/deleteEmployee',
                                    dataType:'json',
                                    type:'post',
                                    data:{
                                    	employeeId:employeeId,
                                    activatedState:activatedState
                                    },
                                    success:function(data){
                                        if(data){
                                            $.alert({
                                                title: '提示信息！',
                                                content: '修改成功!',
                                                type: 'blue'
                                            });
                                        }else{
                                            $.alert({
                                                title: '提示信息！',
                                                content: '修改失败!',
                                                type: 'red'
                                            });
                                        }
                                        $("#employee-table").bootstrapTable('refresh');
                                    },
                                    error:function(){
                                        $.alert({
                                            title: '提示信息！',
                                            content: '请求失败！',
                                            type: 'red'
                                        });
                                    }
                                });
                            }
                        },
                        取消: function () {
                        }
                    }
                });
        	}
            
        },
        //添加，打开模态框
        openDlg:function(){
            $("#employeeAddDlg").modal('show');
        },
        //添加用户
        saveEmployee:function(){
        	document.getElementById("saveEmployeeButton").setAttribute("disabled", true);
           if($("#addEmployeeForm").data('bootstrapValidator').validate().isValid()){
              $.ajax({
                    url:'employee/saveEmployee',
                    type:'post',
                    dataType:'json',
                    data:$("#addEmployeeForm").serialize(),
                    success:function(data){
                        if(data){
                            $.alert({
                                title: '提示信息！',
                                content: '添加成功!',
                                type: 'blue'
                            });
						    document.getElementById("saveEmployeeButton").removeAttribute("disabled");
                        }else{
                            $.alert({
                                title: '提示信息！',
                                content: '添加失败！',
                                type: 'red'
                            });
						    document.getElementById("saveEmployeeButton").removeAttribute("disabled");
                        }
                        $("#employee-table").bootstrapTable('refresh');
                        Employee.closeDlg();
                    },
                    error:function(){
                        $.alert({
                            title: '提示信息！',
                            content: '请求失败！',
                            type: 'red'
                        });
                    }
                });
            }else{
            	document.getElementById("saveEmployeeButton").removeAttribute("disabled");
            }
        },
        //关闭模态框
        closeDlg:function () {
            $("#employeeRoleDlg").modal('hide');
            $("#employeeUpdateDlg").modal('hide');
            $("#employeeAddDlg").modal('hide');
            $("input[type=reset]").trigger("click");
            $('#addEmployeeForm').data('bootstrapValidator', null);
            $('#employeeUpdateForm').data('bootstrapValidator', null);
		    document.getElementById("saveEmployeeButton").removeAttribute("disabled");
            Employee.formValidator();
        },
        formValidator:function () {
            $("#addEmployeeForm").bootstrapValidator({
                fields:{
                	name:{
                        validators:{
                            notEmpty:{
                                message:"姓名不能为空"
                            },
                            stringLength:{
                                max:20,
                                message:"字符长度不能超过20个字符"
                            }
                        }
                    },
                    employeeNo:{
                        validators:{
                            notEmpty:{
                                message:"员工编号不能为空"
                            },
                            stringLength:{
                                max:20,
                                message:"字符长度不能超过20个字符"
                            }
                        }
                    }
                }
            });


            $("#employeeUpdateForm").bootstrapValidator({
                fields:{
                	name:{
                        validators:{
                            notEmpty:{
                                message:"姓名不能为空！"
                            },
                            stringLength:{
                                max:20,
                                message:"字符长度不能超过20个字符"
                            }
                        }
                    },
                    employeeNo:{
                        validators:{
                            notEmpty:{
                                message:"员工编号不能为空"
                            },
                            stringLength:{
                                max:20,
                                message:"字符长度不能超过20个字符"
                            }
                        }
                    }
                }
            });
        },
        //搜索
        searchEmployee:function () {
            $("#employee-table").bootstrapTable('refresh');
        },
        //清空
        empty:function () {
            $("#search_employee_no").val('');
            $("#search_employee_name").val('');
            $("#employee-table").bootstrapTable('refresh');
        }
    }
}();
$(document).ready(function(){
  	 $("#department_name").click(function() {
  		$("#parentIdtreeview").show();
  		 $.ajax({
  		        url:'dept/getDeptTree',
  		        dataType:'json',
  		        type:'post',
  		        data:{rid:1},
  		        success:function(data){
  		        	$('#parentIdtreeview').treeview({
  	                     color: "#428bca",
  	                     expandIcon: 'glyphicon glyphicon-chevron-right',
  	                     collapseIcon: 'glyphicon glyphicon-chevron-down',
  	                     nodeIcon: 'glyphicon glyphicon-bookmark',
  	                     data: data,
  	                     onNodeSelected: function(event, node) {
  	                    		$("#department_name").val(node.text);
  	                    		$("#employee_dept_id").val(node.id);
  	        					$("#parentIdtreeview").hide();
  	                       },
  	                   });
  		        }
  		      });
  		});
  	 	
     	 $("#update_departmentname").click(function() {
       		$("#update_parentIdtreeview").show();
       		 $.ajax({
       		        url:'dept/getDeptTree',
       		        dataType:'json',
       		        type:'post',
       		        data:{rid:1},
       		        success:function(data){
       		        	$('#update_parentIdtreeview').treeview({
       	                     color: "#428bca",
       	                     expandIcon: 'glyphicon glyphicon-chevron-right',
       	                     collapseIcon: 'glyphicon glyphicon-chevron-down',
       	                     nodeIcon: 'glyphicon glyphicon-bookmark',
       	                     data: data,
       	                     onNodeSelected: function(event, node) {
       	                    		$("#update_departmentname").val(node.text);
       	                    		$("#employee_update_dept_id").val(node.id);
       	        					$("#update_parentIdtreeview").hide();
       	                       },
       	                   });
       		        }
       		      });
       		});
  });
