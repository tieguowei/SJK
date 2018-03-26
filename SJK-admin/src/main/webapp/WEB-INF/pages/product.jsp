<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/include/core.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>商品管理</title>
    <link rel="stylesheet" href="${path}/css/product/product.css">
    <script src="${path}/js/product/product.js" charset="UTF-8" type="text/javascript"></script>
</head>
<script type="text/javascript">
$("#uploadfile").fileinput({
    language: 'zh', //设置语言
    uploadUrl: "", //上传的地址
    allowedFileExtensions : ['jpg', 'png','gif'],//接收的文件后缀
    uploadAsync: true, //默认异步上传
    showUpload: false, //是否显示上传按钮
    
    showRemove : true, //显示移除按钮
    showPreview : true, //是否显示预览
    showCaption: false,//是否显示标题
    browseClass: "btn btn-primary", //按钮样式     
    dropZoneEnabled: false,//是否显示拖拽区域
    maxFileCount: 1, //表示允许同时上传的最大文件个数
    enctype: 'multipart/form-data',
    validateInitialCount:true
});
</script>
<body>



<div class="panel panel-default">
	<div class="panel-body">
		<form id="conForm" class=" form-inline">
		  <div class="form-group">
		    <div class="col-md-2 ">
		    <input type="text" class="form-control" id="name" placeholder="请输入商品名称">
		    </div>
		  </div>
  		<button type="button" onclick="Product.searchProduct()" class="btn btn-info ">
   			<span class="glyphicon glyphicon-search" aria-hidden="true" >搜索</span>
   		</button>
   		<button type="button" onclick="Product.empty()" class="btn btn-danger ">
   			<span class="glyphicon glyphicon-remove" aria-hidden="true" > 清空</span>
   		</button>
</form>
	</div>
</div>


<table id="product-table" class="table table-hover table-striped table-condensed table-bordered"></table>

<!--toolbar  -->
<div id="toolbar" class="btn-toolbar">

<shiro:hasPermission name="productManager:add">
		
  <button onclick="Product.openDlg()" type="button" class="btn btn-success" style="margin-left: 1015px;">
      <span class="glyphicon glyphicon-plus" aria-hidden="true">添加</span>
    </button>
 </shiro:hasPermission>
   
</div>

<!-- 模态框（Modal） -->
<!-- 添加商品-->
<div id="addDlg" class="modal fade" id="myModal" tabindex="-1" role="dialog" data-backdrop="static" data-keyboard="false" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">添加商品</h4>
            </div>
            <div class="container">
			<form enctype="multipart/form-data" class="form-horizontal" id="addForm"  method="post">
			<div class="form-group">
					<label class="col-md-2 control-label">商品名称：</label>
					<div class="col-md-3 ">
						<input type="text"  id="add_name" name="name" class="form-control form-control-static" placeholder="请输入商品名称">
					</div>
			</div>
				
				<div class="form-group">
					<label class="col-md-2 control-label">商品类别：</label>
					<div class="col-md-3 ">
					<input type="hidden" id="cid" >
					<select  style= "width:260px" id="category_id" name="category_id" multiple="false"  class="form-control form-control-static "></select>
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-2 control-label">上传图片：</label>
					<div class="col-md-3 ">
						   <input type="file" name="uploadfile" id="uploadfile" multiple="multiple" class="file-loading" style="height:30px;width: 40px;" />  
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-2 control-label">价格：</label>
					<div class="col-md-3 ">
						<input type="text"  id="price" name="price"  class="form-control form-control-static" placeholder="请输入价格">
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-md-2 control-label">原价：</label>
					<div class="col-md-3 ">
						<input type="text"  id="original_price" name="original_price"  class="form-control form-control-static" placeholder="请输入原价">
					</div>
				</div>
            <div class="modal-footer col-md-6">
            <!--用来清空表单数据-->
            <input type="reset" name="reset" style="display: none;" />
                <button type="button" class="btn btn-default" onclick="Product.closeDlg()">关闭</button>
               <button type="button" onclick="Product.saveProduct()" class="btn btn-primary">提交</button>
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
						<input type="text"  id="update_Product_name" name="ProductName" class="form-control form-control-static" placeholder="请输入管理员名称">
					</div>
			</div>
				<div class="form-group">
					<label class="col-md-2 control-label">密码还原：</label>
					<div class="col-md-3" class="form-control form-control-static">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input   type="radio" name="ProductStatus" value="1">是&nbsp;&nbsp;&nbsp;&nbsp;
					<input  type="radio" checked="checked"  name="ProductStatus" value="2">否
					</div>
				</div>
            <div class="modal-footer col-md-6">
            <!--用来清空表单数据-->
            <input type="reset" name="reset" style="display: none;" />
                <button type="button" class="btn btn-default" onclick="Product.closeDlg()">关闭</button>
               <button type="button" onclick="Product.updateProduct()" class="btn btn-primary">提交</button>
            </div>
            </form>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div> 

</body>
</html>