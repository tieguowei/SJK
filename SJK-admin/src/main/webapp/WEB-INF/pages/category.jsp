<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/include/core.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>品类管理</title>
	<link rel="stylesheet" href="${path}/css/category/category.css">
	<script src="${path}/js/category/category.js" charset="UTF-8" type="text/javascript"></script>
</head>
<body>

<div class="panel panel-default">
	<div class="panel-body">
		<font color="red" size="2" >品类参考：</font>
		香烟	零食	饮料/水	酒类	水果	坚果炒货	纸制品 	袜子	个人洗护 	女生护理 
	</div>
</div>


<table id="category_table" class="table table-hover table-striped table-condensed table-bordered"></table>

<!--toolbar  -->
<div id="toolbar" class="btn-toolbar">

<shiro:hasPermission name="categoryManager:add">
		
  <button onclick="Category.openDlg()" type="button" class="btn btn-success" style="margin-left: 1015px;">
      <span class="glyphicon glyphicon-plus" aria-hidden="true">添加</span>
    </button>
 </shiro:hasPermission>
   
</div>

<!-- 模态框（Modal） -->
<!-- 添加品类 -->
<div id="addDlg" class="modal fade" id="myModal" tabindex="-1" role="dialog" data-backdrop="static" data-keyboard="false" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">添加品类</h4>
            </div>
            <div class="container">
			<form class="form-horizontal" id="addForm"  method="post">
			
			<div class="form-group">
					<label class="col-md-2 control-label">品类名称：</label>
					<div class="col-md-3 ">
						<input type="text"  id="name" name="name" class="form-control form-control-static" placeholder="请输入品类名称">
					</div>
			</div>
            <div class="modal-footer col-md-6">
            <!--用来清空表单数据-->
            <input type="reset" name="reset" style="display: none;" />
                <button type="button" class="btn btn-default" onclick="Category.closeDlg()">关闭</button>
               <button type="button" onclick="Category.saveCategory()" class="btn btn-primary">提交</button>
            </div>
            </form>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div> 


<!-- 模态框（Modal） -->
<!-- 修改品类信息 -->
<div id="updateDlg" class="modal fade" id="myModal" tabindex="-1" role="dialog" data-backdrop="static" data-keyboard="false" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">修改品类</h4>
            </div>
            <div class="container">
			<form class="form-horizontal" id="updateForm"  method="post">
			
			<div class="form-group">
					<label class="col-md-2 control-label">品类名称：</label>
					<div class="col-md-3 ">
						<input type="hidden"  id="update_id" name="id">
						<input type="text"  id="update_category_name" name="name" class="form-control form-control-static" placeholder="请输入品类名称">
					</div>
			</div>
            <div class="modal-footer col-md-6">
            <!--用来清空表单数据-->
            <input type="reset" name="reset" style="display: none;" />
                <button type="button" class="btn btn-default" onclick="Category.closeDlg()">关闭</button>
               <button type="button" onclick="Category.updateCategory()" class="btn btn-primary">提交</button>
            </div>
            </form>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div> 

</body>
</html>