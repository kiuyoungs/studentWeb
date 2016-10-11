package cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteCookieServlet extends HttpServlet {

	//删除Cookie，先读出所有的cookie，然后根据name找到要删除的那个cookie,再设置过期时间为0，最后重写这个cookie
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Cookie[] cs = request.getCookies();
		//删除name为test_username
		for (Cookie c : cs) {
			//System.out.println(c.getName() + "   " + c.getValue());
			if(c.getName().equals("test_username")){
				c.setMaxAge(0);
				response.addCookie(c);
				break;
			}
		}
		
	}

}
