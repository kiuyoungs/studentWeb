<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'jstl1.jsp' starting page</title>
    
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
    <c:out value="&lt要显示的数据对象（未使用转义字符）&gt" escapeXml="true" default="默认值"></c:out><br/>
	<c:out value="&lt要显示的数据对象（使用转义字符）&gt" escapeXml="false" default="默认值"></c:out><br/>

    <c:out value="${username}" escapeXml="false"></c:out>

	c:set相当于setAttribute：
	<c:set value="张三" var="name1" scope="session"></c:set>
	<% //session.setAttribute("name1","张三"); %>
	<hr/>
	取值（推荐的方法el表达式）：
	${name1}  

	<hr/>
	测试c:if标签<br/>
	<%request.setAttribute("username","tom1"); %>
	
	如果username为tom，就输出yes.注意test属性中可以写el表达式
	<c:if test="${username == 'tom'}">
		yes
	</c:if>
  </body>
</html>
