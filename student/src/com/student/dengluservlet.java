package com.student;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.studentDao.studentDao;



public class dengluservlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Refresh","3;URL=http://localhost:8080/student/login.html" );
		PrintWriter out = response.getWriter();
		String username=request.getParameter("username");//获取用户名
		String password=request.getParameter("password");//获取密码
		
		HttpSession session=request.getSession();
		String realcode=(String)session.getAttribute("realcode");

			studentDao stuDao = new studentDao();
			//如果loginCheck返回True，表示表中有这条数据
			boolean loginSuc = stuDao.loginCheck1(username,password);
			
		if(loginSuc == true)
			{
			String rem=request.getParameter("rem");
			if(rem!=null)
			{
				Cookie c=new Cookie("loginUserName",username);
				c.setMaxAge(60*60*24);
				response.addCookie(c);
			}else
			{
				Cookie[] cs=request.getCookies();
				if(cs!=null){
				for	(Cookie c:cs){
					//System.out.println(c.getName()+" "+c.getValue());
					if(c.getName().equals("loginusername")){
							c.setMaxAge(0);
							response.addCookie(c);
							break;
					}
					}
				}
			}
			response.sendRedirect("student.html");
			}
			
		else{
//			String user=java.net.URLEncoder.encode(username,"UTF-8");
			response.sendRedirect("login.jsp?error=1&username=");
//			out.println("您的用户名或密码错误，请<a href='login.html'>重新登录</a>，系统将在3秒后自动跳转回登录页面");
			}
			}
	
	}


