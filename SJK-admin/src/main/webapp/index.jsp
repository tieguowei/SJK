<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set value="${pageContext.request.contextPath }" var="path"></c:set>
<html>
<head>
      <title>后台管理系统</title>
    <link href="${path}/static/css/bootstrap.css" rel="stylesheet">
    <link href="${path}/static/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="${path}/static/css/animate.css" rel="stylesheet">
    <link href="${path}/static/css/style.css" rel="stylesheet">

    <!-- Mainly scripts -->
    <script src="${path}/static/js/jquery-3.1.1.min.js"></script>
    <script src="${path}/static/js/bootstrap.js"></script>
    <script src="${path}/static/js/plugins/metisMenu/jquery.metisMenu.js"></script>
    <script src="${path}/static/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

    <!-- Custom and plugin javascript -->
    <script src="${path}/static/js/inspinia.js"></script>
    <script src="${path}/static/js/plugins/pace/pace.min.js"></script>

	<link href="${path}/static/css/style.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="${path}/static/js/plugins/bootstrap-table/bootstrap-table.js"></script>
	<script type="text/javascript" src="${path}/static/js/plugins/bootstrap-table/bootstrap-table-zh-CN.js"></script>
	<script type="text/javascript" src="${path}/static/js/plugins/bootstrap-validator/bootstrapValidator.js"></script>
	<script type="text/javascript" src="${path}/static/js/plugins/bootstrap-validator/zh_CN.js"></script>
	<link href="${path}/static/css/plugins/bootstrap-validator/bootstrapValidator.css" rel="stylesheet" type="text/css">
</head>
<style type="text/css">
 .modal {
     position: fixed;  
    top: 10%;
    left: 30%;
    width: 800px;
    height: 800px;
     margin: 100px 100 0 0px;/* margin 负值为宽高的一半 */ 
} 
</style>
<script type="text/javascript">
function getPage(url,name) {
    if(url != ""){
    	url="${path}/"+url;
        $.ajax({cache: false});
        $("#title h2").text(name);
        $("#title strong").text(name);
        $("#content").load(url,function(result){
            //将被加载页的JavaScript加载到本页执行
            $result = $(result);
            $result.find("script").appendTo('#content');
        });
    }
}

//退出登陆
function quit(){
	if(confirm('您确定要退出登陆吗？')){
		location.href="${path}/login/quit.action";
	}else{
		return false;
	}
}
//open
function openPassDlg(){
	$("#passDlg").modal('show');
}
//关闭模态框
function closeDlgs(){
	$("#passDlg").modal('hide');
	$('#oldPass').val("");
	$('#newPass').val("");
	$('#againPass').val("");
	// Modal验证销毁重构，防止第二次打开modal时显示上一次的验证痕迹
	$('#myform').data('bootstrapValidator', null);
	formValidator();
}
//修改密码
function upPass(){
	var p=$("#oldPass").val();
	var n=$("#newPass").val();
	var ids=$("#uid").val();
	if(p!=n){
		if($("#myform").data('bootstrapValidator').validate().isValid()){
    		$.ajax({
    			url:'user/upPass.action',
    			dataType:'json',
    			type:'post',
    			data:{
    				id:ids,
    				pass:n
    			},
    			success:function(data){
    				if(data>0){
    					alert("密码修改成功，请退出重新登陆！");
    					location.href="login/quit.action";
    				}else{
    					alert("密码修改失败");
    				}
    			},
    			error:function(){ 
    				alert("请求失败");
    			}
    		});
    	}else{
    		return false;
    	}
	}else if(p==""||n==""){
		alert("请输入密码");
	}
	else{
		alert("新密码不能与原密码一样");
	}
}

$(function(){
	formValidator();
});
function formValidator(){
	$("#myform").bootstrapValidator({
		fields:{
			id:{
				notEmpty:{
					message:'不能为空'
				}
			},
			password:{
				notEmpty:{
					message:'不能为空'
				}
			},
			oldPass:{
				validators:{
					notEmpty:{
						message:'密码不能为空'
					},
					stringLength:{
						min:6,
						max:18,
						message:"字符长度要在6~18之间"
					},
					identical:{
						field:'password',
						message:'输入旧密码有误'
					}
				}
			},
			newPass:{
				validators:{
					notEmpty:{
						messgae:'密码不能为空',
					},
					stringLength:{
						min:6,
						max:18,
						message:'字符长度要在6~18之间'
					},
				}
			},
			againPass:{
				validators:{
					notEmpty:{
						message:'密码不能为空'
					},
					identical:{
						field:"newPass",
						message:'两次输入密码不一致'
					}
				}
			}
		}
	});
}
</script>
<body class="">
<div id="wrapper">
    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="sidebar-collapse">
            <ul class="nav metismenu" id="side-menu">
                <li class="nav-header">
                    <div class="dropdown profile-element"> 
                   		 <span>
	                            <img alt="image" class="img-circle" src="${path}/static/img/profile_small.jpg" />
                       &nbsp; &nbsp; &nbsp; &nbsp;
                         		<font color="white">${merchantName}</font>
                       </span>
                    </div>
                </li>
                <c:forEach items="${mlist}" var="tree">
                <li>
                    <a onclick="getPage('${tree.menuUrl}','${tree.nameZh}')"><i class="${tree.menuIcon}"></i> <span class="nav-label">${tree.nameZh}</span>
                        <c:if test="${!empty tree.children}">
                        <span class="fa arrow"></span>
                        </c:if>
                     </a>
                    <c:if test="${!empty tree.children}">
                    <ul class="nav nav-second-level collapse">
                        <c:forEach items="${tree.children}" var="menu">
                        <li><a onclick="getPage('${menu.menuUrl}','${menu.nameZh}')">
                        <i class="${menu.menuIcon}"></i>
                        <span class="nav-label">${menu.nameZh}</span>
                        </a></li>
                        </c:forEach>
                    </ul>
                    </c:if>
                </li>
                </c:forEach>
            </ul>
        </div>
    </nav>
    <div id="page-wrapper" class="gray-bg">
        <div class="row border-bottom">
            <nav class="navbar navbar-static-top  " role="navigation" style="margin-bottom: 0">
                <div class="navbar-header">
                    <a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#"><i class="fa fa-bars"></i> </a>
                </div>
                <div class="nav navbar-top-links navbar-right">
                        <span class="m-r-sm text-muted welcome-message">
                        <iframe frameborder='0' scrolling='auto' src='${path}/include/time.html' style='padding:0px;width:100%;height:5%;' ></iframe>
                        </span>
				</div>
            </nav>
        </div>
        <div class="row wrapper border-bottom white-bg page-heading" id="title">
            <div class="col-sm-4">
                <h3></h3>
                 <ol class="breadcrumb">
                    <li class="active">
                        <span>操作</span>
                    </li>
                    <li class="active">
                        <strong>当前位置</strong>
                    </li>
                </ol>
            </div>
        </div>
        <div class="wrapper wrapper-content" id="content">
        
        </div>
        <div class="footer">
            <div class="pull-right">
                10GB of <strong>250GB</strong> Free.
            </div>
            <div>
                <strong>Copyright</strong> Example Company &copy; 2014-2017
            </div>
        </div>
    </div>
</div>


<!-- 模态框（Modal） -->
<!-- 修改 -->
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
			<input type="password" id="oldPass" name="oldPass" class="form-control form-control-static"  placeholder="请输入原始密码">
			<input  type="hidden" id="pass" value="${PASS }" name="password">
			<input  type="hidden" id="uid" value="${ID }" name="id">
			</div>
			</div>
			
			<div class="form-group">
			<label class="col-md-2 control-label">新密码：</label>
			<div class="col-md-3 ">
			<input type="password" id="newPass"  name="newPass" class="form-control form-control-static" placeholder="请输入新密码">
			</div>
			</div>
			
			<div class="form-group">
			<label class="col-md-2 control-label">确认密码：</label>
			<div class="col-md-3">
			<input type="password" id="againPass"  name="againPass" class="form-control form-control-static" placeholder="请输入新密码">
			</div>
			</div>
            <div class="modal-footer col-md-6">
            <!--用来清空表单数据-->
            <input type="reset" name="reset" style="display: none;" />
                <button type="button" class="btn btn-default" onclick="closeDlgs()">关闭</button>
               <button type="button" onclick="upPass()" class="btn btn-primary">修改</button>
            </div>
            </form>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
</body>
</html>
