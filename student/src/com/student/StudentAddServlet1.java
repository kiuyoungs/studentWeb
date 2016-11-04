package com.student;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.entity.Attendance;
import com.student.entity.ggg;
import com.studentDao.studentDao;

public class StudentAddServlet1 extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//1.���ղ���
		String stuId = request.getParameter("loadID");
		String classId = request.getParameter("classID");
		String attenId = request.getParameter("attenID");
		String date = request.getParameter("date");
		String atten = request.getParameter("attention");
		
		//2.�ѽ��յ���ҳ���ύ��4��ֵ���浽һ��Operator������
		Attendance stu =new Attendance();
		stu.setStudentId(stuId);
		stu.setCourseId(classId);
		stu.setAttenId(attenId);
		stu.setAttenDate(date);
		stu.setAttenRecord(atten);
		
		//3.����OperatorDao���е�addOperator(Operator opr)����
		studentDao stuDao = new studentDao();
		int r = stuDao.addStudent1(stu);
		
		//���r >0 ��˵�������ɹ�
		if(r > 0){
//					System.out.println("�����ɹ�.....");
			//�����ɹ�����ֱ����ת������Ա�б�ҳ�棬����Ҫ��ת��OperatorListServlet
			response.sendRedirect("/student/StudentListServlet");
		}else{
			//���r=0������ʧ��
			System.out.println("����ʧ��.....");
		}
		
	}

}
