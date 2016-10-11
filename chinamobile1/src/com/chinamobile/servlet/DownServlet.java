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
		//设置响应头
		response.setHeader("Content-Disposition","filename=test.xls");
		PrintWriter out = response.getWriter();
		//任何请求DownServlet的web资源 都在Referer里标记出来
		
		//第一步：获取Referer的值
		String referer = request.getHeader("Referer");
		//http://localhost:8080/aaa/down.html
		System.out.println(referer);
		//第一个测试：自己网站访问：http://localhost:8080/chinamobile/downSelf.html
		//第二个测试：别的网站访问：http://localhost:8080/aaa/down.html
		
		//第二步：把referer和自己网站名称进行比较。http://localhost:8080/chinamobile
		//String提供的startsWith函数，判断referer是否以自身网站开头，如果返回true，表示可以访问，否则非法访问
		String selfPro = "http://"+ request.getServerName()+":"+ request.getServerPort()+request.getContextPath();
		
		System.out.println("自己网站："+selfPro);
		
		if(referer.startsWith(selfPro)==true){
			//表示站内访问
			out.println("100");
			
		}else{
			//表示站外盗链
			out.println("非法访问....<a href='index.html'>请先访问本网站</a>");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	}

}
