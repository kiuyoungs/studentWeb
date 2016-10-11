<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>创建反馈</title>

<script type="text/javascript">
	function check() {

		if ( $("#content").val() == "") {
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
			<div style="float: left">我的反馈--->创建反馈信息</div>
						<div style="float: right;margin:auto 15px;">
				<a href="javascript:history.back()"> 返回 </a>
			</div>
			<div style="float: right;margin:auto 15px;">
				<a href="user_logout"> 退出系统 </a>
			</div>
		</div>
		<div id="content">
		<form action="feedback_add" method="post">
			<table>
				<tr>
					<td>标题</td>
					<td><input name="fb.title" id="title""></input><br></td>
				</tr>
				<tr>
					<td>内容</td>
					<td><textarea name="fb.content" id="content" style="background:white;"></textarea></td>
				</tr>
				<tr>
					<td>创建者</td>
					<td><input readonly="readonly" id="issuer" 
						value="${sessionScope.user.name }"><input type="hidden" name="fb.issuer" value="${sessionScope.user.id }"/></td>
				</tr>

				<tr>
					<td><input type="hidden" name="fb.planid" value="${pid }"/></td>
					<td><input type="submit" value="添加反馈" onclick="return check();"></input></td>
			</table>
		<form>

	</div>
</div>

</body>
</html>