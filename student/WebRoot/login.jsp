<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

//从cookie中读用户名
String username ="";
Cookie[] cs=request.getCookies();

if(cs!=null)
{
	for(Cookie c : cs){
		if("loginusername".equals(c.getName())){
			username = c.getValue();
			break;
		}
		
	}
}

String username1 ="";


if(cs!=null)
{
	for(Cookie c : cs){
		if("loginusername".equals(c.getName())){
			username1 = c.getValue();
			break;
		}
		
	}
}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
   <style>
  	*{margin:0px;padding:0px;}
	#top{width:100%;height:70px;
		background-image:url(images/tf.jpg);
		font-size:18px;font-family:Arial, Helvetica, sans-serif;
		font-style:oblique;color:#F00;text-align:center;
		line-height:70px;}
	#mid{width:100%;height:430px;}
	.left{float:left;
		width:530px;height:430px;}
	.right{float:right;width:*;height:300px;}
	.stu{position:absolute;
		top:255px;
		left:750px;
		border:1px solid #ccc;
		padding:5px;}
	.stu ul{line-height:30px;}
	li{list-style:none;}
	lable{display:inline-block;
		width:70px;
		height:30px;
		text-align:right;
	}
	.tea{position:absolute;
		top:255px;
		left:1050px;
		border:1px solid #ccc;
		padding:5px;}
	.tea ul{line-height:30px;}
	input.ttt{
		width:60px;
		height:20px;
		line-hright:20px;
		color:#fff;
		border:0px;
		background:#6374ce;
		
	}
	.d{
		display:block;
		text-align:center;}
	#foot{width:100%;height:75px;
		background-image:url(images/tf.jpg);}
	
  </style>
  <%
  	String error = request.getParameter("error");
  	System.out.println("error"+error);
  	
  	if(error!=null && error.equals("1")){
   %>
   	<script type="text/javascript">
   		alert("您的用户名错误请重新登录");
   	</script>
   <%}

   if(request.getParameter("username")!=null){
   	username=request.getParameter("username");
   }
   
   if(request.getParameter("username1")!=null){
	   	username1=request.getParameter("username1");
	   }
    %>
  <body> 
	<div id="top"><h1>学生考勤系统</h1></div>
	<div id="mid">
		<div class="left"><img src="images/3.jpg"></div>
		<div class="right">
			<!--<div class="r_top"></div>-->
			
				<div class="stu">
                	<form action="dengluservlet" method="post">
    					<ul>
                        	<li style="font-size:40px;text-align:center;">学生登录</li><br>
    						<li><lable>用户名：</lable><input type="text" name="username" value="<%=username %>"></li>
    						<li><lable>密码：</lable><input type="password" name="password"></li>
    						<li><span class="d"><input class="ttt" type="submit" value="确认">&nbsp;&nbsp;<input class="ttt" type="reset" value="重置"></span></li>
    						<li>如果没有账户请新注册一个账号<span class="d"><a href="zhuce.jsp"><input class="ttt" type="button" value="注册"></a></li>
    					</ul>
    				</form>
                </div>
				<div class="tea">
					<form action="dengluservlet1" method="post">
    					<ul>
                        	<li style="font-size:40px;text-align:center;">管理员登录</li><br>
    						<li><lable>用户名：</lable><input type="text" name="username1" value="<%=username1 %>"></li>
    						<li><lable>密码：</lable><input type="password" name="password1"></li>
    						<li><span class="d"><input class="ttt" type="submit" value="确认">&nbsp;&nbsp;<input class="ttt" type="reset" value="重置"></span></li>
    					</ul>
    				</form>
				</div>
			
		</div>
	</div>
	<div id="foot"></div>
  </body>
</html>
