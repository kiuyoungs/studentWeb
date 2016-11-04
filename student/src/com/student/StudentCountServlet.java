package com.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.entity.Attendance;
import com.studentDao.studentDao;

public class StudentCountServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		studentDao stuDao = new studentDao();
		Attendance stu =new Attendance();
		stu = stuDao.countStudnet(stu);
		//�����ݱ��浽ĳ������
		request.setAttribute("stu", stu);
		//��oprlist���ݵ�jsp�У���ת��operator_list��
//		System.out.println(cxt);
		request.getRequestDispatcher("/count.jsp").forward(request, response);
		
		
	}

}
