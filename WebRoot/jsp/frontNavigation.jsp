<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"
	language="java" import="java.sql.*" errorPage=""%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="jsp/style.css" rel="stylesheet" type="text/css" />
<!-- jQuery file -->
<script src="js/jquery.min.js"></script>
<script src="js/jquery.tabify.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" charset="utf-8"
	src="js/jquery.min.js"></script>
<!--script type="text/javascript">
	var $ = jQuery.noConflict();
	$(function() {
		$('#tabsmenu').tabify();
		$(".toggle_container").hide();
		$(".trigger").click(function() {
			$(this).toggleClass("active").next().slideToggle("slow");
			return false;
		});
	});
</script-->
<script type="text/javascript">
	$(function() {

		$("#menu ul li a").click(function() {
			var urlstr = location.href;
			//if ((urlstr).indexOf($(this).attr('href')) == -1){
			$("#menu ul li a").removeClass("selected");
			$(this).addClass("selected");
			//}

		});
	});
</script>



</head>

<div class="header">
	<div class="title" style="width: 331px; height: 117px">
		<a href="jsp/index.jsp"><img src="./images/logo.png"  alt="" /></a>
	</div>
	<div class="header_right">
		欢迎您，${admin.name}
		<!-- <a href="#" class="settings">设置</a> -->
		<form action="AdminLogoutServlet" method="post">
			<input type="submit" class="button green" value="退出登录" />
		</form>

	</div>


<body>
</body>
</html>
