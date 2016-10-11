package com.chinamobile.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DoGetServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//对get提交无效的
		response.setContentType("text/html;charset=utf-8");//处理输出中文
		PrintWriter out = response.getWriter();
		String no = request.getParameter("no");//
		request.getRequestURL();
		
		String reqURL = request.getRequestURL().toString();
		
		System.out.println(reqURL);
		
		String reqURI = request.getRequestURI();
		System.out.println(reqURI);
		
		String queryString = request.getQueryString();
		System.out.println(queryString);
		
		System.out.println(no);
		
		String serverName = request.getServerName();
		System.out.println(serverName);
		
		String port = request.getServerPort()+"";
		
		System.out.println(port);
		
		String context = request.getContextPath();
		System.out.println(context);
		
		String realPath = this.getServletConfig().getServletContext().getRealPath("/");
		System.out.println(realPath);
		
		out.println(no);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	}

}
