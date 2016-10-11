<%@ page language="java" import="java.util.*,com.chinamobile.entity.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'foreach.jsp' starting page</title>
    
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
    <!-- 创建几个operator对象，保存到Arraylist中，再使用foreach迭代输出ArrayList中的所有operator对象 -->
    <%
	Operator o1 = new Operator();
	o1.setOperatorName("Tom1");
	o1.setOperatorPwd("aaa1");
	
	Operator o2 = new Operator();
	o2.setOperatorName("Tom2");
	o2.setOperatorPwd("aaa2");
	
	Operator o3 = new Operator();
	o3.setOperatorName("Tom3");
	o3.setOperatorPwd("aaa3");
	
	List list = new ArrayList();
	list.add(o1);
	list.add(o2);
	list.add(o3);
	
	request.setAttribute("list1",list);
    %>
    
    <!-- 使用foreach迭代输出ArrayList中的所有operator对象  ,var后面的变量名表示的是当前迭代的对象，保存到pageContext-->
    <c:forEach items="${list1}" var="opr" >
		id:${opr.operatorId }-----name:${opr.operatorName}----pwd:${opr.operatorPwd }----isAdmin:${opr.isAdmin }<br/>
    </c:forEach>
    
  </body>
</html>
