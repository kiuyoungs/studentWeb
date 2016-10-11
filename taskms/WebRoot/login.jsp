<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


<title>登录</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->


<style>
* {
	margin: 0 auto
}

#container {
	width: 948px;
	height: 576px;
	background-image:url(images/login.jpg);
	margin: 0, auto;
	background-position: -76px, 0px;
	position: relative;
}

#tab_box {
	width: 250px;
	height: 300px;
	/*background-color:yellow;*/
	position: absolute;
	top: 255px;
	left: 360px;
}

#tab_box text {
	height: 15px;
	border: solid 1px;
	line-height: 15px;
	color: #6374CE;
}

#tab_box h3 {
	text-align: center;
}

li {
	list-style: none;
	font-size: 12px;
	font-weight: bold;
	color: #6374CE;
	height: 30px;
}

//
li img {
	float: left;
}

#tab_box ul li submit {
	width: 60px;
	height: 20px;
	line-height: 20px;
	backgoround-color: #6374ce;
	color: #fff;
}

#tab_box ul li span {
	height: 30px;
}
</style>

</head>

<body>
	<div id="container">
		<div id="tab_box">

			<form action="user_login" method="post">
				<h3>欢迎登录</h3>

				<ul>
					<li>用&nbsp;&nbsp;户:<input type="text" name="u.account"
						>
					</li>
					<li>密&nbsp;&nbsp;码:<input type="password" name="u.pswd">
					</li>
					<li><input type="submit" value="确认" name="" /> <input
						type="reset" value="重置" /></li>
				</ul>
			</form>
		</div>
	</div>

</body>
</html>
