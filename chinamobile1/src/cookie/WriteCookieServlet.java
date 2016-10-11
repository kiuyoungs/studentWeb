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
		//дһ��Cookie
		Cookie  c = new Cookie("test_username","zhangsan");
		//���ù���ʱ��
		c.setMaxAge(60*60*24);
		
		//���û������setPath����ô����·����������ڵ�ǰ·������ǰ·�����Ƿ���WriteCookieServlet��url
		
		//д���ͻ���
		response.addCookie(c);
		
		
	/*	//дһ��Cookie
		Cookie  c = new Cookie("test_password","123");
		//���ù���ʱ��
		c.setMaxAge(60*60*24);
		
		//����setPath
		String ctx = this.getServletContext().getContextPath();//   /chinamobile
		System.out.println("ctx:" +ctx);
		c.setPath(ctx +"/aaaaa/cccc");
		
		
		//д���ͻ���
		response.addCookie(c);*/
	}

}
