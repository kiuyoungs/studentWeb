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
		
		//��servlet3�ﱣ����һ������ֵ��ϣ����servlet4���ܻ�ȡ�������ֵ,ǰ����������servletû��ת�����ض���֮��Ĺ�ϵ
		//���������ͨ��session����ֵ
		HttpSession session = request.getSession();
		System.out.println("servlet3---sessionId:" +session.getId());
		
		//ֵ����code������ֱ��浽session����
		session.setAttribute("code", code);
		System.out.println("servlet3---code:" + code);
	}

}
