<%@ page language="java" import="java.util.*,com.chinamobile.entity.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'el.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
<%
	//request
	//在request和session域中有同名的变量str
	request.setAttribute("str","hello");
	session.setAttribute("str","world");
	//String str = "hello";
	
	List list = new ArrayList();
	list.add("AAA");
	list.add("BBB");
	request.setAttribute("list",list);
	Operator o = new Operator();
	o.setOperatorName("Tom");
	o.setOperatorPwd("aaa");
	request.setAttribute("o",o);
	
	Map map = new HashMap();
	map.put("username","kkkk");
	map.put("pwd","aaaaaa");
	request.setAttribute("m",map);
%>  
  <body>
   jsp表达式输出：<%=session.getAttribute("str") %> <br/>
   el表达式输出：${str}<br/>
      希望用el表达式在session域中取str的值：${sessionScope["str"] }
   <hr/>
      如果获取的变量名没有赋值，jsp表达式输出null：<%=request.getAttribute("str1") %> <br/>
  el表达式输出空串：${str1}
  <hr/>
   	访问list的第1个元素：${list[0]}
   	<hr/>
   	访问对象的属性：${o.operatorName}---${o.operatorPwd }
   	<hr/>
   	访问map: ${m["username"]}----${m["pwd"]}
   	
   	<hr/>
   	获取url后传递的参数：${param["age"]}
   	
  </body>
</html>
