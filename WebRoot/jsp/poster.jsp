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
				
					<h2>邮差列表</h2>
					<table id="rounded-corner">
						<thead>
							<tr>
								<th></th>
								<th>邮差编号</th>
								<th>姓名</th>
								<th>电话</th>
								<th>等级</th>
								<th>服务地址</th>
								<th>是否在岗</th>
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
							<c:forEach items="${posters}" var="poster" varStatus="vs">
								<c:if test="${poster.id != -1}">
									<c:if test="${(vs.index+1)%2 ==0 }">
										<tr id="Poster${poster.id}" class="odd">
									</c:if>
									<c:if test="${(vs.index+1)%2 ==1 }">
										<tr id="Poster${poster.id}" class="even">
									</c:if>

									<td><input type="checkbox" name="" />
									</td>
									<td>${poster.id }</td>
									<td>${poster.name }</td>
									<td>${poster.cellphoneNum }</td>
									<td>${poster.level }</td>
									<td>${poster.wkplace }</td>
									<c:if test="${poster.isWorking == true }">
										<td>是</td>
									</c:if>
									<c:if test="${poster.isWorking == false }">
										<td><p style=" color: red">否
										</td>
									</c:if>
									<td><button style="color:#fff;background: #7dc44e; border:groove;" 
									type="button" id="poster${poster.id }">修改</button>
									</td>
									<td><button class="btn btn-primary btnDelStore" style="color:#fff;background-color: #d96060; border:groove;"
									  type="button" id="delPoster${poster.id}">删除</button></td>
									</td>
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

			<form action="AdminPosterServlet" method="post" id="allDataSubForm">
			</form>
			<div class="sidebar" id="sidebar">
				<h2>Browse categories</h2>
				<ul>
					<li><a href="/Schpost/jsp/Addposter.jsp" id="allData">添加邮差</a>
				</ul>
			</div>
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
				var tempID = id.substring(9);
				$.post("poster-delete", {
					posterID : tempID
				}, function(data) {

					console.log(data);
					if (data == "delete sucessful")
						$("#Poster" + tempID).remove();
				});

			});
			
		});
	</script>
</body>
</html>
