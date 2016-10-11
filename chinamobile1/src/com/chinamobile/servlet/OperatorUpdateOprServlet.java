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
	
	// ���ղ����������� ��װ��Operator dao
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.���ղ���
		String id = request.getParameter("loadID");
		String oprName = request.getParameter("username");
		String oprPwd = request.getParameter("passwd");
		String isAdmin = request.getParameter("manager");

		// 2.�ѽ��յ���ҳ���ύ��4��ֵ���浽һ��Operator������
		Operator opr = new Operator();
		opr.setOperatorId(id);
		opr.setOperatorName(oprName);
		opr.setOperatorPwd(oprPwd);
		opr.setIsAdmin(isAdmin);

		// 3.����OperatorDao���е�addOperator(Operator opr)����
		OperatorDao oprDao = new OperatorDao();
		int r = oprDao.updateOperator(opr);

		// ���r >0 ��˵�������ɹ�
		if (r == 0) {
			System.out.println("�޸�ʧ��.....");
		} 
		response.sendRedirect("/chinamobile/OperatorListServlet");
	}

}
