<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'manager.jsp' starting page</title>
    
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
  	*{margin:0px;padding: 0px;}
  	#SS{background-image:url("images/gly.gif");width:932px;height:538px;}
  	#left{width:230px;height:538px;float:left;}
  	#left span{display:block;
  		width:14px;line-height:50px;height:100px;
  		margin-left:105px;padding-top:120px;
  		font-size:50px;font-family:Helvetica, sans-serif;
		font-style:oblique;color:blue;text-align:center;
  		}
  	#right{width:450;height:400px;
  		float:right;
  		margin-right:230px;margin-top:70px;}
  	.tt{width:90px;height:400px;
  		float:left;margin-left:90px;}
  	.t_top{width:90px;height:80px;
  		margin-top:80px;}
  	.t_foot{width:90px;height:80px;
  		margin-top:80px;}
  	.ff{width:90px;height:400px;
  		float:right;margin-right:90px;}
  	.f_top{width:90px;height:80px;
  		margin-top:80px;}
  	.f_foot{width:90px;height:80px;
  		margin-top:80px;
  		}
  </style>
  <body>
    <div id="SS">
    	<div id="left"><span>学生考勤管理</span></div>
    	<div id="right">
    		<div class="tt">
    			<div class="t_top"><a href="StudentListServlet"><img src="images/xx.jpg"></a></div>
    			<div class="t_foot"><a href="StudentCountServlet"><img src="images/tj.png"></a></div>
    		</div>
    		<div class="ff">
    			<div class="f_top"><a href="StudentListServlet1"><img src="images/cx.jpg"></a></div>
    			<div class="f_foot"><a href="login.jsp"><img src="images/tc.png"></a></div>
    		</div>
    	</div>
    </div>
  </body>
</html>
