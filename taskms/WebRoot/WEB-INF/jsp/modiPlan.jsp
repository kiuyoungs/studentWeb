<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'modiPlan.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script language="JavaScript" src="js/mydate.js"></script>
<script type="text/javascript">
function check() {

		if ($("#title").val() == "" || $("#starttime").val() == ""
				|| $("#endtime").val() == "" || $("#content").val() == "") {
			alert("请填写完整再提交");
			return false;
		}
		return true;
	}
</script>
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
  
  <div id="container">
		<div id="header">
			<div style="float: left">我的计划--->修改计划</div>
						<div style="float: right;margin:auto 15px;">
				<a href="javascript:history.back()"> 返回 </a>
			</div>
			<div style="float: right;margin:auto 15px;">
				<a href="user_logout"> 退出系统 </a>
			</div>
		</div>
		<div id="content">
			<form action="plan_Update" method="post">

				<table>
					<tr>
						<td>标题<input type="hidden" name="p.id" value="${p.id }"/> </td>
						<td><input name="p.title" id="title" value="${ p.title}"></input><br></td>
					</tr>
					<tr>
						<td>内容</td>
						<td><textarea name="p.content" id="content" style="background:white;border:1;">${ p.content}</textarea></td>
					</tr>
					<tr>
						<td>开始日期</td>
						<td><input name="p.starttime" id="starttime" onfocus="MyCalendar.SetDate(this)" value="${p.starttime }"/></td>
					</tr>
					<tr>
						<td>结束日期</td>
						<td><input name="p.endtime" id="endtime"onfocus="MyCalendar.SetDate(this)" value="${p.endtime }"/></td>
					</tr>
					

					<tr>
						<td></td>
						<td><input type="submit" value="确定修改"
							onclick="return check();"></td>
				</table>
			</form>


		</div>

	</div>
	
  
  </body>
</html>
