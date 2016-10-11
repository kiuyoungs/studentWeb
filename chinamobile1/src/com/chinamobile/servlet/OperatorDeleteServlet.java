package com.chinamobile.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinamobile.dao.OperatorDao;


public class OperatorDeleteServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String oprId = request.getParameter("oprId");
		
		//调用Dao类的delete方法, ctrl+shift+o
		OperatorDao oprDao =new OperatorDao();
		int r = oprDao.deleteOperator(oprId);
		if(r>0){
			//删除成功,跳转到列表页面
			//request.getRequestDispatcher("/operator/operator_list.jsp").forward(request, response);
			response.sendRedirect("OperatorQueryServlet");
		}else{
			//
			System.out.println("删除失败。。。");
		}
		
	}

}
