<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'zhuce.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  <style type="text/css">
        *{margin:0px;padding:0px;}
        .status1{
            color:#aaa;
        }
        li{
            list-style: none;

        }
        li{list-style:none;border:0px solid #ccc;height:30px;line-height:30px;font-weight:bold;}
        li-zclist{display: block}
        input.tex{height:20px;
            text-size:12px;;
            line-height:20px;
        }
     	li-lable{display:block;
            width:60px;
            height:30px;
            text-align:right;
        }
        #c{float:left;}
		#head{
			background-size:100%;
    		background-image:url(images/11.jpg);
   			width:800px;
    		height: 28px;
    		color: white;;
    		margin:0 auto;
		}
        .ge{
            line-height: 28px;
        }
        .aaa{margin-left:320px;}
        .ttt{width:60px;
			height:20px;
			line-hright:20px;
			color:#fff;
			border:0px;
			background:#6374ce;}
		
    </style>
</head>
<body>

    <div>
     <div  id="head" class="zc" height: 34px;>
        <a>&nbsp;&nbsp;<span class="ge">个人中心</span></a>
     </div>
     <div class="aaa">
     <form action="StudentAddServlet" method="get">
        <ul class="zclist" >
            <li><label>用户名：</label><input class="txt" type="text" name="username"><span class="status1">&nbsp;&nbsp;请输入用户名</span></li>
            <li><label>学     号：</label><input class="txt" type="text" name="stu_id"></li>
            <li><label>班     级：</label><input class="txt" type="text" name="class_number"></li>
            <li><label>密     码：</label><input class="txt" type="password" name="password"><span class="status1">&nbsp;&nbsp;密码长度小于10</span> </li>
			<li><label>生     日：</label><input class="txt" type="text" name="birthday"></li>
			<li><label>手     机：</label><input class="txt" type="text" name="contact_way"></li>
            <li><label>性     别：</label><input type="radio" name="sex" value="male">男
                <input type="radio" name="sex" value="female">女</li>
          	<li><span><input class="ttt" type="submit" value="提交"></span></li>
        </ul>
        </form>
        </div>
    </div>

</body>
</html>