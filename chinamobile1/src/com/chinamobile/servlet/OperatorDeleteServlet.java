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
		
		//����Dao���delete����, ctrl+shift+o
		OperatorDao oprDao =new OperatorDao();
		int r = oprDao.deleteOperator(oprId);
		if(r>0){
			//ɾ���ɹ�,��ת���б�ҳ��
			//request.getRequestDispatcher("/operator/operator_list.jsp").forward(request, response);
			response.sendRedirect("OperatorQueryServlet");
		}else{
			//
			System.out.println("ɾ��ʧ�ܡ�����");
		}
		
	}

}
