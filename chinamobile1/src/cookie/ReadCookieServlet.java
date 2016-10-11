package cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReadCookieServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie[] cs= request.getCookies();
		
		System.out.println(cs);
		
		if(cs!=null){
			for (Cookie c : cs) {
				System.out.println(c.getName()+"   " + c.getValue());
			}
		}
		
//		for(int i=0 ; cs!=null && i<cs.length; i++){
//			
//		}

	}

}
