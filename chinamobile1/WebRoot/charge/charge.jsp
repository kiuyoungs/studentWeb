<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
     <link href="style/stylet.css"
			rel="stylesheet" type="text/css">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<!--
	配置业务费用
	-->
	<script type="text/javascript">

	//等文档加载完毕后执行
	window.onload=function(){
		//先要找到下拉框，然后再获取所有的option（数组）
		var sel = document.chargeform.gmtyp;
		//alert(sel);
		sel.value= '${cha.chargeCode}';
		/*var opts = sel.options;
		//console.info(opts);
		
		//迭代这个option数组，判断当前的option的chargeCode(value值)是否和 Servlet传递的cha的chargeCode相等
		for(var i=0; i<opts.length;i++){
			//若相等则选中这个option
			if(opts[i].value == '${cha.chargeCode}'){
				//alert('aaaaa');
				opts[i].selected = true;
				break;
			}
		}*/

		
	}
	
	</script>
	
  </head> 
  
 <body >
    <font size="2">您现在的位置:>>配置业务</font>&nbsp;<br><hr width="95%" size="2" align="center">
    
    <form action="ChargeDataServlet" method="get" name="chargeform" id="cf">
      
    <dir style="font-size:18px">收费细项</dir>
    <input type="hidden" name="flag" value="findv"> <!-- 用于查询收费细项的金额 -->    
    收费项目:    
    <select  name="gmtyp" onChange="document.chargeform.submit()">
    	<c:forEach items="${chgList}" var="chg">
    		<option value="${chg.chargeCode}">${chg.chargeName }</option>
    	</c:forEach>
    </select>
    <br> 
    <br>
    
    收费金额: <input type="text" name="money" value="${cha.charge}" ><br><br>
    <input type="button" class="tb_top_1"  value="修改收费金额" onClick="location.replace('../charge/update_charge.jsp')">
    <input type="reset" class="tb_top_1"  value="全部重写">
    </form>
 <font color="#FF00FF">  </font>
  
    <hr width="100%" size="2">     
    <form action="ChargeMgrServlet">
    <input type="hidden" name="flag" value="updatecharge2">
    <dir style="font-size:18px">业务收费</dir>
    业务:
    <select name="web">
    <option value="开户业务">开户业务</option>
    </select>
    <br><br>
    收费项目:
    <c:forEach items="${chgList}" var="chg">
   	 <input type="checkbox" name="c" value="${chg.chargeCode}"  ${chg.checked} >${chg.chargeName}
    </c:forEach>
    <br>
    <input type="submit" class="tb_top_1"  value="提交">
    <input type="reset" class="tb_top_1"  value="全部重写">
  
    </form>
   <font color=""></font>    
      
  </body>
</html>

