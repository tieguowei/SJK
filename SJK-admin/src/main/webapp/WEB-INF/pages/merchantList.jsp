<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/include/core.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>商户信息</title>
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


<table id="merchantList-table" class="table table-hover table-striped table-condensed table-bordered">

</table>

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
                <h4 class="modal-title" id="myModalLabel">修改管理员</h4>
            </div>
            <div class="container">
			<form class="form-horizontal" id="updateForm"  method="post">
			
			<div class="form-group">
					<label class="col-md-2 control-label">管理员名称：</label>
					<div class="col-md-3 ">
						<input type="hidden"  id="update_id" name="id">
						<input type="text"  id="update_merchant_name" name="merchantName" class="form-control form-control-static" placeholder="请输入管理员名称">
					</div>
			</div>
				<div class="form-group">
					<label class="col-md-2 control-label">密码还原：</label>
					<div class="col-md-3" class="form-control form-control-static">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input   type="radio" name="merchantStatus" value="1">是&nbsp;&nbsp;&nbsp;&nbsp;
					<input  type="radio" checked="checked"  name="merchantStatus" value="2">否
					</div>
				</div>
            <div class="modal-footer col-md-6">
            <!--用来清空表单数据-->
            <input type="reset" name="reset" style="display: none;" />
                <button type="button" class="btn btn-default" onclick="closeDlg()">关闭</button>
               <button type="button" onclick="updateMerchant()" class="btn btn-primary">提交</button>
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