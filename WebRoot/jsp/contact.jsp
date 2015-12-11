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

<title>My JSP 'order.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="jsp/styles.css">
<script type="text/javascript" charset="utf-8"
	src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#allDataUser").click(function() {
			this.form.submit();
		});

	});
</script>

</head>

<body>
	<div id="panelwrap">
		<jsp:include page="frontNavigation.jsp"></jsp:include>
		<div class="center_content">
			<div id="right_wrap">
				<div id="right_content">
					<h2>订单列表</h2>
					<table id="rounded-corner">
						<thead>
							<tr>
								<th>id</th>
								<th>联系人</th>
								<th>用户ID</th>
								<th>用户姓名</th>
								<th>邮差ID</th>
								<th>邮差姓名</th>
								<th>订单类型</th>
								<th>取件地址</th>
								<th>订单状态</th>
								<th>订单价格</th>
								<th>编辑</th>
								<th>删除</th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<td colspan="12"><input type="checkbox" name="all" id="all" />
									全选</td>
							</tr>
						</tfoot>
						<tbody>
							<c:forEach items="${list}" var="contact" varStatus="vs">
								   <td>${contact.idcontact }</td>
                                    <td>${contact.userid }</td>
								    <td>${contact.name }</td>
									<td>${contact.phone }</td>
									<td>${contact.address }</td>
									
									<td><a href="#"><img src="images/edit.png" alt=""
											title="" border="0" /></a></td>
									<td><a href="#"><img src="images/trash.png" alt=""
											title="" border="0" /></a></td>

</tr>
							</c:forEach>

						</tbody>
					</table>

					<div class="form_sub_buttons">
						
					</div>
				</div>
			</div>
			<!-- end of right content-->




			<form method="post" id="subForm">
				<div class="sidebar" id="sidebar">
					<h2>Browse categories</h2>
					<ul>
						<li><a href="all-order" id="allDataUser">所有订单</a></li>
						<li><a href="pending-order">未处理订单</a></li>
						<li><a href="serving-order">服务中订单</a></li>
						<li><a href="completed-order">已完成订单</a></li>
					</ul>
				</div>
			</form>
			<div class="modal fade" id="modal-notification">
	</div>
			<div class="clear"></div>

		</div>
		<!--end of center_content-->
		<div>
			<b id="error_message" style="color: rgb(255,0,0)">###</b>
		</div>
		<jsp:include page="foot.jsp"></jsp:include>
	</div>
</body>
</html>
