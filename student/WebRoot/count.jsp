<%@ page language="java" import="java.util.*,com.student.entity.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'count.jsp' starting page</title>
    
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
 <%  Attendance stu = (Attendance)request.getAttribute("stu"); %>
  <form action="" method="get">
    <table border='1'cellspacing="0" cellpadding="0" align="center">
    	<tr align="center">
    		<td colspan="3">考勤统计</td>
    	</tr>
    	<tr align="center">
    		<td>学生Id</td>
    		<td>班级</td>
    		<td>请假次数</td>
    	</tr>
    	<c:forEach items="${stuList}" var="stu">
					
			<tr align="center" class="row2" onMouseOver="this.className='row1'"
				onMouseOut="this.className='row2'">

				<!-- <td><input type="checkbox" name="ids" id="ids" value="${opr.operatorId}"></td> -->
				<td>${stu.studentId}</td>
				<td>${stu.studentClass}</td>
				<td><%=stu.getAttenRecord() %></td>
			</tr>
					
		</c:forEach>
    </table>
  </form>
  </body>
</html>
