package passValue;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Servlet4 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//在servlet3里保存了一个变量值，希望在servlet4里能获取到的这个值
		
		//能够获取到realCode的值
		
		HttpSession session = request.getSession();
		System.out.println("servlet4---sessionId:" +session.getId());
		String code = (String)session.getAttribute("code");
		System.out.println("servlet4---code:" + code);
	}

}
