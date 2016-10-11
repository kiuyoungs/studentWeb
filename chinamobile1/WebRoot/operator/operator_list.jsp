<%@ page language="java" import="java.util.*,com.chinamobile.entity.Operator" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'operator_list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style>
a {
	text-decoration: none
}
</style>
		<link href="style/stylet.css"
			rel="stylesheet" type="text/css">
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
    	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<!--
	查询所有操作员
	-->

		<style type="text/css">
<!--
.STYLE3 {
	color: #FFFFFF;
	font-weight: bold;
}
-->
</style>



	

	</head>
	<body link="#73A822" alink="#73A822" vlink="#73A822">
		<font size="2">您现在的位置：>>操作员列表</font>
		<hr>
		<div align="center">
			<form action="OperatorQueryServlet" method="GET"
				onsubmit="return checkMsg();">
				<font size="2">操作员编号:</font>
				<input type="text" name="Operator_ID" id="Operator_ID" size="8">
				<font size="2">操作员姓名:</font>
				<input type="text" name="Operator_Name" id="Operator_Name" size="8">
				<input type="hidden" name="oprFlag" value="1">
				<input type="submit" class="tb_top_1" value="立即查询">
			
			</form>
		</div>

		<br>
		<form action="DeleteManyOperatorServlet" method="GET" 
			onsubmit="return deleteManyConfirm()">
			<input type="hidden" name="flag" value="delete">
			<table cellspacing="1" class="table" align="center">
				<tbody>
					<tr class="table_header">
						<td>
							<div align="center" class="STYLE3">
								选中
							</div>
						</td>
						<td>
							<div align="center" class="STYLE3">
								编号
							</div>
						</td>
						<td>
							<div align="center" class="STYLE3">
								姓名
							</div>
						</td>
						
						<td>
							<div align="center" class="STYLE3">
								权限
							</div>
						</td>
						<td>
							<div align="center" class="STYLE3">
								操作
							</div>
						</td>
					</tr>
					<!-- 请注意:这里我们需要循环显示所有的记录信息 。迭代oprList，这个集合中有几个元素，那么就要输出几个-->
					
						<tr></tr>
						<c:forEach items="${oprList}" var="opr">
							<tr align="center" class="row2" onMouseOver="this.className='row1'"
							onMouseOut="this.className='row2'">
								<td><input type="checkbox" name="ids" id="ids" value="${opr.operatorId }" ></td>
								<td>${opr.operatorId }</td>
								<td>${opr.operatorName}</td>
								<td>${opr.isAdmin }</td>
								<td><a	href="OperatorUpdateServlet?oprId=${opr.operatorId }">修改</a>
									<!-- 去调用confirmDel()，显示确认框-->
									<a	href="javascript:confirmDel('${opr.operatorId }')">删除</a>
								</td>
							</tr>
						</c:forEach>
				</tbody>
			</table>
			<br>
			<br>
			<div align="center">
			
				<input type="submit" class="tb_top_1" value="立即删除">	<br><br>
				
				
				<p class="paging">
					首页|
					<c:if test="${p.currPage>1}"><a	href="OperatorQueryServlet?currPage=${p.currPage-1}">上一页&gt;</a></c:if>
					
					<c:if test="${p.currPage==1}">上一页&gt;</c:if>
					
					|共${p.totalPages}页|第${p.currPage}页|	
					
					<c:if test="${p.currPage<p.totalPages}"><a	href="OperatorQueryServlet?currPage=${p.currPage+1}">下一页&gt;</a></c:if>
					
					<c:if test="${p.currPage==p.totalPages}">下一页&gt;</c:if>
					
					<a	href="">尾页&gt;&gt;</a>	</p>
			</div>
		</form>
		<div align="center">
			<form action="">
				<input type="hidden" name="flag" value="managerOperator">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 跳转
				<input type="text" name="page" size="2" value="1">页	<input type="submit" value="跳">
			</form>
		</div>
		<font color="#0033FF"> </font>
	</body>
</html>
<script type="text/javascript">
		//operator_id		
		function confirmDel(oprId){
			//确认框,用户点击确认按钮，返回true.
			var re = confirm("确认删除吗?");
			if(re==true){
				//提交请求
				window.location.href="OperatorDeleteServlet?oprId="+oprId;
			}
		}	


		function deleteManyConfirm(){
			//判断用户没有勾中多选框中的一行
			
			//1.获取所有的多选框对象
			var idsArr = document.getElementsByName("ids");
			var flag = false;//
			for(var i=0; i<idsArr.length;i++){
				//找到一个多选框被勾中了
				if(idsArr[i].checked == true){
					flag = true;
					break;
				}
			}

			//如果flag为false,则表示一个多选框都没勾中
			if(flag == false){
				alert('请选中一行');
			}else{
				//提交
				//alert('提交表单');
				return confirm("确认删除吗?");
				
			}
			return flag;
		}
	
	function checkMsg(){

	}
</script>