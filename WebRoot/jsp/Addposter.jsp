<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@include file="assertLogin.jsp"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'poster.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="jsp/styles.css">
<script type="text/javascript" charset="utf-8"
	src="js/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#allData").click(function() {
			//alert("泥煤的");
			document.getElementById("allDataSubForm").submit();
			//this.form.submit();
		});

	});
</script>

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
			<li><a href="AdminPosterServlet" class="selected">邮差管理</a>
			</li>
			<li><a href="jsp/index.jsp">其他</a>
			</li>
			<li><a href="jsp/about.jsp" >关于我们</a>
			</li>
		</ul>
	</div>
		<div class="center_content">
			<div id="right_wrap">
				<div id="right_content">
				
					<h2>添加邮差信息</h2>
					<table id="rounded-corner">
						<thead>
						</thead>
						<tfoot>
						<br>
							<tr>
								<td colspan="8"></td>
							</tr>
						</tfoot>
						<tbody>
							<tr class="odd"><td width="7%">姓名:</td><td><input id ="userName" name="name" type="text" style=" height:25px"/></td></tr>
							<tr class="odd"><td width="7%">密码:</td><td><input id ="userPassword" name="password" type="text" style=" height:25px"/></td></tr>
							<tr class="odd"><td width="7%">手机:</td><td><input id ="userPhone" name="phone" type="text" style=" height:25px"/></td></tr>
							<tr class="odd"><td width="7%">等级:</td><td><input id ="userLevel" name="level" type="text" style=" height:25px"/></td></tr>
							<tr class="odd"><td width="7%">地址:</td><td><input id ="userPlace" name="place" type="text" style=" height:25px"/></td></tr>
						</tbody>
					</table>
				
					

					<div class="form_sub_buttons">
						<input type="button" class="loginform_submit" id="AddBtn" value="添加" />
					</div>
					<div><b id="error_message" style="color: rgb(255,0,0)"></b></div>
				</div>
			</div>
			<!-- end of right content-->

			<form action="AdminPosterServlet" method="post" id="allDataSubForm">
			</form>
			<div class="sidebar" id="sidebar">
				<h2>Browse categories</h2>
				<ul>
					<li><a href="#" id="allData">添加邮差信息</a>
				</ul>
			</div>
			<div class="clear"></div>

		</div>
		<!--end of center_content-->
		<jsp:include page="foot.jsp"></jsp:include>
	</div>
	<script type="text/javascript" src="js/jquery-1.7.2.min.js"/></script>
	 <script type="text/javascript">
        $(function()
        	{
        		$("#AddBtn").click(function()
        		{
        			var pname = $("#userName").val();
            		var ppassword = $("#userPassword").val();
            		var pphone = $("#userPhone").val();
            		var plevel = $("#userLevel").val();
            		var pplace  = $("#userPlace").val();
            		
            		if (pname === "")
            			{
            				$("#error_message").html("username should not be empty!");
            			}
            		else if (ppassword === "")
            			{
            				$("#error_message").html("password should not be empty!");
            			}
            		else
            		{
        
            			$.post("add-poster",
            					{
            						name: pname,
            						password: ppassword,
            						phone:pphone,
            						level:plevel,
            						palce:pplace
            					},
            					function(data,status){
                        			var temp = eval("("+data+")");
                        			var msg = temp.addInfor;
                        			
                        			if (msg === "OK")
                        			{
                        				window.location.href = "AdminPosterServlet";
                        			}
                        			else
                        			{
                        				$("#error_message").html(temp.info);
                        			}
            					});
            		}
        		});
        	});
        </script>
</body>
</html>
