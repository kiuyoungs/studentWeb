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
		//��servlet3�ﱣ����һ������ֵ��ϣ����servlet4���ܻ�ȡ�������ֵ
		
		//�ܹ���ȡ��realCode��ֵ
		
		HttpSession session = request.getSession();
		System.out.println("servlet4---sessionId:" +session.getId());
		String code = (String)session.getAttribute("code");
		System.out.println("servlet4---code:" + code);
	}

}
