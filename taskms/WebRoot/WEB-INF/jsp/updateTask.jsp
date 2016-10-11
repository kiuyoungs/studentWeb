<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改任务</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script language="JavaScript" src="js/mydate.js"></script>

<script type="text/javascript" src="js/jquery-1.12.0.min.js"></script>
<script type="text/javascript">
	//动态绑定下拉框项  
	function addExecutors() {
		$.ajax({

			url : "json/user_listAllMaster", //后台webservice里的方法名称  
			type : "post",
			dataType : "json",
			
			traditional : true,
			success : function(data) {
				//alert(data);
				var optionstring = "";
				for ( var i in data) {
					//alert(data[i].id);

					optionstring += "<option value=\"" + data[i].id + "\" >"
							+ data[i].name + '-' + data[i].account
							+ "</option>";
					$("#executor")
							.html(
									"<option value='0'>请选择...</option> "
											+ optionstring);
				}
			},
			error : function(msg) {
				//alert($("#issuer").val());
				alert("出错了！");
			}
		});
	};

	function check() {

		if ($("#title").val() == "" || $("#starttime").val() == ""
				|| $("#endtime").val() == "" || $("#executor").val() == "0") {
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
			<div style="float: left">任务列表--->修改任务</div>
						<div style="float: right;margin:auto 15px;">
				<a href="javascript:history.back()"> 返回 </a>
			</div>
			<div style="float: right;margin:auto 15px;">
				<a href="user_logout"> 退出系统 </a>
			</div>
		</div>

		<div id="content">
			<form action="task_Update" method="post">

				<table>
					<tr>
						<td>标题<input type="hidden" name="t.id" value="${t.id }"/> </td>
						<td><input name="t.title" id="title" value="${ t.title}"></input><br></td>
					</tr>
					<tr>
						<td>内容</td>
						<td><textarea name="t.content" id="content" style="background:white;">${t.content }</textarea></td>
					</tr>
					<tr>
						<td>开始日期</td>
						<td><input name="t.starttime" id="starttime" onfocus="MyCalendar.SetDate(this)" value="${t.starttime }"/></td>
					</tr>
					<tr>
						<td>结束日期</td>
						<td><input name="t.endtime" id="endtime"onfocus="MyCalendar.SetDate(this)" value="${t.endtime }"/></td>
					</tr>
					<tr>
						<td>创建者</td>
						<td><input readonly="readonly" value="${t.issuer }"><input
							type="hidden" id="issuer" name="t.issuer" value="${t.id}" /></td>
					</tr>
					<tr>
						<td>执行者</td>
						<td><select id="executor" name="t.executor"></select></td>
					</tr>

					<tr>
						<td></td>
						<td><input type="submit" value="确定修改"
							onclick="return check();"></input></td>
				</table>
			</form>


		</div>

	</div>
	<script type="text/javascript">
		addExecutors();
	</script>
  
  </body>
</html>
