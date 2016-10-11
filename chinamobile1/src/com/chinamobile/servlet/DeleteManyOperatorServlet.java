package com.chinamobile.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinamobile.dao.OperatorDao;

public class DeleteManyOperatorServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//��ȡ����ѡ���ύ��idֵ���ж��
		String[] ids = request.getParameterValues("ids");
		
		OperatorDao od = new OperatorDao();
		int r = od.deleteMany(ids);
		
		if(r==0){
			System.out.println("ɾ��ʧ��...");
		}
		//����ɾ���ɹ������ת���б�ҳ��
		response.sendRedirect("OperatorQueryServlet");
	}
}
