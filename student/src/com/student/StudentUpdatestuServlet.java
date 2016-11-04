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

		//1.接受参数
		String stuId = request.getParameter("loadID");
		String  courseId= request.getParameter("classID");
		String attenId = request.getParameter("attenID");
		String attenDate = request.getParameter("date");
		String attenRec = request.getParameter("attention");

		//2.把接受的页面提交的4个值保存到operator对象中
		Attendance stu = new Attendance();
		stu.setStudentId(stuId);
		stu.setCourseId(courseId);
		stu.setAttenId(attenId);
		stu.setAttenDate(attenDate);
		stu.setAttenRecord(attenRec);

		//3.调用OperationDao中的addoperator（operator opr）方法
		studentDao stuDao = new studentDao();
		int r = stuDao.updateStudent(stu);

		if(r>0){
//			System.out.println("新增成功........");
			response.sendRedirect("/student/StudentListServlet");
		}else{
			System.out.println("新增失败........");
		}
		
	}

}
