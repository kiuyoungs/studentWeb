<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updateUser.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery-1.12.0.min.js"></script>
    <script language="JavaScript" src="js/mydate.js"></script>
    <script type="text/javascript">
	//动态绑定下拉框项  
	function addRoles() {

		$.ajax({
			url : "json/role_listAll", //后台webservice里的方法名称 
			type : "post",
			dataType : "json",
			contentType : "application/json",
			traditional : true,
			success : function(data) {
				var optionstring = "";
				for ( var i in data) {

					//alert(data[i].desc);
					optionstring += "<option value=\"" + data[i].id + "\" >"
							+ data[i].desc + "</option>";
					$("#role")
							.html(
									"<option value='0'>请选择...</option> "
											+ optionstring);
				}
			},
			error : function(msg) {
				alert("出错了！");
			}
		});
	};

	//动态绑定下拉框项  
	function addLeaders() {
		$.ajax({

			url : "json/user_listAllMaster", //后台webservice里的方法名称  
			type : "post",
			dataType : "json",
			contentType : "application/json",
			traditional : true,
			success : function(data) {
				//alert(data);
				var optionstring = "";
				for ( var i in data) {
					//alert(data[i].id);

					optionstring += "<option value=\"" + data[i].id + "\" >"
							+ data[i].name + "</option>";
					$("#leader")
							.html(
									"<option value='0'>请选择...</option> "
											+ optionstring);
				}
			},
			error : function(msg) {
				alert("出错了！");
			}
		});
	};

	function checkAccount() {

		$.ajax({
			type : "POST",
			//使用struts2+struts2-json-plugin-2.2.1.jar的,这些都不用设置  
			//contentType: "text/html;charset=utf-8",  
			//contentType: "application/json;charset=utf-8",  
			url : "json/user_checkAccount",
			data : {
				"u.account" : $("#uaccount").val()
			},
			success : function(data) {
				//alert(data);
				$("#msg").html(data);
			}
		});
	}

	function check() {

		if ($("#uname").val() == "" || $("#upwd").val() == ""
				|| $("#uaccount").val() == "" || $("#birth").val() == ""
				|| $("#entry").val() == "") {
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
	background-image:url('./images/00.jpg');
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
			<div style="float: left">人员管理--->修改账号</div>
						<div style="float: right;margin:auto 15px;">
				<a href="javascript:history.back()"> 返回 </a>
			</div>
			<div style="float: right;margin:auto 15px;">
				<a href="user_logout"> 退出系统 </a>
			</div>
		</div>
		
		<div id="content">
			<form action="user_Update" method="post">
				<table>
				       <input name="u.id" type="hidden" value="${u.id}" />
					<tr>
						<td>账号</td>
						<td><input name="u.account"  value="${u.account }"id="uaccount"onblur="checkAccount();"/>
						<span id="msg" style="color:red;width:300px;" /></td>
					</tr>
					<tr>
						<td>姓名</td>
						<td><input name="u.name" type="text" id="uname"value="${u.name }"/></td>
					</tr>
			

					<tr>
						<td>出生日期</td>
						<td><input name="u.birthday" id="birth"type="text" onfocus="MyCalendar.SetDate(this)" value="${u.birthday }"/></td>
					</tr>
					<tr>
						<td>入职时间</td>
						<td><input name="u.entry" id="entry"type="text"onfocus="MyCalendar.SetDate(this)" value="${u.entry }"/></td>
					</tr>
					<tr>
						<td>直属上级</td>
						<td><select id="leader" name="u.leader_id" ></select></td>
					</tr>
					<tr>
						<td>职务</td>
						<td>
						<select id="role" name="u.role_id"></select></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="修改" onclick="return check();"></input></td>
				</table>
			</form>

		</div>
    
   </div>
   <script type="text/javascript">
		addRoles();
		addLeaders();
	</script>
  </body>
</html>
