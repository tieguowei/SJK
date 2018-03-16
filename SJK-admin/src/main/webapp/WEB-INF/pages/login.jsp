<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/include/core.jsp"%>

<html >
<head>
    <meta charset="utf-8">
    <title>登录页面</title>
    <link rel="stylesheet" href="${path}/css/common/base.css">
    <link rel="stylesheet" href="${path}/css/login.css">
    <script src="${path}/js/jquery-1.8.0.min.js" charset="UTF-8" type="text/javascript"></script>
</head>
    <script type="text/javascript">
		
		function changeCheckIMG(){
			$("#loginimg").attr("src","${path}/checkimg.jsp?timestamp=" + new Date());
		}
	</script>
    
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
    <form id="form"   method="post" >
        <h6>登录</h6>
        <ul class="login">
            <li>
                <div class="user">
                    <input id="username" name="username" type="text" placeholder="请输入用户名">
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
		           ${msg}
		         </label> 
            </li>
            <li>
                <input type="submit" value="登录" class="loginBtn"  onclick="doLogin()"  />
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