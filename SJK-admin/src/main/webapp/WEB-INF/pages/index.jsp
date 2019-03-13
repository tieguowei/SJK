<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<c:set value="${pageContext.request.contextPath }" var="path"></c:set>
<%@ include file="/include/index_core.jsp" %>
<html>
<head>
    <title>金融云平台</title>
</head>
<body class="fixed-sidebar full-height-layout gray-bg">
<div>
    <nav class=" navbar-static-side" role="navigation">
        <div class=""style="overflow: auto; height: 99%;">
            <ul class="nav metismenu" id="side-menu">
                <li class="nav-header" style="text-align: center;">
                		<div class="dropdown profile-element">
							<span>
						
							<img alt="image" class="img-circle" src="${path}/static/img/${image}" />
							&nbsp; &nbsp; &nbsp; &nbsp;&nbsp;
							</span> 
								<a data-toggle="dropdown" class="dropdown-toggle" href="#"> 
									<span class="clear">
							 			<span style="color:white;  margin-left:-30px;margin-top: 6px;" class="text-muted text-xs block" th:text="${employee.name}"><b class="caret"></b>
							 				${employee.name}
							 			</span>
									</span>
								</a>
							<ul class="dropdown-menu animated fadeInRight m-t-xs">
								<li><a class="J_menuItem" onclick="openPassDlg()" href="#"><i class="fa fa-key"></i>&nbsp;修改密码</a></li>
								<li><a class="J_menuItem" onclick="quit()" href="#"><i class="fa fa-sign-out"></i>&nbsp;退出登陆</a></li>
							</ul>
						</div>
                </li>
                
                <div id="treeview" class="" style="margin-top: -28px;"></div>
                 <input style="display: none" type="input" class="form-control" id="input-expand-node" placeholder="Identify node..." value="">
            </ul>
       </div> 
        </div>
    </nav>
    <div id="page-wrapper" class="gray-bg" style="height: 99%;">
        <div class="row border-bottom">
            <nav class="navbar navbar-static-top  " role="navigation" style="margin-bottom: 0">
                <div class="navbar-header">
                    <a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#">
                   		 <i class="fa fa-bars"></i> 
                    </a>
                </div>
                <div class="nav navbar-top-links navbar-right">
                        <span class="m-r-sm text-muted welcome-message">
                       		 <iframe frameborder='0' scrolling='auto' src='${path}/include/time.html' style='padding:0px;width:100%;height:5%;' ></iframe>
                        </span>
				</div>
            </nav>
        </div>
        <ul id="myTab" class="nav nav-tabs">
		<li class="active">
			<a href="#home" data-toggle="tab" >
				 首页
			</a>
		</li>
</ul>
<div id="myTabContent" class="tab-content">
		<div class="tab-pane fade in active" id="home">
			<h2 style="text-align: center; margin-top: 180px;">欢迎使用金融云平台</h2>
		</div>
</div>
    </div>
</div>


<!-- 修改密码modal -->
<div id="passDlg" class="modal fade"  tabindex="-1" role="dialog" data-backdrop="static" data-keyboard="false" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">修改密码</h4>
            </div>
            <div class="container">
			<form class="form-horizontal" id="myform"  method="post">
			<div class="form-group">
			<label class="col-md-2 control-label">旧密码：</label>
			<div class="col-md-3 ">
				<input type="password" id="oldPwd" name="oldPwd" class="form-control form-control-static"  placeholder="请输入原始密码">
				<input  type="hidden" id="employeeId" value="${employee.employeeId}" name="employeeId">
			</div>
			</div>
			
			<div class="form-group">
			<label class="col-md-2 control-label">新密码：</label>
			<div class="col-md-3 ">
				<input type="password" id="newPwd"  name="newPwd" class="form-control form-control-static" placeholder="请输入新密码">
			</div>
			</div>
			
			<div class="form-group">
			<label class="col-md-2 control-label">确认密码：</label>
			<div class="col-md-3">
				<input type="password" id="againPwd"  name="againPwd" class="form-control form-control-static" placeholder="请输入新密码">
			</div>
			</div>
            <div class="modal-footer col-md-6">
            <!--用来清空表单数据-->
            <input type="reset" name="reset" style="display: none;" />
                <button type="button" class="btn btn-default" onclick="closeDlgs()">关闭</button>
               <button type="button" onclick="updatePwd()" class="btn btn-primary">修改</button>
            </div>
            </form>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
</body>
</html>
