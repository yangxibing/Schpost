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

<title>My JSP 'user.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="jsp/styles.css">
<script type="text/javascript" charset="utf-8" src="js/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#allDataUser").click(function(){
			//alert("泥煤的");
			this.form.submit();
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
			<li><a href="AdminUserServlet"  class="selected">用户管理</a>
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
			<div id="right_wrap">
				<div id="right_content">
					<h2>用户列表</h2>
					<table id="rounded-corner">
						<thead>
							<tr>
								<th></th>
								<th>用户编号</th>
								<th>用户名</th>
								<th>密码</th>
								<th>电话</th>
								<th>编辑</th>
								<th>删除</th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<td colspan="12">列表底部</td>
							</tr>
						</tfoot>
						<tbody>
							<c:forEach items="${users}" var="user" varStatus="vs">
								<c:if test="${user.id != -1 }">
									<c:if test="${(vs.index+1)%2 ==0 }"><tr id="User${user.id}" class="odd"></c:if>
									<c:if test="${(vs.index+1)%2 ==1 }"><tr id="User${user.id}" class="even"></c:if>
										<td><input type="checkbox" name="" /></td>
										<td>${user.id }</td>
										<td>${user.name }</td>
										<td>${user.password }</td>
										<td>${user.cellphoneNum }</td>
										<td><button style="color:#fff;background: #7dc44e; border:groove;" 
									type="button" id="delUser${user.id}">修改</button>
									</td></td>
										<td><button class="btn btn-primary btnDelStore" style="color:#fff;background-color: #d96060; border:groove;"
									  type="button" id="delUser${user.id}">删除</button></td>
									</tr>

								</c:if>

							</c:forEach>

						</tbody>
					</table>

					<div class="form_sub_buttons">
						<a href="#" class="button green">Edit selected</a> <a href="#"
							class="button red">Delete selected</a>
					</div>
				</div>
			</div>
			<!-- end of right content-->




<form action="AdminUserServlet" method="post" id="subForm">
			<div class="sidebar" id="sidebar">
				<h2>Browse categories</h2>
				<ul>
					<li><a href="AdminUserServlet" id="allDataUser">所有用户</a></li>
				</ul>
			</div>
</form>
			<div class="clear"></div>

		</div>
		<!--end of center_content-->
		<jsp:include page="foot.jsp"></jsp:include>
	</div>
	<script type="text/javascript" src="js/jquery-1.7.2.min.js"/></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$(".btnDelStore").click(function() {

				var id = $(this).attr("id");
				// delStore?
				var tempID = id.substring(7);
				$.post("user-delete", {
					userID : tempID
				}, function(data) {

					console.log(data);
					if (data == "delete sucessful")
						$("#User" + tempID).remove();
				});

			});
			
		});
	</script>
</body>
</html>
