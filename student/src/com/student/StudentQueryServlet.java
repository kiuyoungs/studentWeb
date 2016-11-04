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
		
		
		//查询所有记录数
		
		String sql =" SELECT * from attendance where 1=1 ";
		
		if(id!=null && !id.equals("")){
			sql = sql + " and stu_id ='" + id +"'";
		}
		
		
		//1.调用Dao类中的方法获取所有操作员
		studentDao stuDao = new studentDao();
		
		ArrayList stuList = stuDao.getStudents(sql);
		
		//2.把数据oprList保存到某个域中 request ， 传递到jsp 中，
		request.setAttribute("stuList", stuList);
		
		//3.  跳转到operator_list.jsp
		request.getRequestDispatcher("/search.jsp").forward(request, response);
		
	}

}
