package com.student;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.student.entity.Attendance;
import com.studentDao.studentDao;

public class StudentUpdateServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String stuId = request.getParameter("stuId");
		
		//����dao�еķ���������id��ѯ��operator����
		Attendance stu = null;
		studentDao stuDao = new studentDao();
		stu = stuDao.getStudentById(stuId);
		
		//��opr���浽request����
		request.setAttribute("stu", stu);
		request.getRequestDispatcher("/infor_update.jsp").forward(request, response);
		
	}

}
