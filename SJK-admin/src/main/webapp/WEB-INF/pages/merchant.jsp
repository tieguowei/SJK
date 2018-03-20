<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/include/core.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>商户管理</title>
<style type="text/css">
 #roleDlg {
     position: fixed;  
    top: 15%;
    left: 30%;
    width: 800px;
    height: 800px;
     margin: 100px 100 0 0px;/* margin 负值为宽高的一半 */ 
}
#addDlg,#updateDlg{
    position: fixed;  
    top: 0%;
    left: 30%;
    width: 800px;
    height: 800px;
     margin: 100px 100 0 0px;/* margin 负值为宽高的一半 */ 
} 
</style>
<script type="text/javascript">

/**
 * 用户
 */
$(function (){
	//select2 多选
    $("#rid").select2({
        language: "zh-CN", //设置 提示语言
        maximumSelectionLength: 3,  //设置最多可以选择多少项
         //width: "100%", //设置下拉框的宽度
         placeholder: "请选择",
         tags: true,
    });
    formValidator();
	init();
}); 
    
function init () {
	   $('#merchant-table').bootstrapTable({
		      url: "${path }/merchant/getMerchantList",
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
					title : "商户编号",
					align : "center",
					valign : "middle",
					sortable : "true"
				}, {
					field : "merchant_name",
					title : "商户名称",
					align : "center",
					valign : "middle",
					sortable : "true"
				}, {
					field : "merchant_code",
					title : "商户编码",
					align : "center",
					valign : "middle",
					sortable : "true"
				},{
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
		       	merchantCode: $("#merchant_code").val(),
		       	merchantName:$("#merchant_name").val(),
		      };
		      return temp;
		    };
		  }

function operateFormatter(value, row, index) {
    return ['<shiro:hasPermission name="merchantManager:add"><button type="button" class=" btn btn-warning" onclick="getRole('+row.id+')">角色</button></shiro:hasPermission>',
        '<shiro:hasPermission name="merchantManager:update"><button type="button" class=" btn btn-info" onclick="openUpdateModal('+row.id+')">修改</button></shiro:hasPermission>',
        '<shiro:hasPermission name="merchantManager:delete"><button class=" btn btn-danger" type="button" onclick="deleteRole('+row.id+')">删除</button></shiro:hasPermission>'
        ].join('');
}




//角色分配
function getRole(id){
	$("#merchantId").val(id);
	$.ajax({
		url:'${path}/merchant/getRole',
		dataType:'json',
		type:'post',
		traditional:true,
		data:{
			id:id
		},
		success:function(data){
			$("#rid").empty();
			$.each(data.role,function(index,items){
				$("#rid").append("<option value='"+items.id+"'>"+items.roleName+"</option>");
			});
			if((data.userRole!=null)){
				$.each(data.userRole,function(index,items){
					$("#rid").val(data.userRole).trigger("change");//select2 选中
				});
			}else{
				$("#rid").val(0).trigger("change");
			}
		},
		error:function(){
			$.alert({
		        title: '提示信息！',
		        content: '请求失败！',
		        type: 'red'
		    });
		}
	})
	$("#roleDlg").modal('show');
}
//保存修改角色
function saveRole(){
	var merchantId=$("#merchantId").val();
	
	var rids=$("#rid").val();//select2 获取多选值
	$.ajax({				
		url:'${path}/merchant/updateMerchantRole',
		dataType:'json',
		type:'post',
		traditional:true,
		data:{
			merchantId:merchantId,
			rid:rids
		},
		success:function(data){
			if(data){
				$.alert({
			        title: '提示信息！',
			        content: '保存成功！',
			        type: 'blue'
			    });
			}else{
				$.alert({
			        title: '提示信息！',
			        content: '保存失败！',
			        type: 'red'
			    });
			}
			closeDlg();
			$('#merchant-table').bootstrapTable('refresh'); 
		}
	})
};

//修改前，打开模态框
function getValue(id){
	$.ajax({
		url:'user/getUserById.action',
		dataType:'json',
		type:'post',
		data:{
			uid:id
		},
		success:function(data){
			$("#user_id1").val(data.user.user_id);
			$("#user_account1").val(data.user.user_account);
			$("#user_password1").val(data.user.user_password);
			$("#user_name1").val(data.user.user_name);
			$("#user_age1").val(data.user.user_age);
			$("#user_address1").val(data.user.user_address);
			$("#user_birth1").val(data.user.birthStr);
			$("#email1").val(data.user.email);
			$("#user_phone1").val(data.user.user_phone);
			
			if("男"==data.user.user_sex){
				$("#nan1").prop('checked',true);
			}else{
				$("#nv1").prop('checked',true);
			}
			
			$("#sid1").empty();
			$("#sid1").append("<option value='0'>请选择</option>");
			$.each(data.dept,function(){
				if(data.user.dept_id==this.dept_id){
					$("#sid1").append("<option selected value='"+this.dept_id+"'>"+this.dept_name+"</option>");
				}else{
					$("#sid1").append("<option value='"+this.dept_id+"'>"+this.dept_name+"</option>");
				}
			});
			$("#updateDlg").modal('show');
		},
		error:function(){
			alert('请求失败！');
		}
	});
}
//修改用户
function upUser(){
		if($("#myform1").data("bootstrapValidator").validate().isValid()){
			$.ajax({
				url:'user/upUser.action',
				dataType:'json',
				type:'post',
				data:$("#myform1").serialize(),
				success:function(data){
					if(data>0){
						alert("修改成功！");
					}else{
						alert("修改失败！");
					}
					closeDlg();
					$("#merchant-table").bootstrapTable('refresh');
				}
			});
		}else{
			alert("请按规则填写信息");
		}
}

//删除员工
function delUser(id){
	if(confirm("您确定要删除这条数据吗?")){
		$.ajax({
			url:'user/delUser.action',
			dataType:'json',
			type:'post',
			data:{uid:id},
			success:function(data){
				if(data>0){
					alert("删除成功！");
				}else{
					alert("删除失败！");
				}
				$("#merchant-table").bootstrapTable('refresh');
			},
			error:function(){
				alert("请求失败！");
			}
		});
	}
}
//添加，打开模态框
function openDlg(){
	$("#addDlg").modal('show');
};

//添加用户
function saveMerchant(){
		if($("#addForm").data('bootstrapValidator').validate().isValid()){
			$.ajax({
				url:'${path}/merchant/saveMerchant',
				type:'post',
				dataType:'json',
				data:$("#addForm").serialize(),
				success:function(data){
					if(data>0){
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
					$("#merchant-table").bootstrapTable('refresh');
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

//关闭模态框
function closeDlg(){
	$("#roleDlg").modal('hide');
	$("#updateDlg").modal('hide');
	$("#addDlg").modal('hide');
	$('#addForm').data('bootstrapValidator', null);
	$('#updateForm').data('bootstrapValidator', null);
	formValidator();
};

function formValidator(){
	$("#addForm").bootstrapValidator({
		fields:{
			merchantName:{
				validators:{
					notEmpty:{
						message:"管理员名称不能为空"
					},
					stringLength:{
						max:20,
						message:"字符长度不能超过20个字符"
					}
				}
			},
			merchantCode:{
				validators:{
					notEmpty:{
						message:"管理员账号不能为空"
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
			merchantName:{
				validators:{
					notEmpty:{
						message:"管理员名称不能为空"
					},
					stringLength:{
						max:20,
						message:"字符长度不能超过20个字符"
					}
				}
			},
			merchantCode:{
				validators:{
					notEmpty:{
						message:"管理员账号不能为空"
					},
					stringLength:{
						max:20,
						message:"字符长度不能超过20个字符"
					}
				}
			}
		}
	});
	
}

//搜索
function searchMerchant() {
	  $("#merchant-table").bootstrapTable('refresh');
}
//清空
function empty(){
	$("#merchant_code").val('');
	$("#merchant_name").val('');
	 $("#merchant-table").bootstrapTable('refresh');
}

</script>
</head>
<body>



<div class="panel panel-default">
	<div class="panel-body">
		<form id="conForm" class=" form-inline">
		  <div class="form-group">
		    <div class="col-md-2 ">
		    <input type="text" class="form-control" id="merchant_code" placeholder="请输入商户编码">
		    </div>
		  </div>
		  
		   <div class="form-group">
		    <div class="col-md-2 ">
		    <input type="text" class="form-control" id="merchant_name" placeholder="请输入商户名称">
		    </div>
		  </div>
  		<button type="button" onclick="searchMerchant()" class="btn btn-info ">
   			<span class="glyphicon glyphicon-search" aria-hidden="true" >  搜索</span>
   		</button>
   		<button type="button" onclick="empty()" class="btn btn-danger ">
   			<span class="glyphicon glyphicon-remove" aria-hidden="true" > 清空</span>
   		</button>
</form>
	</div>
</div>


<table id="merchant-table" class="table table-hover table-striped table-condensed table-bordered"></table>

<!--toolbar  -->
<div id="toolbar" class="btn-toolbar">

<shiro:hasPermission name="merchantManager:add">
		
  <button onclick="openDlg()" type="button" class="btn btn-success" style="margin-left: 1015px;">
      <span class="glyphicon glyphicon-plus" aria-hidden="true">添加</span>
    </button>
 </shiro:hasPermission>
   
</div>

<!-- 模态框（Modal） -->
<!-- 添加用户 -->
<div id="addDlg" class="modal fade" id="myModal" tabindex="-1" role="dialog" data-backdrop="static" data-keyboard="false" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">添加管理员</h4>
            </div>
            <div class="container">
			<form class="form-horizontal" id="addForm"  method="post">
			
			<div class="form-group">
					<label class="col-md-2 control-label">管理员名称：</label>
					<div class="col-md-3 ">
						<input type="text"  id="merchant_name" name="merchantName" class="form-control form-control-static" placeholder="请输入管理员名称">
					</div>
			</div>
				
				<div class="form-group">
					<label class="col-md-2 control-label">管理员账号：</label>
					<div class="col-md-3 ">
						<input type="text"  id="merchant_code" name="merchantCode" class="form-control form-control-static" placeholder="请输入管理员账号">
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-md-2 control-label">默认密码：</label>
					<div class="col-md-3 ">
						<input type="text"  id="password" name="password" value="123456" class="form-control form-control-static" placeholder="123456" readonly="readonly">
					</div>
				</div>
            <div class="modal-footer col-md-6">
            <!--用来清空表单数据-->
            <input type="reset" name="reset" style="display: none;" />
                <button type="button" class="btn btn-default" onclick="closeDlg()">关闭</button>
               <button type="button" onclick="saveMerchant()" class="btn btn-primary">提交</button>
            </div>
            </form>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div> 


<!-- 模态框（Modal） -->
<!-- 修改商户信息 -->
<div id="updateDlg" class="modal fade" id="myModal" tabindex="-1" role="dialog" data-backdrop="static" data-keyboard="false" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
        
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">添加管理员</h4>
            </div>
            <div class="container">
			<form class="form-horizontal" id="updateForm"  method="post">
			<div class="form-group">
			<label class="col-md-2 control-label">登录账号：</label>
			<div class="col-md-3 ">
			<input type="text"  id="user_account" name="user_account" class="form-control form-control-static" placeholder="请输入登陆账号">
			</div>
			<label class="control-label"><span id="mid" style="color:red"></span></label>
			</div>
            <div class="modal-footer col-md-6">
            <!--用来清空表单数据-->
            <input type="reset" name="reset" style="display: none;" />
                <button type="button" class="btn btn-default" onclick="closeDlg()">关闭</button>
               <button type="button" onclick="saveUser()" class="btn btn-primary">提交</button>
            </div>
            </form>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div> 



<!-- 模态框（Modal） -->
<!-- 角色分配-->
<div id="roleDlg" class="modal fade" tabindex="-1" role="dialog" data-backdrop="static" data-keyboard="false" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">分配角色</h4>
            </div>
            <div class="container">
			<form class="form-horizontal" id="roleForm"  method="post">
			
			<div class="form-group">
			<label class="col-md-2 control-label">我的角色：</label>
			<div class="col-md-3 ">
			<input type="hidden" id="merchantId" >
			<select  style= "width:280px" id="rid" name="role" multiple="multiple"  class="form-control form-control-static "></select>
			</div>
			</div>
            <div class="modal-footer col-md-6">
            <!--用来清空表单数据-->
            <input type="reset" name="reset" style="display: none;" />
                <button type="button" class="btn btn-default" onclick="closeDlg()">关闭</button>
               <button type="button" onclick="saveRole()" class="btn btn-primary">保存</button>
            </div>
            </form>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>



</body>
</html>