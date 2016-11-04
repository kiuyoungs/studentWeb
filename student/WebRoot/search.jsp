<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'search.jsp' starting page</title>
    
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
  <div align="center">
			<form action="StudentQueryServlet" method="GET"
				onsubmit="return checkMsg();">
				<font size="2">学生编号:</font>
				<input type="text" name="Student_ID" size="8">
				<input type="submit" value="立即查询">
			
			</form>
		</div>
  <form action="" method="get">
    <table border='1'cellspacing="0" cellpadding="0" align="center">
    	<tr align="center">
    		<td colspan="5">考勤查询</td>
    	</tr>
    	<tr align="center">
    		<td>学生Id</td>
    		<td>课程Id</td>
    		<td>考勤Id</td>
    		<td>日期</td>
    		<td>考勤记录</td>
    	</tr>
    	<c:forEach items="${stuList}" var="stu">
					
			<tr align="center" class="row2" onMouseOver="this.className='row1'"
				onMouseOut="this.className='row2'">

				<!-- <td><input type="checkbox" name="ids" id="ids" value="${opr.operatorId}"></td> -->
				<td>${stu.studentId}</td>
				<td>${stu.courseId}</td>
				<td>${stu.attenId}</td>
				<td>${stu.attenDate}</td>
				<td>${stu.attenRecord}</td>
			</tr>
					
		</c:forEach>
		
    </table>
  </form>
  </body>
</html>