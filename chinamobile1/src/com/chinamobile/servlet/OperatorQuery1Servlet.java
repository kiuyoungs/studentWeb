package com.chinamobile.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinamobile.dao.OperatorDao;
import com.chinamobile.entity.Operator;

//使用PreparedStatement进行组合查询
public class OperatorQuery1Servlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String name = request.getParameter("Operator_Name");
		String id = request.getParameter("Operator_ID");
		
		//常见的写法 ,1=1的作用是可以保证sql语句语法的正确。
		String sql =" SELECT * from t_operator where 1=1 ";
		
		//给sql的绑定参数
		ArrayList params = new ArrayList();
		
		if(name!=null && !name.equals("")){
			sql = sql + " and operator_name = ? ";
			params.add(name);
		}
		
		if(id!=null && !id.equals("")){
			sql = sql + "and operator_id  = ?";
			params.add(id);
		}
		
		OperatorDao oprDao = new OperatorDao();
		ArrayList<Operator> oprList = oprDao.getAllOperators(sql, params);
		
		//2.把数据oprList保存到某个域中 request ， 传递到jsp 中，
		request.setAttribute("oprList", oprList);
		
		//3.  跳转到operator_list.jsp
		request.getRequestDispatcher("/operator/operator_list.jsp").forward(request, response);
		
		
	}

}
