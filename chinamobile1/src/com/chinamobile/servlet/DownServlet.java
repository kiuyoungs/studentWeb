package com.chinamobile.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//response.setContentType("text/html;charset=utf-8");
		response.setContentType("application/vnd.ms-excel");
		//������Ӧͷ
		response.setHeader("Content-Disposition","filename=test.xls");
		PrintWriter out = response.getWriter();
		//�κ�����DownServlet��web��Դ ����Referer���ǳ���
		
		//��һ������ȡReferer��ֵ
		String referer = request.getHeader("Referer");
		//http://localhost:8080/aaa/down.html
		System.out.println(referer);
		//��һ�����ԣ��Լ���վ���ʣ�http://localhost:8080/chinamobile/downSelf.html
		//�ڶ������ԣ������վ���ʣ�http://localhost:8080/aaa/down.html
		
		//�ڶ�������referer���Լ���վ���ƽ��бȽϡ�http://localhost:8080/chinamobile
		//String�ṩ��startsWith�������ж�referer�Ƿ���������վ��ͷ���������true����ʾ���Է��ʣ�����Ƿ�����
		String selfPro = "http://"+ request.getServerName()+":"+ request.getServerPort()+request.getContextPath();
		
		System.out.println("�Լ���վ��"+selfPro);
		
		if(referer.startsWith(selfPro)==true){
			//��ʾվ�ڷ���
			out.println("100");
			
		}else{
			//��ʾվ�����
			out.println("�Ƿ�����....<a href='index.html'>���ȷ��ʱ���վ</a>");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	}

}
