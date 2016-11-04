package com.student;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.entity.Student;
import com.studentDao.studentDao;

public class StudentAddServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("stu_id");
		String stuName = request.getParameter("username");
		String stuPwd = request.getParameter("password");
		String classNum = request.getParameter("class_number");
		String sex = request.getParameter("sex");
		String birthday = request.getParameter("birthday");
		String stuContact = request.getParameter("contact_way");

		
		//2.�ѽ��ܵ�ҳ���ύ��4��ֵ���浽operator������
		Student stu = new Student();
		stu.setStudentId(id);
		stu.setStudentName(stuName);
		stu.setStudentPwd(stuPwd);
		stu.setStudentSex(sex);
		stu.setStudentBirthday(birthday);
		stu.setStudentClass(classNum);
		stu.setStudentContact(stuContact);
		
		
		//3.����OperationDao�е�addoperator��operator opr������
		studentDao stuDao = new studentDao();
		int r = stuDao.addStudent(stu);
		
		if(r>0){
//			System.out.println("�����ɹ�........");
			response.sendRedirect("/student/login.jsp");
		}else{
			System.out.println("����ʧ��........");
		}
		
		
	}

}
