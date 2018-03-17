<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/core.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>菜单管理</title>
<style type="text/css">
 .modal {
    position: fixed;  
    top: 4%;
    left: 30%;
    width: 800px;
    height: 800px;
     margin: 100px 100 0 0px;/* margin 负值为宽高的一半 */ */
} 
</style>
<script type="text/javascript">
$(function (){
	
	formValidator();
	
	
	$("#menu-table").bootstrapTable('destroy');
	$('#menu-table').bootstrapTable({
		method : 'GET', //默认是post,不允许对静态文件访问
		url: "${path }/menu/getMenuList",
		cache : false,
		striped : true,// 隔行加亮
		pagination : true, //开启分页功能    在表格底部显示分页工具栏
		pageSize : 5, //默认每页条数
		pageNumber : 1, //默认分页
		pageList : [ 10, 20, 50, 100, 200, 500 ],//分页数
		showColumns : true, //显示隐藏列
		showRefresh : false, //显示刷新按钮
		toolbar:"#toolbar",
		singleselect : true,
		minimumCountColumns: 2,// 设置最少显示列个数
        clickToSelect: true, // 单击行即可以选中
		search : false,//显示搜素表单
		silent : true, //刷新事件必须设置
		sidePagination : "server", //表示服务端请求  
		columns : [ /* {
			checkbox:true
		}   , */{
			field : "menu_id",
			title : "菜单编号",
			class : 'col-md-1',
			align : "center",
			valign : "middle",
			sortable : "true"
		}, {
			field : "name_zh",
			title : "菜单名称",
			align : "center",
			valign : "middle",
			sortable : "true"
		}, {
			field : "menu_url",
			title : "请求地址",
			align : "center",
			valign : "middle",
			sortable : "true"
		}, {
			field : "menu_icon",
			title : "图标样式",
			align : "center",
			valign : "middle",
			sortable : "true"
		}, {
			field : "menu_type",
			title : "菜单类型",
			align : "center",
			valign : "middle",
			sortable : "true"
		}, {
			field : "permission",
			title : "权限编码",
			align : "center",
			valign : "middle",
			sortable : "true"
		}, {
			field : "menu_status",
			title : "状态",
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
		queryParamsType: "undefined",
        queryParams: function queryParams(params) {   //设置查询参数
            var param = {
                pageNumber: params.pageNumber,
                pageSize: params.pageSize,
            };
            return param;
        },
		formatLoadingMessage : function() {
			return "请稍等，正在加载中...";
		},

		formatNoMatches : function() {
			return '无符合条件的记录';
		}
	});
});

function operateFormatter(value, row, index) {
    return ['<button type="button" class=" btn btn-info" onclick="getValue('+row.menu_id+')">修改</button>',
        '&nbsp;&nbsp;&nbsp;<button class=" btn btn-danger" type="button" onclick="delMenu('+row.menu_id+')">删除</button>'
        ].join('');
}

//删除
function delMenu(id){
	
    $.confirm({
        title: '提示信息!',
        content: '您确定要删除这条数据吗？',
        type: 'blue',
        typeAnimated: true,
        buttons: {
            	确定: {
                action: function(){
                	$.ajax({
            			url:'menu/deleteMenu',
            			dataType:'json',
            			type:'post',
            			data:{
            				menuId:id
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
            				$("#menu-table").bootstrapTable('refresh');
            			},
            			error:function(){
            				alert("请求失败！");
            			}
            		});
                }
            },
          	  取消: function () {
            }
        }
    });
}


//添加
function saveMenu(){
	
		if($("#addForm").data('bootstrapValidator').validate().isValid()){
			$.ajax({
				url:'menu/saveMenu',
				dataType:'json',
				type:'post',
				data:$("#addForm").serialize(),
				success:function(data){
					if(data == '0'){
					    $.alert({
					        title: '提示信息！',
					        content: '菜单名称已存在!',
					        type: 'blue'
					    });
					}else if(data == '1'){
						$.alert({
					        title: '提示信息！',
					        content: '添加成功!',
					        type: 'blue'
					    });
					}else{
						$.alert({
					        title: '提示信息！',
					        content: '添加失败！',
					        type: 'red'
					    });
					}
				$("#menu-table").bootstrapTable('refresh');
				closeDlg();
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
//打开  添加 加载pid为0的菜单
function addMenu(){
	
	$.ajax({
		url:'menu/getParentMenuList',
		dataType:'json',
		type:'post',
		success:function(data){
			$("#parentId").empty();
			$("#parentId").append("<option value='0'>请选择</option>");
			$.each(data,function(index,items){
				$("#parentId").append("<option value="+items.menuId+">"+items.menuName+"</option>");
			});
		},
		error:function(){
			alert("请求失败！");
		}
	});
	$("#addDlg").modal('show');
}



function formValidator(){

	$("#addForm").bootstrapValidator({
		fields:{
			nameZh:{
				validators:{
					notEmpty:{
						message:"菜单名称不能为空"
					},
					stringLength:{
						max:20,
						message:"字符长度不能超过20个字符"
					}
				}
			},
			menuIcon:{
				validators:{
					notEmpty:{
						message:'图标样式不能为空'
					}
				}
			},
			menuType:{
				validators:{
					notEmpty:{
						message:'菜单类型不能为空'
					}
				}
			},
			permission:{
				validators:{
					notEmpty:{
						message:'权限标识不能为空'
					}
				}
			}
		}
	});
	

	$("#updateForm").bootstrapValidator({
		fields:{
			nameZh:{
				validators:{
					notEmpty:{
						message:"菜单名称不能为空"
					},
					stringLength:{
						max:20,
						message:"字符长度不能超过20个字符"
					}
				}
			},
			menuIcon:{
				validators:{
					notEmpty:{
						message:'图标样式不能为空'
					}
				}
			},
			menuType:{
				validators:{
					notEmpty:{
						message:'菜单类型不能为空'
					}
				}
			},
			permission:{
				validators:{
					notEmpty:{
						message:'权限标识不能为空'
					}
				}
			}
		}
	}); 
}


//修改 回显
function getValue(id){

	$.ajax({
		url:'menu/getMenuById',
		dataType:'json',
		type:'post',
		data:{
			mid:id
		}, 	 	
		success:function(data){
			$("#update_menu_id").val(id);
			$("#update_menu_name").val(data.menu.nameZh);
			$("#update_menu_url").val(data.menu.menuUrl);
			$("#update_menu_icon").val(data.menu.menuIcon);
			$("#update_menu_type").val(data.menu.menuType);
			$("#update_menu_permission").val(data.menu.permission);
			if(data.menu.menuStatus=='2'){
				$("#close").prop('checked',true);
			}else{
				$("#open").prop('checked',true);
			}
			
			$("#update_menu_parentId").empty();
			$("#update_menu_parentId").append("<option value='0'>请选择</option>");
			$.each(data.list,function(index,items){
				if(data.menu.parentId==items.menuId){
					$("#update_menu_parentId").append("<option selected value="+items.menuId+">"+items.menuName+"</option>");
				}else{
					$("#update_menu_parentId").append("<option value="+items.menuId+">"+items.menuName+"</option>");
				}
				
				
			});
		},
		error:function(){
			alert("请求失败！");
		}
	});
	$("#updateDlg").modal('show');

}



//修改
function updateMenu(){

		if($("#updateForm").data('bootstrapValidator').validate().isValid()){
			$.ajax({
				url:'menu/updateMenu',
				dataType:'json',
				type:'post',
				data:$("#updateForm").serialize(),
				success:function(data){
					if(data == '1'){
						$.alert({
					        title: '提示信息！',
					        content: '修改成功!',
					        type: 'blue'
					    });
					}else{
						$.alert({
					        title: '提示信息！',
					        content: '修改失败！',
					        type: 'red'
					    });
					}
					$("#menu-table").bootstrapTable('refresh');
					closeDlg();
				},
				error:function(){
					  $.alert({
					        title: '提示信息！',
					        content: '修改失败!',
					        type: 'red'
					    });
				}
			}); 
		}
}

//关闭
function closeDlg(){
	$("#addDlg").modal('hide');
	$("#updateDlg").modal('hide');
	$("input[type=reset]").trigger("click");
	$('#updateForm').data('bootstrapValidator', null);
	$('#addForm').data('bootstrapValidator', null);
	formValidator();
}
</script>
</head>
<body>
<table id="menu-table" class="table table-hover table-striped table-condensed table-bordered"></table>

<!--toolbar  -->
<div id="toolbar" class="btn-toolbar">
    <button onclick="addMenu()" type="button" class="btn btn-success" style="margin-left: 956px;">
      <span class="glyphicon  con-plus" aria-hidden="true" >添加</span>
    </button>
</div>


<!-- 模态框（Modal） -->
<!-- 添加菜单 -->
<div id="addDlg" class="modal fade" tabindex="-1" role="dialog" data-backdrop="static" data-keyboard="false" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">添加菜单</h4>
            </div>
            <div class="container">
			<form class="form-horizontal" id="addForm"  method="post">
			
			<div class="form-group">
			<label class="col-md-2 control-label">菜单名称：</label>
			<div class="col-md-3 ">
			<input type="text"  name="nameZh" class="form-control form-control-static" placeholder="请输入菜单名称">
			</div>
			<label class="control-label"><span id="info" style="color:red"></span></label>
			</div>
			
			<div class="form-group">
			<label class="col-md-2 control-label">请求地址：</label>
			<div class="col-md-3">
			<input type="text"  name="menuUrl" class="form-control form-control-static" placeholder="请输入请求地址" >
			</div>
			</div>
			
			<div class="form-group">
			<label class="col-md-2 control-label">菜单类型：</label>
			<div class="col-md-3">
			<input type="text"  name="menuType" class="form-control form-control-static" placeholder="请输入菜单类型" >
			</div>
			</div>
			
			
			<div class="form-group">
			<label class="col-md-2 control-label">权限标识：</label>
			<div class="col-md-3">
			<input type="text"  name="permission" class="form-control form-control-static" placeholder="请输入权限标识" >
			</div>
			</div>
			
			<div class="form-group">
			<label class="col-md-2 control-label">父级菜单ID：</label>
			<div class="col-md-3">
			<select id="parentId" name="parentId" class="form-control form-control-static"></select>
			</div>
			</div>
			
			<div class="form-group">
			<label class="col-md-2 control-label">图标样式：</label>
			<div class="col-md-3">
			<input type="text"  name="menuIcon" class="form-control form-control-static" placeholder="请输入图标样式" >
			</div>
			</div>
			
			<div class="form-group">
			<label class="col-md-2 control-label">状态：</label>
			<div class="col-md-3" class="form-control form-control-static">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input   type="radio" checked name="menuStatus" value="1">启用&nbsp;&nbsp;&nbsp;&nbsp;
			<input  type="radio" name="menuStatus" value="2">禁用
			</div>
			</div>
            <div class="modal-footer col-md-6">
            <!--用来清空表单数据-->
            <input type="reset" name="reset" style="display: none;" />
                <button type="button" class="btn btn-default" onclick="closeDlg()">关闭</button>
               <button type="button" onclick="saveMenu()" class="btn btn-primary">保存</button>
            </div>
            </form>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>


<!-- 修改 -->
<div id="updateDlg" class="modal fade"  tabindex="-1" role="dialog" data-backdrop="static" data-keyboard="false" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">修改菜单</h4>
            </div>
            <div class="container">
			<form class="form-horizontal" id="updateForm"  method="post">
			<div class="form-group">
			<label class="col-md-2 control-label">菜单名称：</label>
			<div class="col-md-3 ">
			<input type="hidden" id="update_menu_id" name="menuId">
			<input type="text" id="update_menu_name" name="nameZh" class="form-control form-control-static" placeholder="请输入菜单名称">
			</div>
			<label class="control-label"><span id="info1" style="color:red"></span></label>
			</div>
			
			<div class="form-group">
			<label class="col-md-2 control-label">请求地址：</label>
			<div class="col-md-3">
			<input type="text" id="update_menu_url" name="menuUrl" class="form-control form-control-static" placeholder="请输入请求地址" >
			</div>
			</div>
			
			
			<div class="form-group">
			<label class="col-md-2 control-label">菜单类型：</label>
			<div class="col-md-3">
			<input type="text"  id="update_menu_type" name="menuType" class="form-control form-control-static" placeholder="请输入菜单类型" >
			</div>
			</div>
			
			
			<div class="form-group">
			<label class="col-md-2 control-label">权限标识：</label>
			<div class="col-md-3">
			<input type="text"id="update_menu_permission"  name="permission" class="form-control form-control-static" placeholder="请输入权限标识" >
			</div>
			</div>
			
			
			
			<div class="form-group">
			<label class="col-md-2 control-label">父级菜单ID：</label>
			<div class="col-md-3">
			<select  id="update_menu_parentId" name="parentId" class="form-control form-control-static"></select>
			</div>
			</div>
			
			<div class="form-group">
			<label class="col-md-2 control-label">图标样式：</label>
			<div class="col-md-3">
			<input type="text" id="update_menu_icon" name="menuIcon" class="form-control form-control-static" placeholder="请输入图标样式" >
			</div>
			</div>
			
			<div class="form-group">
			<label class="col-md-2 control-label">状态：</label>
			<div class="col-md-3" class="form-control form-control-static">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input id="open"  type="radio" checked name="menuStatus" value="1">启用&nbsp;&nbsp;&nbsp;&nbsp;
			<input id="close" type="radio" name="menuStatus" value="2">禁用
			</div>
			</div>
            <div class="modal-footer col-md-6">
            <!--用来清空表单数据-->
            <input type="reset" name="reset" style="display: none;" />
                <button type="button" class="btn btn-default" onclick="closeDlg()">关闭</button>
               <button type="button" onclick="updateMenu()" class="btn btn-primary">保存</button>
            </div>
            </form>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

</body>
</html>