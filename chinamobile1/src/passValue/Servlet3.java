package passValue;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Servlet3 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String code ="adef";
		
		//在servlet3里保存了一个变量值，希望在servlet4里能获取到的这个值,前提是这两个servlet没有转发或重定向之类的关系
		//解决方案：通过session来传值
		HttpSession session = request.getSession();
		System.out.println("servlet3---sessionId:" +session.getId());
		
		//值就以code这个名字保存到session中了
		session.setAttribute("code", code);
		System.out.println("servlet3---code:" + code);
	}

}
