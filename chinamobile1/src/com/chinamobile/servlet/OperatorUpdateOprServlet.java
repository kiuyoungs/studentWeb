package com.chinamobile.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinamobile.dao.OperatorDao;
import com.chinamobile.entity.Operator;

public class OperatorUpdateOprServlet extends HttpServlet {
	
	// 接收参数。。。。 封装到Operator dao
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.接收参数
		String id = request.getParameter("loadID");
		String oprName = request.getParameter("username");
		String oprPwd = request.getParameter("passwd");
		String isAdmin = request.getParameter("manager");

		// 2.把接收到的页面提交的4个值保存到一个Operator对象中
		Operator opr = new Operator();
		opr.setOperatorId(id);
		opr.setOperatorName(oprName);
		opr.setOperatorPwd(oprPwd);
		opr.setIsAdmin(isAdmin);

		// 3.调用OperatorDao类中的addOperator(Operator opr)方法
		OperatorDao oprDao = new OperatorDao();
		int r = oprDao.updateOperator(opr);

		// 如果r >0 ，说明新增成功
		if (r == 0) {
			System.out.println("修改失败.....");
		} 
		response.sendRedirect("/chinamobile/OperatorListServlet");
	}

}
