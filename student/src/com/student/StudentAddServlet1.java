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

		//1.接收参数
		String stuId = request.getParameter("loadID");
		String classId = request.getParameter("classID");
		String attenId = request.getParameter("attenID");
		String date = request.getParameter("date");
		String atten = request.getParameter("attention");
		
		//2.把接收到的页面提交的4个值保存到一个Operator对象中
		Attendance stu =new Attendance();
		stu.setStudentId(stuId);
		stu.setCourseId(classId);
		stu.setAttenId(attenId);
		stu.setAttenDate(date);
		stu.setAttenRecord(atten);
		
		//3.调用OperatorDao类中的addOperator(Operator opr)方法
		studentDao stuDao = new studentDao();
		int r = stuDao.addStudent1(stu);
		
		//如果r >0 ，说明新增成功
		if(r > 0){
//					System.out.println("新增成功.....");
			//新增成功后不能直接跳转到操作员列表页面，而是要跳转到OperatorListServlet
			response.sendRedirect("/student/StudentListServlet");
		}else{
			//如果r=0，新增失败
			System.out.println("新增失败.....");
		}
		
	}

}
