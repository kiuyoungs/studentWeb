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
		
		//获取到多选框提交的id值，有多个
		String[] ids = request.getParameterValues("ids");
		
		OperatorDao od = new OperatorDao();
		int r = od.deleteMany(ids);
		
		if(r==0){
			System.out.println("删除失败...");
		}
		//不管删除成功与否都跳转到列表页面
		response.sendRedirect("OperatorQueryServlet");
	}
}
