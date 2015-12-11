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

<title>pending-order</title>

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
		$("#allDataUser").click(function() {
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
			<li><a href="all-order"  class="selected">订单管理</a>
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
			<div id="right_wrap">
				<div id="right_content">
					<h2>订单列表</h2>
					<table id="rounded-corner">
						<thead>
							<tr>
								<th></th>
								<th>订单编号</th>
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
							<c:forEach items="${allorderList}" var="order" varStatus="vs">
								<c:if test="${order.id != -1 }">
									<c:if test="${(vs.index+1)%2 ==0 }">
										<tr class="odd">
									</c:if>
									<c:if test="${(vs.index+1)%2 ==1 }">
										<tr class="even">
									</c:if>
									<tr id="order${order.id}" class="even">
										<td><input type="checkbox" name="item"
											value="${order.id }" id="${order.id}" /></td>
										<td>${order.id }</td>
										<td>${order.iduser }</td>
										<td>${order.uerName }</td>
										<td>${order.idposter }</td>
										<td>${order.posterName}</td>
										<td>${order.type }</td>
										<td>${order.addr }</td>
										<td>${order.status }</td>
										<td>${order.price }</td>
										<td><a href="#"><img src="images/edit.png" alt=""
												title="" border="0" /></a></td>
										<td><a href="#"><img src="images/trash.png" alt=""
												title="" border="0" /></a></td>

									</tr>
								</c:if>

							</c:forEach>

						</tbody>
					</table>
					<div id="forposter" style="display:none">
					<table id="rounded-corner">
						<thead>
							<tr>
								<th></th>
								<th>邮差编号</th>
								<th>姓名</th>
								<th>电话</th>
								<th>服务地址</th>
								<th>等级</th>
								<th>是否在岗</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${serposterList}" var="poster" varStatus="vs">
								<c:if test="${poster.id != -1}">
									<c:if test="${(vs.index+1)%2 ==0 }">
										<tr id="Poster${poster.id}" class="odd">
									</c:if>
									<c:if test="${(vs.index+1)%2 ==1 }">
										<tr id="Poster${poster.id}" class="even">
									</c:if>

									<td><input type="checkbox" name="posteritem" value="${poster.id}"/></td>
									<td>${poster.id }</td>
									<td>${poster.name }</td>
									<td>${poster.cellphoneNum }</td>
									<td>${poster.wkplace }</td>
									<td>${poster.level }</td>
									<c:if test="${poster.isWorking == true }">
										<td>是</td>
									</c:if>
									<c:if test="${poster.isWorking == false }">
										<td><p style=" color: red">否</td>
									</c:if>
									</tr>

								</c:if>

							</c:forEach>

						</tbody>
					</table>
					</div>

					<div class="form_sub_buttons">
						<button id="dispatchOrder" style="height:30px; width:100px"
							class="button green">分发邮差</button>
					
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
			<div class="modal fade" id="modal-notification"></div>
			<div class="clear"></div>

		</div>
		<!--end of center_content-->
		<div>
			<b id="error_message" style="color: rgb(255,0,0)">###</b>
		</div>
		<jsp:include page="foot.jsp"></jsp:include>
	</div>

	<script type="text/javascript" src="js/zDrag.js"></script>
	<script type="text/javascript" src="js/zDialog.js"></script>
	<script type="text/javascript">
		var idString = "";
		var boxValue = "";
		var posterid ="";
		$(function() {
			var all_checked = false;
		
			$(":checkbox").click(function() {
				var table = $(this).parents("table");
				if ($(this).attr("id") === "all") {
					table.find(":checkbox").prop("checked", !all_checked);
					var box = document.getElementsByName("item");//checkbox的name
					for ( var i = 0; i < box.length; i++) {
						if (box[i].checked) {
							boxValue += "" + box[i].value + ",";
						}
					}

					$("#error_message").html(boxValue);
				} else {
					
				}
			});
		});
		$("#dispatchOrder").click(function() {
		      boxValue="";
		      posterid ="";
				var box = document.getElementsByName("item");//checkbox的name
				for ( var i = 0; i < box.length; i++) {
					if (box[i].checked) {
						boxValue += "" + box[i].value + ",";
					}
				}

				$("#error_message").html(boxValue+posterid);
				if (boxValue === "") {
					$("#error_message").html("no select order!");
				} else if(posterid ===""){
					$("#error_message").html("no select poster!");
					var diag = new Dialog();
					diag.Width = 500;
					diag.Height = 150;
					diag.Title = "校园邮差列表";
					diag.InvokeElementId="forposter";
					
					diag.OKEvent = function(){
						var box1 = document.getElementsByName("posteritem");//checkbox的name
				for ( var i = 0; i < box1.length; i++) {
					if (box1[i].checked) {
						posterid += "" + box1[i].value + ",";
					}
				}
					$.post("dispatch-order", {
						orderIds : boxValue,
						posterids:posterid
					//poster: poster.id
					}, function(data, status) {
						var temp = eval("(" + data + ")");
						var msg = temp.info;

						if (msg === "OK") {
						$("#error_message").html(temp.info);/*
						var box1 = document.getElementsByName("item");//checkbox的name
							for ( var i = 0; i < box1.length; i++) {
								if (box1[i].checked) {
									$("#order" + box1[i].value).remove();
									;;;;;
									//$("#order" + box1[i+1].value).remove();
									//$("#error_message").html("ok");
									
								}
							}*/
							 Dialog.alert("订单已分配给邮差，订单在服务中..."); 
							 window.location.href = "pending-order";
						} else {
							$("#error_message").html(temp.info);
						}
					});
					diag.close();};//点击确定后调用的方法
					diag.show();
					}
});
	function open4()
    {
	var diag = new Dialog();
	diag.Width = 300;
	diag.Height = 100;
	diag.Title = "内容页为html代码的窗口";
	diag.InnerHtml='<div style="text-align:center;color:red;font-size:14px;">直接输出html，使用 <b>InnerHtml</b> 属性。</div>'
	diag.OKEvent = function(){diag.close();};//点击确定后调用的方法
	diag.show();
}
function open5()
{
	var diag = new Dialog();
	diag.Width = 500;
	diag.Height = 150;
	diag.Title = "校园邮差列表";
	diag.InvokeElementId="forposter"
	diag.OKEvent = function(){diag.close();};//点击确定后调用的方法
	diag.show();
}

	</script>
</body>
</html>
