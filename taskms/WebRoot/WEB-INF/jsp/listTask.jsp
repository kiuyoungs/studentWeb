<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'listTask.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
<body>
	<div style="border:1px solid #fff;color:#fff; width="80%"
font-weight:bold;padding-left:15px;line-height:30px;background-color: #ccc">

		<a href="ListAction">list all users</a>
		<form action="" method="post">
			<input type="text" name="uname" /> <input type="submit" name="search"
				value="Search By name" />

		</form>
	</div>

	
	<c:if test="${not empty u1}">
	${u1.id }  u1 ${u1.name } ${u1.pswd }
	
	</c:if>
	<c:if test="${not empty list}">
		<div
			style="margin-top:5px; border:1px solid #fff;color:#f44;background-color: #aaa; width="80%"
font-weight:bold;padding-left:15px;line-height:30px;background-color: #555">
			<table>
				<th>id</th>
				<th>name</th>
				<th>account</th>
				<th>pwd</th>
				<th>role_id</th>
				<th>birthday</th>
				<th>entry</th>
				<th>leader_id</th>
				<c:forEach items="${list}" var="row">
					<tr>
						<td>${ row.id}</td>
						<td>${row.name}</td>
						<td>${row.account}</td>
						<td>${row.pswd}</td>
					    <td>${row.role_id}</td>
						<td>${row.birthday}</td>
						<td>${row.entry}</td>
						<td>${row.leader_id}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</c:if>

</body>
</html>