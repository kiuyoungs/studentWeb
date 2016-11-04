<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'new_information.jsp' starting page</title>
    
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
  <script type="text/javascript">
   function check(obj){
		
   }
   </script>
    <form method="get" action="StudentAddServlet1"	onsubmit="return check(this)">
		
		<table  cellspacing="1" align="center" border="1">
			<tr>
				<td width="20%">
					&nbsp;&nbsp;&nbsp;学生Id：
				</td>
				<td>
					<input type="text" name="loadID">
					*五位数字
				</td>
			</tr>
			<tr>
				<td width="20%">
					&nbsp;&nbsp;&nbsp;课程Id：
				</td>
				<td>
					<input type="text" name="classID">
					*五位数字
				</td>
			</tr>
			<tr>
				<td width="20%">
					&nbsp;&nbsp;&nbsp;考勤Id：
				</td>
				<td>
					<input type="text" name="attenID">
				*五位数字
				</td>
			</tr>
			
			<tr>
				<td width="20%">
					&nbsp;&nbsp;&nbsp;日&nbsp; 期：
				</td>
				<td>
					<input type="text" name="date">
					*按照年-月-日格式填写
				</td>
			</tr>

			<tr>
				<td width="20%">
					&nbsp;&nbsp;&nbsp;考勤记录：
				</td>
				<td class="formtb_right">
					<input type="text" name="attention">
					*请假或者未请假
				</td>
			</tr>

		</table>
			<br>
			<br>
			<p align="center">
				<input type="submit" value="提交">
				&nbsp;&nbsp;&nbsp;
				<input type="reset" value="全部重写">
			</p>
		</form>
  </body>
</html>
