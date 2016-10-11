package com.chinamobile.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DoPostServlet extends HttpServlet {
	
	//注释一行 ctrl +/ 
	//注释多行 先选中要注释的那些行   ctrl + shift + /
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置Request的字符集和页面的编码方式一致，如果不设置，默认采用的是iso8859-1编码
		req.setCharacterEncoding("utf-8");
		//设置输出网页的文档类型及编码方式,注意：设置输出字符集的语句必须在创建out（输出流）对象之前
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		
		//获取客户端提交的参数
		String no = req.getParameter("no");
		System.out.println(no);
		//从servlet输出中文到页面会有乱码
		out.println("你好");
	}
	
	//只处理get方式的提交
/*	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.println(" do get....");
	}*/
}
