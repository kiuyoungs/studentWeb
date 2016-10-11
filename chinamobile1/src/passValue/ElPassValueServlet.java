package passValue;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinamobile.entity.Operator;

public class ElPassValueServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取一个Operator。。
		Operator o = new Operator();
		o.setOperatorName("tom");
		o.setOperatorPwd("abc");
		
		request.setAttribute("opr", o);
		
		//跳转到jsp
		request.getRequestDispatcher("/jstlTest/el1.jsp").forward(request, response);

	}

}
