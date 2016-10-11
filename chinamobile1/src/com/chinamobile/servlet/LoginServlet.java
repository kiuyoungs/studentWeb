package com.chinamobile.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.chinamobile.dao.OperatorDao;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		
		//������Ӧͷ��������3����Զ���ת��urlָ����ҳ��
//		response.setHeader("Refresh", "3;URL=http://localhost:8080/chinamobile/login.html");
		
		PrintWriter out = response.getWriter();
		
		//�û���
		String uName= request.getParameter("userName");//��ʾ�ڵ�¼ҳ��������
//		System.out.println(uName);
		//����
		String pwd = request.getParameter("password");
		
		//1.�����û��������֤��
		String userCode = request.getParameter("userCode");
		//2.��session���ȡ��ȷ����֤��
		HttpSession session = request.getSession();
		String realCode =(String)session.getAttribute("realCode");
		//3.�Ƚ��������Ƿ�ֵ��ͬ
		if(!realCode.equals(userCode)){
			//��ת����¼ҳ�棬����ʾ��֤�벻��
			response.sendRedirect("/chinamobile/login.jsp?error=0");
		}else{
			
			//OperatorDao loginCheck(uName,pwd);
			
			OperatorDao oprDao = new OperatorDao();
			
			//���loginCheck��������true����ʾ������������¼
			boolean loginSuc = oprDao.loginCheck1(uName, pwd);
			
			if(loginSuc == true){
				//��¼�ɹ�
				//�ж��û��Ƿ����ˡ���ס�û�����.��ѡ�����û�й��У���ȡ����ֵ��null
				String rem = request.getParameter("rem");
				if(rem!=null){
					//��ס���������û���д��cookie��
					Cookie c = new Cookie("loginUserName",uName);
					c.setMaxAge(60*60*24*7);
					response.addCookie(c);
				}else{
					//ɾ������ΪloginUserName��cookie
					Cookie[] cs = request.getCookies();
					if(cs!=null){
						for (Cookie c : cs) {
							if(c.getName().equals("loginUserName")){
								c.setMaxAge(0);
								response.addCookie(c);
								break;
							}
						}
					}
				}
				response.sendRedirect("index.html");
				
			}else{
				//��¼ʧ�� ��ת��login.html
//				System.out.println("false....");
			
				//��url��?�󴫶��ֵ�����ֵ֮��ʹ��"&"
				
				String urf8Name = URLEncoder.encode(uName,"utf-8");
				//�Ƽ�ʹ�þ���·������ν����·�����Ǵӷ�����������web��Ŀ)��ʼ
				//sendRedirect���������������"/"��ͷ����ô���"/"�����������  localhost:8080   
				//response.sendRedirect("/chinamobile/login.jsp?error=1&userName="+urf8Name);
				
				//����ת�����������·�� �������"/"��ͷ����ô���"/"����web��Ŀ�� localhost:8080/chinamobile
				request.getRequestDispatcher("/login.jsp?error=1&userName="+urf8Name).forward(request, response);
				
//				out.println("�����û��������������<a href='login.html'>���µ�¼</a>����ϵͳ����3����Զ���ת����¼ҳ��");
			}
		}
	}

}
