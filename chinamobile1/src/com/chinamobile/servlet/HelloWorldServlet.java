package com.chinamobile.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.Request;

public class HelloWorldServlet extends HttpServlet {
	String charset = "gbk";
	//alt +"/"
	//可以响应用户以get方式提交的请求
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		System.out.println("hello world...");
		System.out.println(charset);
		PrintWriter out = resp.getWriter();
		out.println("你好");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	}
	
	public void init() throws ServletException {
		System.out.println("------在创建Servlet对象的时候执行----------------并且只执行一次---");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		charset = config.getInitParameter("charset");
		super.init(config);
	}
}
