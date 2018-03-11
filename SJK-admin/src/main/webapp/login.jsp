<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/include/core.jsp"%>

<html >
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="renderer" content="webkit" />
    <title>小二后台系统</title>
    <meta name="keywords" content="">
    <meta name="description" content="小二后台系统">
    <link rel="stylesheet" href="${path}/css/common/base.css">
    <link rel="stylesheet" href="${path}/css/login.css">
    <script src="${path}/js/jquery-1.8.0.min.js" charset="UTF-8" type="text/javascript"></script>
    <script type="text/javascript">
  //登陆
	function doLogin(){
	  
	  //验证非空
	   	var flag = true;
	  	var username=$("#username").val();
		var password=$("#password").val();
		var chkcode=$("#chkcode").val();
		if(username.length==0){
			flag=false;
			return flag;
		}
		if(password.length==0){
			flag=false;
			return flag;
		}
		if(chkcode.length==0){
			flag=false;
			return flag;
		} 
		if(flag){
			$.ajax({
				type:'post',
				dataType:'json',
				url:'${path}/login/doLogin',
				data:$("#form").serialize(),
				success:function(data){
					//登陆成功
					if(data.returnCode == 1005){
						location.href="${path}/menu/getMenuByMerchantId?uid="+data.returnMsg;
					}else{
						$("#checkError").html("<font color='white' size='4px'> "+data.returnMsg+"</font>");
					}
				}
				});
		}
	}
		
		//回车登录
		$(document).keydown(function(event){ 
			if(event.keyCode==13){
				doLogin();
			}
		}); 
		
		function changeCheckIMG(){
			$("#loginimg").attr("src","${path}/checkimg.jsp?timestamp=" + new Date());
		}
	</script>
    
</head>
<body>
<div class="top">
    <div class="logoBox">
        <img src="${path}/images/login/logo.png" alt="">
        <div style="display: inline-block">
            <h3>后台管理系统</h3>
            <p>商品录入，报表展示，经营分析</p>
        </div>
    </div>
</div>
<div class="container">
<div class="loginBox">
    <form id="form"  method="post" >
        <h6>登录</h6>
        <ul class="login">
            <li>
                <div class="user">
                    <input id="username" name="merchant_code" type="text" placeholder="请输入用户名">
                    <span class="del rR"></span>
                </div>
            </li>
            <li>
                <div class="password">
	                    <input id="password" name="password" type="password" placeholder="请输入密码">
	                    <span class="eye rR"></span>
                </div>
            </li>
            <li>
                <div class="code lL">
                    <input name="check_code" id="chkcode" type="text" placeholder="输入验证码">
                </div>
                <span >
                	<img class="verification"  id="loginimg"  src="${path}/checkimg.jsp" 
                	 alt="" >
                </span>
                 <span class="refresh"><img src="${path}/images/login/refresh.png"
                  style="margin-top: 10px;alt="" onclick="changeCheckIMG()">刷新</span>
            </li>
            <li>
            	<label id="checkError">
		           
		         </label> 
            </li>
            <li>
                <input type="button" value="登录" class="loginBtn" onclick="doLogin()">
            </li>
        </ul>
    </form>
</div>
</div>
<div class="bottom">
    <p>版权所有：三剑客 </p>
</div>
</body>
<script src="${path}/js/login.js"></script>
</html>