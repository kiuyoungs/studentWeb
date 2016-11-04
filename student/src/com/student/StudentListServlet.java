package com.student;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studentDao.studentDao;



public class StudentListServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//获取所有操作员
		studentDao stuDao = new studentDao();
		ArrayList stuList = stuDao.getAllStudents();
		//把数据保存到某个域中
		request.setAttribute("stuList", stuList);
		
		//吧oprlist传递到jsp中，跳转到operator_list中
//		System.out.println(cxt);
		request.getRequestDispatcher("/information.jsp").forward(request, response);
		
	}

}
