package passValue;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = request.getParameter("userId");
		System.out.println("servlet1111:" + userId);
		
		//如何从一个Servlet跳转到另一个Servlet.可以直接匹配web.xml中的url-pattern指定的路径
		//跳转有两种方式：1.重定向
//		response.sendRedirect("Servlet2");
		
		//跳转的第2种方式：请求转发
		/*RequestDispatcher rd = request.getRequestDispatcher("Servlet2");
		rd.forward(request, response);*/
		
		
		//在Servlet1中定义了一个变量,如何传递给Servlet2呢？
		String userName = "Tom";
		request.setAttribute("name1", userName);
		
		//请求转发
//		request.getRequestDispatcher("Servlet2").forward(request, response);
		
		//有两个request。第1个是页面提交的请求http://localhost:8080/chinamobile/Servlet1?userId=tttttt
		//第2个是重定向的请求http://localhost:8080/chinamobile/Servlet2?age=10
		//age=10是通过第2个request传的，所以在Servlet2中能获取，userId是第一个request中的，
		//所以在Servlet2中（第2个request中无法获取
		response.sendRedirect("Servlet2?age=10");
		
		
	}

}
