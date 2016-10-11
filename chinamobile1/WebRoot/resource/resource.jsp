<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'resource.jsp' starting page</title>
    
	 <LINK href="style/stylet.css" type=text/css rel=stylesheet>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
   	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<!--
	资源管理
	-->
<script type="text/javascript">
function checkMsg(){
	
}

function checkFile(){
	

}
</script>
  </head>  
  <body  link="#73A822" alink="#73A822" vlink="#73A822">
   <font size="2"> 您现在的位置:>>新增资源</font><br><hr width="100%" size="2">
    <form action="ResourceAddServlet" method="post" onSubmit="return checkMsg();" name="resource" >
    <input type="hidden" name="flag" value="submitresource">    
    号码类型:<input type="radio" name="num" value="SIM">SIM
    <input type="radio" name="num" value="UIM">UIM<br><br>
    指定号段:从<input type="text" name="begin" id="begin">到<input type="text" name="end" id="end">
     <br>
     <br>   
    <input type="submit" class="tb_top_1" value="提交">
    <input type="reset" class="tb_top_1" value="全部重写">   
    </form>
    
  <br>
  <hr>
  <form action="ResourceAddFromTxtServlet" method="post" onSubmit="return checkFile();" enctype="multipart/form-data">
   <input type="hidden" name="flag" value="gettxt">
  从指定文件中导入：<input type="file" name="txtfile" id="txtfile"><br><br>
  <input type="file" name="txtfile" id="txtfile"><br><br>
  <input type="file" name="txtfile" id="txtfile"><br><br>
  <input type="submit" class="tb_top_1" value="提交">
  <input type="reset" class="tb_top_1" value="全部重写">
  <br><br>
  说明：1.只支持txt格式文档的导入！<br>
     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  2.请在导入文档的第一行注明号码类型为SIM或是UIM！<br>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  
    <a href="resource/show_eg.jsp" target="_self"> 3.查看示例！</a>
  </form>
   
  </body>
</html>
