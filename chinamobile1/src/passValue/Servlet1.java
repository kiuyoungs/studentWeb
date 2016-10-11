package passValue;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = request.getParameter("userId");
		System.out.println("servlet1111:" + userId);
		
		//��δ�һ��Servlet��ת����һ��Servlet.����ֱ��ƥ��web.xml�е�url-patternָ����·��
		//��ת�����ַ�ʽ��1.�ض���
//		response.sendRedirect("Servlet2");
		
		//��ת�ĵ�2�ַ�ʽ������ת��
		/*RequestDispatcher rd = request.getRequestDispatcher("Servlet2");
		rd.forward(request, response);*/
		
		
		//��Servlet1�ж�����һ������,��δ��ݸ�Servlet2�أ�
		String userName = "Tom";
		request.setAttribute("name1", userName);
		
		//����ת��
//		request.getRequestDispatcher("Servlet2").forward(request, response);
		
		//������request����1����ҳ���ύ������http://localhost:8080/chinamobile/Servlet1?userId=tttttt
		//��2�����ض��������http://localhost:8080/chinamobile/Servlet2?age=10
		//age=10��ͨ����2��request���ģ�������Servlet2���ܻ�ȡ��userId�ǵ�һ��request�еģ�
		//������Servlet2�У���2��request���޷���ȡ
		response.sendRedirect("Servlet2?age=10");
		
		
	}

}
