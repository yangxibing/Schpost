<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	contentType="text/html; charset=utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title></title>

<% 
    if(session.getAttribute("admin") == null) { 
%> 
        <script type="text/javascript" language="javascript"> 
            alert("您还没有登录，请登录..."); 
            window.document.location.href="jsp/login.jsp"; 
        </script>  
<% 
    } 
%>
</head>
<body>
</body>
</html>
