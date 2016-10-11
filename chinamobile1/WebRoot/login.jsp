<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

//从cookie里去读用户名
String userName = "";
Cookie[] cs= request.getCookies();

if(cs!=null){
	for (Cookie c : cs) {
		//System.out.println(c.getName()+"   " + c.getValue());
		if("loginUserName".equals(c.getName())){
			userName = c.getValue();
			break;
		}
	}
}
System.out.println("19line:"+userName);
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
	<style>
	*{
		margin:0;
		padding:0;
	}
	
	#container{
		width:760px;
		height:570px;
		margin:0 auto;/*设置外边距左右自动即可实现div居中显示，ie8需要注意文档声明*/
		background-image:url(images/denglu1.gif);
		background-position:-76px 0;
		
		position:relative;/*父容器相对定位*/
	}
	
	#tab_box{
		width:260px;
		height:300px;
		/*background:#ccc;*/
		position:absolute;/*孩子元素绝对定位，并且是相对于父容器的左上角*/
		top:255px;
		left:400px;
	}
	
	input.txt{
		
		border:1px solid #ccc;
		height:15px;
		line-height:15px;/*行高*/
		
	}
	
	li{
		list-style:none;
		height:30px;
		line-height:30px;/*垂直居中*/
		font-size:12px;
	}
	
	/*行内元素（内联元素）---------块元素*/
	label{
		display:inline-block;/*行内块元素*/
		width:50px;
		text-align:right;
	}
	
	#changeCode{
		display:inline-block;/*行内块元素*/
		height:30px;/*li的高度一致*/
		line-height:30px;
		margin-left:10px;
	}
	
	#codeImg{
		float:left;
		margin-top:1px;
	}
	
</style>
<script>
	//刷新验证码
	function refreshCode(){
		//alert('aaa');
		document.getElementById("codeImg").src ="CodeServlet?" +Math.random();
	}
</script>


<%
//jsp里的处理和Servlet相同
String error =  request.getParameter("error");
System.out.println("error:"+ error);

if(error!=null && error.equals("0")){
	%>
		<script>
			alert('验证码错误，请重新输入');
		</script>
	<%	
}


if(error!=null && error.equals("1")){
%>
	<script>
		alert('您的用户名或密码错误!请重新登录');
	</script>
<%	
}

//什么情况下需要改userName的值

if(request.getParameter("userName")!=null){
	userName = 	request.getParameter("userName");
}
System.out.println("115line:"+userName);
%>

  </head>
  
  <body>
    <div id="container">
  	  <div id="tab_box">
  	  	<h2>欢迎登录</h2>
  	  	<form action="LoginServlet" method="post">
   		<ul>
   			<li ><label>用户：</label><input class="txt" type="text" name="userName" value="<%=userName%>" /></li>
   			<li ><label>密码：</label><input class="txt" type="password" name="password" /></li>
   			<li><label>验证码：</label><input  class="txt" type="text" name="userCode" /></li>
   			<li>
   				<img id="codeImg" src="CodeServlet"></img>
   				<span id="changeCode"><a  href="javascript:refreshCode()">看不清，换一张</a>
   					<input type="checkbox" name="rem" />记住用户名
   				</span>
   			</li>
   			<li style="text-align: center"><input type="submit" value="登录"/> <input type="reset" value="重置"/></li>
   		</ul>
   		</form>
  	  </div>
    </div>
  </body>
</html>
