
/**
 * 品类
 */
$(function (){
    Category.formValidator();
    Category.init();
});


var Category = function (){
    return{
        init:function (){
            $('#category_table').bootstrapTable({
                url: "category/getCategoryList",
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
                pageList : [ 10, 20, 50, 100, 200, 500 ],//分页数
                toolbar:"#toolbar",
                showColumns : false, //显示隐藏列
                uniqueId: "id", //每一行的唯一标识，一般为主键列
                queryParamsType:'',
                queryParams: Category.queryParams,//传递参数（*）
                columns : [{
                	field: 'SerialNumber',
            	    title: '品类编号',
            	    formatter: function (value, row, index) {
            	        return index+1;
            	    }
                }, {
                    field : "name",
                    title : "品类名称",
                    align : "center",
                    valign : "middle",
                    sortable : "true"
                },{
                    field: 'operate',
                    title: '操作',
                    class : 'col-md-2',
                    align: 'center',
                    valign: 'middle',
                    formatter: Category.operateFormatter,
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
            };
            return temp;
        },
        operateFormatter:function(value, row, index){
            return [
                '<shiro:hasPermission name="categoryManager:update"><button type="button" class=" btn btn-info" onclick="Category.openUpdateModal('+row.id+')">修改</button></shiro:hasPermission>',
                '<shiro:hasPermission name="categoryManager:delete"><button class=" btn btn-danger" type="button" onclick="Category.deleteCategory('+row.id+')">删除</button></shiro:hasPermission>'
            ].join('');
        },
        //修改前，打开模态框
        openUpdateModal:function(id){
            $.ajax({
                url:'category/getCategoryById',
                dataType:'json',
                type:'post',
                data:{
                    id:id
                },
                success:function(data){
                    $("#update_id").val(data.category.id);
                    $("#update_category_name").val(data.category.name);
                },
                error:function(){
                    $.alert({
                        title: '提示信息！',
                        content: '请求失败！',
                        type: 'red'
                    });
                }
            });
            $("#updateDlg").modal('show');
        },
        //修改品类
        updateCategory:function(){
            if($("#updateForm").data("bootstrapValidator").validate().isValid()){
               
            	flag = true;
    			//校验名称菜单名称是否存在
    			var name = $("#update_category_name").val();
    			var id = $("#update_id").val();
    			$.ajax({
    				url:'category/checkCategoryName',
    				dataType:'json',
    				data:{name:name,id:id},
    				type:'post',
    				async:false, //同步 验证后再执行
    				success:function(data){
    					if(!data){
    						flag = false;
    						$.alert({
    					        title: '提示信息！',
    					        content: '品类名称已存在！',
    					        type: 'red'
    					    });
    					}
    				}
    			})
    			if(flag){
            	$.ajax({
                    url:'category/updateCategory',
                    dataType:'json',
                    type:'post',
                    data:$("#updateForm").serialize(),
                    success:function(data){
                        if(data){
                            $.alert({
                                title: '提示信息！',
                                content: '修改成功！',
                                type: 'blue'
                            });
                        }else{
                            $.alert({
                                title: '提示信息！',
                                content: '修改失败！',
                                type: 'red'
                            });
                        }
                        Category.closeDlg();
                        $("#category_table").bootstrapTable('refresh');
                    }
                });
    			}
            }
        },
        //删除
        deleteCategory:function(id){
            $.confirm({
                title: '提示信息!',
                content: '您确定要删除这个品类吗？',
                type: 'blue',
                typeAnimated: true,
                buttons: {
                    确定: {
                        action: function(){
                            $.ajax({
                                url:'category/deleteCategory',
                                dataType:'json',
                                type:'post',
                                data:{
                                    id:id
                                },
                                success:function(data){
                                    if(data){
                                        $.alert({
                                            title: '提示信息！',
                                            content: '删除成功!',
                                            type: 'blue'
                                        });
                                    }else{
                                        $.alert({
                                            title: '提示信息！',
                                            content: '删除失败!',
                                            type: 'red'
                                        });
                                    }
                                    $("#category_table").bootstrapTable('refresh');
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
        },
        //添加，打开模态框
        openDlg:function(){
            $("#addDlg").modal('show');
        },
        //添加品类
        saveCategory:function(){
            if($("#addForm").data('bootstrapValidator').validate().isValid()){
            	flag = true;
    			//校验名称菜单名称是否存在
    			var name = $("#name").val();
    			$.ajax({
    				url:'category/checkCategoryName',
    				dataType:'json',
    				data:{name:name},
    				type:'post',
    				async:false, //同步 验证后再执行
    				success:function(data){
    					if(!data){
    						flag = false;
    						$.alert({
    					        title: '提示信息！',
    					        content: '品类名称已存在！',
    					        type: 'red'
    					    });
    					}
    				}
    			})
    			if(flag){
            	$.ajax({
                    url:'category/saveCategory',
                    type:'post',
                    dataType:'json',
                    data:$("#addForm").serialize(),
                    success:function(data){
                        if(data){
                            $.alert({
                                title: '提示信息！',
                                content: '添加成功!',
                                type: 'blue'
                            });
                            $("#category_table").bootstrapTable('refresh');
                            Category.closeDlg();
                        }else{
                            $.alert({
                                title: '提示信息！',
                                content: '添加失败！',
                                type: 'red'
                            });
                        }
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
            }
        },
        //关闭模态框
        closeDlg:function () {
        	$("#addDlg").modal('hide');
            $("#updateDlg").modal('hide');
            $("input[type=reset]").trigger("click");
            $('#updateForm').data('bootstrapValidator', null);
            $('#addForm').data('bootstrapValidator', null);
            Category.formValidator();
        },
        formValidator:function () {
            $("#addForm").bootstrapValidator({
                fields:{
                    name:{
                        validators:{
                            notEmpty:{
                                message:"品类名称不能为空"
                            },
                            stringLength:{
                                max:20,
                                message:"字符长度不能超过20个字符"
                            }
                        }
                    }
                }
            });


            $("#updateForm").bootstrapValidator({
                fields:{
                    name:{
                        validators:{
                            notEmpty:{
                                message:"品类名称不能为空"
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
        searchCategory:function () {
            $("#category_table").bootstrapTable('refresh');
        },
        //清空
        empty:function () {
            $("#Category_code").val('');
            $("#Category_name").val('');
            $("#category_table").bootstrapTable('refresh');
        }
    }
}();




//角色分配
function getRole(id){

}
//保存修改角色
function saveRole(){

};

//修改前，打开模态框
function openUpdateModal(id){

}
//修改品类
function updateCategory(){

}
//删除
function deleteCategory(id){

}


//添加，打开模态框
function openDlg(){
};

//添加品类
function saveCategory(){
}

//关闭模态框
function closeDlg(){
};

function formValidator(){
}

//搜索
function searchCategory() {
}
//清空
function empty(){
}