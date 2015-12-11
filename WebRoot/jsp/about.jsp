<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'about.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="jsp/styles.css">
</head>

<body>
	<div id="panelwrap">
		<jsp:include page="frontNavigation.jsp"></jsp:include>
		
	<div class="menu" id="menu">
		<ul>
			<li><a href="jsp/index.jsp" >主页</a>
			</li>
			<li><a href="all-order">订单管理</a>
			</li>
			<li><a href="AdminUserServlet">用户管理</a>
			</li>
			<li><a href="AdminPosterServlet">邮差管理</a>
			</li>
			<li><a href="jsp/index.jsp">其他</a>
			</li>
			<li><a href="jsp/about.jsp" class="selected">关于我们</a>
			</li>
		</ul>
	</div>

</div>
		<div class="center_content">
			<dir>
				<p>

					<br> <br>


				</p>
				<p>我们是小团队，一个小小的设计团队。规模大并不是我们追求的目标，</p>
				<p>但我们会一直坚守并延续公司成立之初的梦想：认真做设计，做值得的设计。</p>

				<p>我们组建设计团队，完全是出于对设计这份工作的热爱。</P>
				<p>在这里，没有世俗的商业化和浮躁的气息，你可以静下心来做你想做的设计；</P>
				<p>在这里，你还得忍受周例会上的批评与自我批评，甚至是同事们善意的调侃；</P>
				<p>在这里，你可以是白富美，也可以是屌丝，但不能拒绝身边的微笑，</P>
				<p>因为我们本身就不喜欢沉闷的办公室氛围；</P>
				<p>在这里，不管是员工还是老板，都会互相尊重和谐共处；</P>
				<p>在这里，你不用为严格的制度烦扰，前提是做好本职工作即可；</P>
				<p>在这里，年假、法定节假日都可以享受，只是时间上更加自主灵活。</P>

				<p>这就是我们追梦者设计团队</p>
			</div>
			<div class="clear"></div>
		</div>
		<!--end of center_content-->
		<jsp:include page="foot.jsp"></jsp:include>
	</div>
</body>
</html>
