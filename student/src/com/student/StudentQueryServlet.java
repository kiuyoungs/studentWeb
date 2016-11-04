package com.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.studentDao.studentDao;

public class StudentQueryServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("Student_ID");
		
		
		//��ѯ���м�¼��
		
		String sql =" SELECT * from attendance where 1=1 ";
		
		if(id!=null && !id.equals("")){
			sql = sql + " and stu_id ='" + id +"'";
		}
		
		
		//1.����Dao���еķ�����ȡ���в���Ա
		studentDao stuDao = new studentDao();
		
		ArrayList stuList = stuDao.getStudents(sql);
		
		//2.������oprList���浽ĳ������ request �� ���ݵ�jsp �У�
		request.setAttribute("stuList", stuList);
		
		//3.  ��ת��operator_list.jsp
		request.getRequestDispatcher("/search.jsp").forward(request, response);
		
	}

}
