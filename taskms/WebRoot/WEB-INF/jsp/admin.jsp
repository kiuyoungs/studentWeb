<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
position:relative;
	margin: 20px auto;
	width:90%;
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
#left{
padding: 5px; float: left;
}
#left a{
	color:white;
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
			<div style="float: left">人员管理</div>
			<div style="float: right">
				<a href="user_logout">退出系统</a>
			</div>
		</div>
		<div id="line"></div>
		<div id="content">
			<div id="left">
				<br> <a href="user_toadd">添加账号</a> <br> 
				<a href="user_tolist">账号列表</a> 
				<br>
			</div>
			<div id="show" >
				<c:if test="${not empty list }">

					<table>
						<tr>
							<th>账号</th>
							<th>姓名</th>
							<th>生日</th>
							<th>入职时间</th>
							<th>所属领导</th>
							<th>职务</th>
							<th>处理</th>
						</tr>
						<c:forEach var="item" items="${list}" varStatus="status">
							<tr <c:if test="${status.count%2==0}">bgcolor="#CCCCFE"</c:if>
								align="left">
								<td>${item.account}</td>
								<td>${item.name}</td>
								<td>${item.birthday}</td>
								<td>${item.entry}</td>
								<td>${item.leader}</td>
								<td>${item.role}</td>
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
