<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	contentType="text/html; charset=utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>管理员登录</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="jsp/styles.css">

</head>

<body>
<%@include file="assertLogin.jsp"%>
<jsp:include page="assertLogin.jsp"></jsp:include>
<div id="panelwrap">
	<jsp:include page="frontNavigation.jsp"></jsp:include>
		<div class="menu" id="menu">
		<ul>
			<li><a href="jsp/index.jsp"  class="selected">主页</a>
			</li>
			<li><a href="all-order">订单管理</a>
			</li>
			<li><a href="AdminUserServlet" >用户管理</a>
			</li>
			<li><a href="AdminPosterServlet">邮差管理</a>
			</li>
			<li><a href="jsp/index.jsp">其他</a>
			</li>
			<li><a href="jsp/about.jsp" >关于我们</a>
			</li>
		</ul>
	</div>
	<div class="center_content">
	<br>
	<center >
	<img style="width:90%; height:70%; "src="./images/index.jpg"  alt="" />
	</center>
	<div class="clear"></div>
    </div> <!--end of center_content-->
	<jsp:include page="foot.jsp"></jsp:include>
</div>
</body>
</html>
