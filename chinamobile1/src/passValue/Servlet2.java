package passValue;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("--------servlet2------------");
		PrintWriter out = response.getWriter();
		
		//userId�ǵ�1��request��Ĳ������ض����Ͷ�ʧ�ˣ����Ϊnull
		String userId = request.getParameter("userId");
		System.out.println("servlet2��userId:"  + userId);
		
		//getParameter�������յ��Ǳ��ύ�����ݣ�url?userId=aaaa
//		String name = request.getParameter("name");
//		System.out.println("servlet2-name:" + name);
		
		//��request��ȡֵ:û��ת����ϵҲ�޷�ȡ��ֵ�����null
		String userName= (String) request.getAttribute("name1");
		System.out.println("servlet2---userName��"+userName);
		
		
		//��ȡsendRedirect("Servlet2?age=10")�����д��ݵ�ֵ,����ȡ��ֵ�����10
		String age = request.getParameter("age");
		System.out.println("age:"+age);
		
		out.println("you access servlet2.....");
	}
}
