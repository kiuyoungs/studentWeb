package com.chinamobile.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.chinamobile.dao.OperatorDao;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		
		//设置响应头，作用是3秒后自动跳转到url指定的页面
//		response.setHeader("Refresh", "3;URL=http://localhost:8080/chinamobile/login.html");
		
		PrintWriter out = response.getWriter();
		
		//用户名
		String uName= request.getParameter("userName");//显示在登录页面的输入框
//		System.out.println(uName);
		//密码
		String pwd = request.getParameter("password");
		
		//1.接收用户输入的验证码
		String userCode = request.getParameter("userCode");
		//2.从session里获取正确的验证码
		HttpSession session = request.getSession();
		String realCode =(String)session.getAttribute("realCode");
		//3.比较这两个是否值相同
		if(!realCode.equals(userCode)){
			//跳转到登录页面，并提示验证码不对
			response.sendRedirect("/chinamobile/login.jsp?error=0");
		}else{
			
			//OperatorDao loginCheck(uName,pwd);
			
			OperatorDao oprDao = new OperatorDao();
			
			//如果loginCheck方法返回true，表示表中有这条记录
			boolean loginSuc = oprDao.loginCheck1(uName, pwd);
			
			if(loginSuc == true){
				//登录成功
				//判断用户是否勾中了“记住用户名”.多选框如果没有勾中，则取到的值是null
				String rem = request.getParameter("rem");
				if(rem!=null){
					//记住。。。把用户名写到cookie里
					Cookie c = new Cookie("loginUserName",uName);
					c.setMaxAge(60*60*24*7);
					response.addCookie(c);
				}else{
					//删除名字为loginUserName的cookie
					Cookie[] cs = request.getCookies();
					if(cs!=null){
						for (Cookie c : cs) {
							if(c.getName().equals("loginUserName")){
								c.setMaxAge(0);
								response.addCookie(c);
								break;
							}
						}
					}
				}
				response.sendRedirect("index.html");
				
			}else{
				//登录失败 跳转到login.html
//				System.out.println("false....");
			
				//在url的?后传多个值，多个值之间使用"&"
				
				String urf8Name = URLEncoder.encode(uName,"utf-8");
				//推荐使用绝对路径：所谓绝对路径都是从服务器（或者web项目)开始
				//sendRedirect方法里面如果是以"/"开头，那么这个"/"代表服务器名  localhost:8080   
				//response.sendRedirect("/chinamobile/login.jsp?error=1&userName="+urf8Name);
				
				//请求转发方法里面的路径 如果是以"/"开头，那么这个"/"代表web项目名 localhost:8080/chinamobile
				request.getRequestDispatcher("/login.jsp?error=1&userName="+urf8Name).forward(request, response);
				
//				out.println("您的用户名或密码错误，请<a href='login.html'>重新登录</a>，或系统会在3秒后自动跳转到登录页面");
			}
		}
	}

}
