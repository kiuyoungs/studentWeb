<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>主管页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
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
position:relative;
	margin: 20px auto;
	width:90%;
}
#header {
	background-image: url('./images/11.jpg');
	margin: 20px auto;
	padding: 17.5px;
}

#content {
	
background-image:url('./images/00.jpg');
	margin: 20px auto 20px auto;
	padding: 20px;
	
	
}
#left{
padding: 5px; float: left
}
#left a{
color:white;
}
#show{
margin:10px 100px;
padding: 5px auto; float: left
text-align: center;
}
#line{
float:none;
clear: both;
height:1px;
background-color: red;
}
</style>
<script type="text/javascript">
function del(id){
if(confirm("确认删除？")){
location.href="task_Delete?id="+id;
}

}
</script>
  </head>
  
  <body>
<div id="container">
		<div id="header">
			<div style="float: left">任务管理</div>
			<div style="float: right">
				<a href="user_logout">退出系统</a>
			</div>
		</div>
		<div id="line"></div>
		<div id="content">
			<div id="left">
				<a href="task_toadd">添加任务</a> <br> 
				<a href="task_tolist">任务列表</a> <br> 
				<a href="task_follow">任务跟踪</a> <br>
			</div>
			<div id="show" >
				<c:if test="${not empty list }">

					<table>
						<tr>
							<th>标题</th>
							<th>内容</th>
							<th>开始时间</th>
							<th>结束时间</th>
							<th>实施者</th>
							<th>发布者</th>
							<th>状态</th>
							<th>处理</th>
						</tr>
						<c:forEach var="item" items="${list}" varStatus="status">
							<tr <c:if test="${status.count%2==0}">bgcolor="#CCCCFE"</c:if>
								align="left">
								<td>${item.title}</td>
								<td>${item.content}</td>
								<td>${item.starttime}</td>
								<td>${item.endtime}</td>
								<td><c:if test="${item.executor==2}">niu</c:if>
									<c:if test="${item.executor==4}">li</c:if>
								</td>
								<td><c:if test="${item.issuer==2}">niu</c:if></td>
								<td><c:if test="${item.status==0}">未开始</c:if>
									<c:if test="${item.status==1}">已开始</c:if>
									<c:if test="${item.status==2}">已结束</c:if>
								</td>
								<td><c:if test="${item.status == 0}"><a href="task_findById?id=${item.id }">查看详细/修改</a> <input
									type="button" onclick="del(${item.id })" value="删除"></c:if></td>
							</tr>
						</c:forEach>
					</table>

				</c:if>
			</div>
			<div id="show" >
				<c:if test="${not empty tlist }">

					<table>
						<tr>
							<th>标题</th>
							<th>内容</th>
							<th>开始时间</th>
							<th>结束时间</th>
							<th>实施者</th>
							<th>发布者</th>
							<th>状态</th>
							<th>处理</th>
						</tr>
						<c:forEach var="item" items="${tlist}" varStatus="status">
							<tr <c:if test="${status.count%2==0}">bgcolor="#CCCCFE"</c:if>
								align="left">
								<td>${item.title}</td>
								<td>${item.content}</td>
								<td>${item.starttime}</td>
								<td>${item.endtime}</td>
								<td><c:if test="${item.executor==2}">niu</c:if>
									<c:if test="${item.executor==4}">li</c:if>
								</td>
								<td><c:if test="${item.issuer==2}">niu</c:if></td>
								<td><c:if test="${item.status==0}">未开始</c:if>
									<c:if test="${item.status==1}">已开始</c:if>
									<c:if test="${item.status==2}">已结束</c:if>
								</td>
								<td><a href="task_listPlan?id=${item.id }">查看计划</a> <input
									type="button" onclick="del(${item.id })" value="删除"></td>
							</tr>
						</c:forEach>
					</table>

				</c:if>
			</div>
			<div id="line"></div>
		</div>
	</div>
  </body>
</html>
