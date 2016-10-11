package com.chinamobile.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MultiValueServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		String userId = request.getParameter("userId");
//		System.out.println(userId);
		
		//获取多个name=userId的值
//		String[] userIds = request.getParameterValues("userId");
//		
//		for(int i=0; i<userIds.length; i++){
//			System.out.println(userIds[i]);
//		}
		
		String accept = request.getHeader("Accept");
		System.out.println(accept);
		String encoding = request.getHeader("Accept-Encoding");
		System.out.println(encoding);
		String ref = request.getHeader("Referer");
		System.out.println(ref);
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

}
