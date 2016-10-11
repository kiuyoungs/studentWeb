<%@ page language="java" import="java.util.*,com.chinamobile.entity.Operator" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<!-- base标签表示本页面中所有的相对路径都是相对于basePath变量，而basePath的值就是chinamobile -->
    <base href="<%=basePath%>">
    
    <title>My JSP 'new_operator.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	 <LINK href="style/style.css" type=text/css rel=stylesheet>
	</head>

	<body >
		<script type="text/javascript">
   function check(obj){
		
   }
   
   
   
   </script>

		<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
			<TBODY>
				<TR>
					<TD height=25>
						<font size="2">您现在的位置：>>修改操作员</font>
						<hr>
					</TD>
				</TR>

				<TR>
					<TD>
						<IMG height=2 src="images\blank(1).gif" width=574>
					</TD>
				</TR>
			</TBODY>
		</TABLE>
		<TR align="top">
			<TD height="600" bgColor=#f1f3f9>
			<%  Operator opr = (Operator)request.getAttribute("opr"); 
			%>
				<form method="get" action="OperatorUpdateOprServlet"	onsubmit="return check(this)">
					<input type="hidden" name="flag" value="submitnewoperator">
					<table  cellspacing="1" class="form_table1" align="center">
						<tr>
							<td width="20%">
								&nbsp;&nbsp;&nbsp;登录ID：
							</td>
							<td class="formtb_right">
								<!-- 如果把某个表单元素设置为disabled后，表单就不会提交这个值 -->
								<input type="text" name="loadID"  value="<%=opr.getOperatorId() %>"  readonly="readonly">
								*至少四位数字
							</td>
						</tr>
						<tr>
							<td width="20%">
								&nbsp;&nbsp;&nbsp;姓&nbsp; 名：
							</td>
							<td class="formtb_right">
								<input type="text" name="username"  value="<%=opr.getOperatorName() %>">
								*不超过20位
							</td>
						</tr>
						<tr>
							<td width="20%">
								&nbsp;&nbsp;&nbsp;密&nbsp; 码：
							</td>
							<td class="formtb_right">
								<input type="text" name="passwd"  value="<%=opr.getOperatorPwd() %>">
								*至少六位数字
							</td>
						</tr>
						<tr>
							<td width="20%">
								&nbsp;&nbsp;&nbsp;密码确认：
							</td>
							<td class="formtb_right">
								<input type="password" name="passwd1">
								*至少六位数字
							</td>
						</tr>


						<tr>
							<td width="20%">
								&nbsp;&nbsp;&nbsp;是否管理员：
							</td>
							<td class="formtb_right">
								<input type="radio" value="Y" name="manager" 
								 <c:if test="${opr.isAdmin=='Y' }">checked</c:if> >
								是 &nbsp;
								<input type="radio" value="N" name="manager" 
								 <c:if test="${opr.isAdmin=='N' }">checked</c:if>  >
								否
							</td>
						</tr>
					</table>
					<br>
					<br>
					<p align="center">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="submit" value="提交">
						&nbsp;&nbsp;&nbsp;
						<input type="reset" value="全部重写">
					</p>
				</form>
			</TD>
		</TR>
		<font color="red">
		  </font>
	</body>
</html>