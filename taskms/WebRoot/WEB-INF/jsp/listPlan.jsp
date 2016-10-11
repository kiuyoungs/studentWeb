<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>查看计划</title>
<style type="text/css">
table {
	
	margin-right: auto;margin-left: auto;
	text-align:center;
	border: 1px solid green;
	background: #abc;
	padding: 10px;
}

table td {
		text-align:left;
	padding: 2px 2px 2px 2px;
	
}

table th {
	margin: 2px;
	padding: 1px 1px 1px 5px;
	background: #99cc33;
}

body {
	margin: 0 0;
	text-align: center;
}

#container {
	position: relative;
	margin: 20px auto;
	width: 90%;
}

#header {
	background-image: url('./images/11.jpg');
	margin: 20px auto;
	padding: 17.5px;
}

#content {
	background-image: url('./images/00.jpg');
	margin: 20px auto 20px auto;
	padding: 20px;
}

#left {
	padding: 5px;
	float: left
}

#show {
	margin: 10px 100px;
	padding: 5px auto;
	float: left text-align: center;
}

#line {
	float: none;
	clear: both;
	height: 1px;
	background-color: red;
}
</style>
</head>
<body>
	<div id="header">
			<div style="float: left">任务跟踪--->查看计划</div>
						<div style="float: right;margin:auto 15px;">
				<a href="javascript:history.back()"> 返回 </a>
			</div>
			<div style="float: right;margin:auto 15px;">
				<a href="user_logout"> 退出系统 </a>
			</div>
		</div>

	<c:if test="${not empty plist}">
		<div id="content">
			<table>
			<tr>
				<th>标题</th>
				<th>内容</th>
				<th>状态</th>
			</tr>
				<c:forEach var="item" items="${plist}" varStatus="status">
					<tr>
						<td>${item.title}</td>
						<td>${item.content}</td>
						<td><c:if test="${item.status == 0}">无反馈</c:if>
							<c:if test="${item.status == 1}">有反馈</c:if></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</c:if>

</body>
</html>