<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
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

<title>My JSP 'login.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="jsp/style.css" />
<script type="text/javascript" src="js/jquery-1.7.2.min.js"/></script>
</head>

<body>
	<div id="loginpanelwrap">

		<div class="loginheader">
			<div class="logintitle">
				<a href="#">管理员登录</a>
			</div>
		</div>
		
		<form id="AdminloginForm" method="post">
		<div class="loginform">
	
			<div class="loginform_row">
				<label>用户名:</label> <input id="userName" type="text" class="loginform_input"	name="adminName" required/>
			</div>
			<div class="loginform_row">
				<label>密码:</label> <input id="password" type="password" class="loginform_input" name="adminPassword" required/>
			</div>
				<div><b id="error_message" style="color: rgb(255,0,0)"></b></div>
			<div class="loginform_row">
				<input type="button" class="loginform_submit" id="loginBtn" value="登录" />
			</div>
			<div class="clear"></div>
		</div>
		</form>
		
	</div>
	
	 <script type="text/javascript">
        $(function()
        	{
        		$("#loginBtn").click(function()
        		{
        			var username = $("#userName").val();
            		var password = $("#password").val();
            		if (userName === "")
            			{
            				$("#error_message").html("username should not be empty!");
            			}
            		else if (password === "")
            			{
            				$("#error_message").html("password should not be empty!");
            			}
            		else
            		{
        
            			$.post("admin-login",
            					{
            						adminName: username,
            						adminPassword: password
            					},
            					function(data,status){
                        			var temp = eval("("+data+")");
                        			var msg = temp.info;
                        			
                        			if (msg === "OK")
                        			{
                        				window.location.href = "/Schpost/jsp/index.jsp";
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
