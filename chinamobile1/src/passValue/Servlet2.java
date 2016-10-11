package passValue;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("--------servlet2------------");
		PrintWriter out = response.getWriter();
		
		//userId是第1个request里的参数，重定向后就丢失了，输出为null
		String userId = request.getParameter("userId");
		System.out.println("servlet2的userId:"  + userId);
		
		//getParameter方法接收的是表单提交的数据，url?userId=aaaa
//		String name = request.getParameter("name");
//		System.out.println("servlet2-name:" + name);
		
		//从request中取值:没有转发关系也无法取到值，输出null
		String userName= (String) request.getAttribute("name1");
		System.out.println("servlet2---userName："+userName);
		
		
		//获取sendRedirect("Servlet2?age=10")方法中传递的值,可以取到值，输出10
		String age = request.getParameter("age");
		System.out.println("age:"+age);
		
		out.println("you access servlet2.....");
	}
}
