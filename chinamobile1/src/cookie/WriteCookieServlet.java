package cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WriteCookieServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//写一个Cookie
		Cookie  c = new Cookie("test_username","zhangsan");
		//设置过期时间
		c.setMaxAge(60*60*24);
		
		//如果没有设置setPath，那么保存路径就是相对于当前路径。当前路径就是访问WriteCookieServlet的url
		
		//写到客户端
		response.addCookie(c);
		
		
	/*	//写一个Cookie
		Cookie  c = new Cookie("test_password","123");
		//设置过期时间
		c.setMaxAge(60*60*24);
		
		//设置setPath
		String ctx = this.getServletContext().getContextPath();//   /chinamobile
		System.out.println("ctx:" +ctx);
		c.setPath(ctx +"/aaaaa/cccc");
		
		
		//写到客户端
		response.addCookie(c);*/
	}

}
