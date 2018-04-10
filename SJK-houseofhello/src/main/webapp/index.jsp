<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>项目实战</title>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript">
$(function(){
	//轮播图自动播放
	$('#myCarousel').carousel({
		//设置自动播放/3 秒
		interval : 3000,
		});

})
</script>
</head>
<body>

<nav class="navbar navbar-default navbar-fixed-top">
 <div class="container">
	<div class="navbar-header">
		<a href="#" class="navbar-brand logo" ><img src="image/logo.png"></a>
		<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse">
			<span class="sr-only">切换导航</span>
			 <span class="icon-bar"></span>
			 <span class="icon-bar"></span>
			 <span class="icon-bar"></span>
		</button>

	</div>
	<div class="collapse navbar-collapse" id="navbar-collapse">
		 <ul class="nav navbar-nav navbar-right">
			<li class="active"><a href="#"><span class="glyphicon glyphicon-home"></span> 首页</a></li>
			<li><a href="#"><span class="glyphicon glyphicon-list"></span> 资讯</a></li>
			<li><a href="#"><span class="glyphicon glyphicon-fire"></span> 案例</a></li>
			<li><a href="#"><span class="glyphicon glyphicon-question-sign"></span> 关于</a></li>
		</ul>
	</div>
</div>
</nav>

 <!-- 轮播图 -->
	<div id="myCarousel" class="carousel slide">
	 		 <ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
				<li data-target="#myCarousel" data-slide-to="3"></li>
			</ol>
			
		 <div class="carousel-inner">
				<div class="item active"> 
					<a href="#"><img src="image/slide1.jpg" alt="第一张"></a>
				 </div>
	
				<div class="item">
					<a href="#"><img src="image/slide2.jpg" alt="第二张"></a> 
				</div>
		
				<div class="item">
					<a href="#"><img src="image/slide3.jpg" alt="第三张"></a>
				 </div>
				 
				 <div class="item">
					<a href="#"><img src="image/slide4.jpg" alt="第四张"></a>
				 </div>
				 <a href="#myCarousel" data-slide="prev" class="carousel-control left">
				 		<span class="glyphicon glyphicon-chevron-left"></span>
				 </a>
				 <a href="#myCarousel" data-slide="next" class="carousel-control right">
				 		<span class="glyphicon glyphicon-chevron-right"></span>
				 </a>
		</div>
	</div>
</body>
</html>