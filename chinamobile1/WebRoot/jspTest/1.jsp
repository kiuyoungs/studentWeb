<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

//输出控制台
System.out.println(basePath);

//输出到页面 jsp提供了9大内置对象 out,内置对象直接使用
out.println(basePath);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP '1.jsp' starting page</title>
    
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
  <!-- 要使Java代码能被服务器正确解析，必须放在<% %>之间 -->
  <% 
  Date d = new Date();
   out.println(d.toString());
   
   String userName = "Tom";
   //在_jspService方法中
   getName();
   %>
   
   <%out.println(userName);%>
   
   推荐写法：
   <%=userName%>
   
   <%! int i=0; 
   	public void getName(){
   		System.out.println("hello....");
   	}
   %>
  </body>
</html>
