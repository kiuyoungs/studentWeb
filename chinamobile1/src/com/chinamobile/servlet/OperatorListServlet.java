package com.chinamobile.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinamobile.dao.OperatorDao;
import com.chinamobile.entity.Operator;

public class OperatorListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("----------OperatorListServlet------------");
		//1.����Dao���еķ�����ȡ���в���Ա
		OperatorDao oprDao = new OperatorDao();
		ArrayList<Operator> oprList = oprDao.getAllOperators();
		
		//2.������oprList���浽ĳ������ request �� ���ݵ�jsp �У�
		request.setAttribute("oprList", oprList);
		
		//3.  ��ת��operator_list.jsp
		String ctx = this.getServletContext().getContextPath();
//		System.out.println("ctx:" + ctx);
//		System.out.println(ctx+"/operator/operator_list.jsp");
		request.getRequestDispatcher("/operator/operator_list.jsp").forward(request, response);
	}

}
