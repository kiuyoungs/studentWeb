package cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteCookieServlet extends HttpServlet {

	//ɾ��Cookie���ȶ������е�cookie��Ȼ�����name�ҵ�Ҫɾ�����Ǹ�cookie,�����ù���ʱ��Ϊ0�������д���cookie
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Cookie[] cs = request.getCookies();
		//ɾ��nameΪtest_username
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
