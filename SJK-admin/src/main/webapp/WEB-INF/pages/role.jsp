<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/include/core.jsp" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>角色管理</title>
<script type="text/javascript">
 $(function(){
	formValidator();
	init();
}); 

function init() {
	   $('#role-table').bootstrapTable({
		      url: "${path }/role/getRoleList",
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
		      queryParams: queryParams,//传递参数（*）
		      columns : [{
					field : "id",
					title : "角色编号",
					class : 'col-md-1',
					align : "center",
					valign : "middle",
					sortable : "true"
				},{
					field : "role_name",
					title : "角色名称",
					align : "center",
					valign : "middle",
					sortable : "true"
				}, {
					field : "role_code",
					title : "角色编码",
					align : "center",
					valign : "middle",
					sortable : "true"
				},{
					field : "remark",
					title : "角色描述",
					align : "center",
					valign : "middle",
					sortable : "true"
				}, {
		            field: 'operate',
		            title: '操作',
		           class : 'col-md-2',
		            align: 'center',
		            valign: 'middle',
		           formatter: operateFormatter,
		        }],
				formatLoadingMessage : function() {
					return "请稍等，正在加载中...";
				},
				formatNoMatches : function() {
					return '无符合条件的记录';
				}
		    });
		    //得到查询的参数
		    function queryParams (params) {
		      var temp = { 
		        pageSize: params.pageSize,  //页面大小
		        pageNumber: params.pageNumber, //页码
		      };
		      return temp;
		    };
		  }
		 


function operateFormatter(value, row, index) {
    return ['<button type="button" class=" btn btn-warning" onclick="getAuth('+row.id+')">权限</button>',
        '<button type="button" class=" btn btn-info" onclick="openUpdateModal('+row.id+')">修改</button>',
        '<button class=" btn btn-danger" type="button" onclick="deleteRole('+row.id+')">删除</button>'
        ].join('');
}


//打开添加模态框
function openAddModal(){
	$("#addDlg").modal('show');
}

//添加
function addRole(){
		if($("#addForm").data('bootstrapValidator').validate().isValid()){
			$.ajax({
				url:'${path}/role/saveRole',
				dataType:'json',
				type:'post',
				data:$("#addForm").serialize(),
				success:function(data){
					if(data == '0'){
					    $.alert({
					        title: '提示信息！',
					        content: '角色编码已存在!',
					        type: 'red'
					    });
					}else if(data == '1'){
						$.alert({
					        title: '提示信息！',
					        content: '添加成功!',
					        type: 'blue'
					    });
						$("#role-table").bootstrapTable("refresh");
						closeDlg();
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

//打开修改模态框
function openUpdateModal(id){
	$.ajax({
		url:'${path}/role/getRoleById',
		dataType:'json',
		type:'post',
		data:{rid:id},
		success:function(data){
			$("#role_update_id").val(id);
			$("#role_update_roleName").val(data.role.roleName);
			$("#role_update_roleCode").val(data.role.roleCode);
			$("#role_update_remark").val(data.role.remark);
		},
		error:function(){
			$.alert({
		        title: '提示信息！',
		        content: '请求失败！',
		        type: 'red'
		    });
		}
	});
	$("#mydlg").modal('show');
}
//修改角色
function updateRole(){
	
	if($("#updateForm").data('bootstrapValidator').validate().isValid()){
		$.ajax({
			url:'${path}/role/updateRole',
			dataType:'json',
			type:'post',
			data:$("#updateForm").serialize(),
			success:function(data){
				if(data == '0'){
				    $.alert({
				        title: '提示信息！',
				        content: '角色编码已存在!',
				        type: 'red'
				    });
				}else if(data == '1'){
					$.alert({
				        title: '提示信息！',
				        content: '修改成功!',
				        type: 'blue'
				    });
					$("#role-table").bootstrapTable("refresh");
					closeDlg();
				}else{
					$.alert({
				        title: '提示信息！',
				        content: '修改失败！',
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

//删除角色
function deleteRole(id){
	  $.confirm({
	        title: '提示信息!',
	        content: '您确定要删除这个角色吗？',
	        type: 'blue',
	        typeAnimated: true,
	        buttons: {
	            	确定: {
	                action: function(){
	                	$.ajax({
	            			url:'role/deleteRole',
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
	            				$("#role-table").bootstrapTable('refresh');
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
//关闭模态框
function closeDlg(){
	$("#authDlg").modal('hide');
	$("#addDlg").modal('hide');
	$("#mydlg").modal('hide');
	$('#updateForm').data('bootstrapValidator', null);
	$('#addForm').data('bootstrapValidator', null);
	formValidator();
}

//表单验证
function formValidator(){
	$("#addForm").bootstrapValidator({
		fields:{
			roleName:{
				validators:{
					notEmpty:{
						message:"角色名称不能为空"
					},
					stringLength:{
						max:20,
						message:'不能超过20个字符长度'
					},
				}
			},
			roleCode:{
				validators:{
					notEmpty:{
						message:'角色编码不能为空',
					},
					stringLength:{
						max:200,
						message:'字符长度不能超过20'
					}
				}
			},
			remark:{
				validators:{
					notEmpty:{
						message:'角色描述不能为空',
					},
					stringLength:{
						max:200,
						message:'字符长度不能超过200'
					}
				}
			}
		}
	});
	

	$("#updateForm").bootstrapValidator({
		fields:{
			roleName:{
				validators:{
					notEmpty:{
						message:"角色名称不能为空"
					},
					stringLength:{
						max:20,
						message:'不能超过20个字符长度'
					},
				}
			},
			roleCode:{
				validators:{
					notEmpty:{
						message:'角色编码不能为空',
					},
					stringLength:{
						max:200,
						message:'字符长度不能超过20'
					}
				}
			},
			remark:{
				validators:{
					notEmpty:{
						message:'角色描述不能为空',
					},
					stringLength:{
						max:200,
						message:'字符长度不能超过200'
					}
				}
			}
		}
	});
}
</script>
</head>
<body>
<table id="role-table" class="table table-hover table-striped table-condensed table-bordered"></table>

<!--toolbar  -->
<div id="toolbar" class="btn-toolbar">
    <button onclick="openAddModal()" type="button" class="btn btn-success" style="margin-left: 1030px;">
      <span class="glyphicon glyphicon-plus" aria-hidden="true">添加</span>
    </button>
</div>

<!-- 模态框（Modal） -->
<!-- 添加部门 -->
<div id="addDlg" class="modal fade" tabindex="-1" role="dialog" data-backdrop="static" data-keyboard="false" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">添加角色</h4>
            </div>
            <div class="container">
			<form class="form-horizontal" id="addForm"  method="post">
			
			<div class="form-group">
			<label class="col-md-2 control-label">角色名称：</label>
			<div class="col-md-3 ">
			<input type="text" id="role_name"  name="roleName" class="form-control form-control-static" placeholder="请输入角色名称">
			</div>
			</div>
			
			<div class="form-group">
			<label class="col-md-2 control-label">角色编码：</label>
			<div class="col-md-3 ">
			<input type="text" id="role_code"  name="roleCode" class="form-control form-control-static" placeholder="请输入角色编码">
			</div>
			</div>
			
			<div class="form-group">
			<label class="col-md-2 control-label">角色描述：</label>
			<div class="col-md-3">
			<textarea rows="3" id="remark" name="remark" cols="30" class="form-control form-control-static" placeholder="请输入角色 描述"></textarea>
			</div>
			</div>
            <div class="modal-footer col-md-6">
            <!--用来清空表单数据-->
            <input type="reset" name="reset" style="display: none;" />
                <button type="button" class="btn btn-default" onclick="closeDlg()">关闭</button>
               <button type="button" onclick="addRole()" class="btn btn-primary">保存</button>
            </div>
            </form>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>


<!-- 模态框（Modal） -->
<!-- 修改 -->
<div id="mydlg" class="modal fade"  tabindex="-1" role="dialog" data-backdrop="static" data-keyboard="false" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">修改角色</h4>
            </div>
            <div class="container">
			<form class="form-horizontal" id="updateForm"  method="post">
			<div class="form-group">
			<div class="col-md-3 ">
			<input type="hidden" id="role_update_id" name="id"  class="form-control form-control-static" readonly="readonly" placeholder="必填">
			</div>
			</div>
			
			<div class="form-group">
			<label class="col-md-2 control-label">角色名称：</label>
			<div class="col-md-3 ">
			<input type="text" id="role_update_roleName"  name="roleName" class="form-control form-control-static" placeholder="必填">
			</div>
			</div>
			
			<div class="form-group">
			<label class="col-md-2 control-label">角色编码：</label>
			<div class="col-md-3">
			<input type="text" id="role_update_roleCode"  name="roleCode" class="form-control form-control-static" placeholder="必填">
			</div>
			</div>
			
			<div class="form-group">
			<label class="col-md-2 control-label">角色描述：</label>
			<div class="col-md-3">
			<textarea rows="3" id="role_update_remark" name="remark" cols="30" class="form-control form-control-static" placeholder="必填"></textarea>
			</div>
			</div>
            <div class="modal-footer col-md-6">
            <!--用来清空表单数据-->
            <input type="reset" name="reset" style="display: none;" />
                <button type="button" class="btn btn-default" onclick="closeDlg()">关闭</button>
               <button type="button" onclick="updateRole()" class="btn btn-primary">保存</button>
            </div>
            </form>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>


<!-- 模态框（Modal） -->
<!-- 权限-->
<div id="authDlg" class="modal fade" tabindex="-1" role="dialog" data-backdrop="static" data-keyboard="false" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">分配权限</h4>
            </div>
            <div class="container">
			<form class="form-horizontal" id="authForm"  method="post">
			
			<div class="form-group">
			<label class="col-md-2 control-label">角色权限：</label>
			<div class="col-md-3 ">
			<input type="hidden" id="rid" name="role_id">
			
			<div id="tree" ></div>
			</div>
			</div>
            <div class="modal-footer col-md-6">
            <!--用来清空表单数据-->
            <input type="reset" name="reset" style="display: none;" />
                <button type="button" class="btn btn-default" onclick="closeDlg()">关闭</button>
               <button type="button" onclick="saveAuth()" class="btn btn-primary">保存</button>
            </div>
            </form>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
</body>
</html>