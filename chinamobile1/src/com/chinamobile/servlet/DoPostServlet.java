package com.chinamobile.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DoPostServlet extends HttpServlet {
	
	//ע��һ�� ctrl +/ 
	//ע�Ͷ��� ��ѡ��Ҫע�͵���Щ��   ctrl + shift + /
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//����Request���ַ�����ҳ��ı��뷽ʽһ�£���������ã�Ĭ�ϲ��õ���iso8859-1����
		req.setCharacterEncoding("utf-8");
		//���������ҳ���ĵ����ͼ����뷽ʽ,ע�⣺��������ַ������������ڴ���out�������������֮ǰ
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		
		//��ȡ�ͻ����ύ�Ĳ���
		String no = req.getParameter("no");
		System.out.println(no);
		//��servlet������ĵ�ҳ���������
		out.println("���");
	}
	
	//ֻ����get��ʽ���ύ
/*	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.println(" do get....");
	}*/
}
