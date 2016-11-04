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

		//��ȡ���в���Ա
		studentDao stuDao = new studentDao();
		ArrayList stuList = stuDao.getAllStudents();
		//�����ݱ��浽ĳ������
		request.setAttribute("stuList", stuList);
		
		//��oprlist���ݵ�jsp�У���ת��operator_list��
//		System.out.println(cxt);
		request.getRequestDispatcher("/information.jsp").forward(request, response);
		
	}

}
