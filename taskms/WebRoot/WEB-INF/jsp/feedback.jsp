<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'feedback.jsp' starting page</title>
    
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
	background: #88ffaa;
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
	border: 0px solid green;
	background: #88ffaa;
	margin: 20px auto;
	padding: 20px;
}

#content {
	
background-color:#aaffaa;
	margin: 20px auto 20px auto;
	padding: 20px;
	
	
}
#left{
padding: 5px; float: left
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
location.href="user_Delete?id="+id;
}

}
</script>
</head>
<body>
	<div id="container">
		<div id="header">
			<div style="float: left">计划管理</div>
			<div style="float: right">
				<a href="user_logout">退出系统</a>
			</div>
		</div>
		<div id="line"></div>
		<div id="content">
			<div id="left">
				<br> <a href="feedback_toadd">添加反馈信息</a> <br> 
				
				<br>
			</div>
			<div id="show" >
				<c:if test="${not empty list }">

					<table>
						<tr>
							<th>内容</th>
							<th>计划</th>
							<th>用户</th>
						</tr>
						<c:forEach var="item" items="${list}" varStatus="status">
							<tr <c:if test="${status.count%2==0}">bgcolor="#CCCCFE"</c:if>
								align="left">
								<td>${item.account}</td>
								<td>${item.name}</td>
								<td>${item.birthday}</td>
								<td><a href="user_findById?id=${item.id }">查看详细/修改</a> <input
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
