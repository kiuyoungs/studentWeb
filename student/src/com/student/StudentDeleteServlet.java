package com.student;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studentDao.studentDao;

public class StudentDeleteServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String stuId = request.getParameter("stuId");
		
		//调用Dao类的delete方法，ctrl+shift+o
		studentDao stuDao = new studentDao();
		int r = stuDao.deleteStudent(stuId);
		if(r>0){
			response.sendRedirect("StudentListServlet");
		}else{
			System.out.println("删除失败......");
		}
	}

}
