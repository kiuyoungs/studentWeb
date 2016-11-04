package com.student;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.student.entity.Attendance;
import com.studentDao.studentDao;

public class StudentUpdatestuServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//1.���ܲ���
		String stuId = request.getParameter("loadID");
		String  courseId= request.getParameter("classID");
		String attenId = request.getParameter("attenID");
		String attenDate = request.getParameter("date");
		String attenRec = request.getParameter("attention");

		//2.�ѽ��ܵ�ҳ���ύ��4��ֵ���浽operator������
		Attendance stu = new Attendance();
		stu.setStudentId(stuId);
		stu.setCourseId(courseId);
		stu.setAttenId(attenId);
		stu.setAttenDate(attenDate);
		stu.setAttenRecord(attenRec);

		//3.����OperationDao�е�addoperator��operator opr������
		studentDao stuDao = new studentDao();
		int r = stuDao.updateStudent(stu);

		if(r>0){
//			System.out.println("�����ɹ�........");
			response.sendRedirect("/student/StudentListServlet");
		}else{
			System.out.println("����ʧ��........");
		}
		
	}

}
