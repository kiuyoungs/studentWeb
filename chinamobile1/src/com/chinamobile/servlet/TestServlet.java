package com.chinamobile.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
//		req.setCharacterEncoding("utf-8");
//		resp.setContentType("text/html;charset=utf-8");
		//改成输出到网页
//		PrintWriter out = resp.getWriter();
//		out.println("hello world.....");
		System.out.println("ddddddddddddddd");
		req.getRequestDispatcher("login.html").forward(req, resp);
	}

}
