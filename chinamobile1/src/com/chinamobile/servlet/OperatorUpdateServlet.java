package com.chinamobile.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinamobile.dao.OperatorDao;
import com.chinamobile.entity.Operator;

public class OperatorUpdateServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String oprId = request.getParameter("oprId");
		
		//调用dao中的方法，根据id查询出operator对象
		Operator opr = null;
		OperatorDao oprDao = new OperatorDao();
		opr = oprDao.getOperatorById(oprId);
		
		//把opr保存到request域中
		request.setAttribute("opr", opr);
		request.getRequestDispatcher("/operator/operator_update.jsp").forward(request, response);

	}

}
