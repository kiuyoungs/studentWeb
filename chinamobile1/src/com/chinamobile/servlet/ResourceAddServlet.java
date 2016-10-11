package com.chinamobile.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinamobile.dao.ResourceDao;

public class ResourceAddServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//接收3个参数
		String type = request.getParameter("num");
		String begin = request.getParameter("begin");
		String end = request.getParameter("end");
		
		//转不了int,1390000000超过了int
		long beginInt = Long.parseLong(begin);
		long endInt = Long.parseLong(end);
		
		ResourceDao reDao = new ResourceDao();
		
		int r = reDao.addResource(type,beginInt,endInt);
	}

}
