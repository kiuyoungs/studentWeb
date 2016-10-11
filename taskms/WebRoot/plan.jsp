<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'plan.jsp' starting page</title>
    
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

		<a href="">list all plans</a>
		
	</div>
	
	<c:if test="${not empty list}">
		<div
			style="margin-top:5px; border:1px solid #fff;color:#f44;background-color: #aaa; width="80%";
font-weight:bold;padding-left:15px;line-height:30px;background-color: #555">
			<table>
				<th>id</th>
				<th>title</th>
				<th>content</th>
				<th>starttime</th>
				<th>endtime</th>
				<th>status</th>
			
				<c:forEach items="${list}" var="row">
					<tr>
						<td>${ row.id}</td>
						<td>${row.title}</td>
						<td>${row.content}</td>
						<td>${row.startTime}</td>
					    <td>${row.endTime}</td>
						<td>${row.status}</td>
						
					</tr>
				</c:forEach>
			</table>
		</div>
	</c:if>  
	</body>
</html>
