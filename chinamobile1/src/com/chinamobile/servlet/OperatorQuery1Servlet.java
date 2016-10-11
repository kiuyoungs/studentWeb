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

//ʹ��PreparedStatement������ϲ�ѯ
public class OperatorQuery1Servlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String name = request.getParameter("Operator_Name");
		String id = request.getParameter("Operator_ID");
		
		//������д�� ,1=1�������ǿ��Ա�֤sql����﷨����ȷ��
		String sql =" SELECT * from t_operator where 1=1 ";
		
		//��sql�İ󶨲���
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
		
		//2.������oprList���浽ĳ������ request �� ���ݵ�jsp �У�
		request.setAttribute("oprList", oprList);
		
		//3.  ��ת��operator_list.jsp
		request.getRequestDispatcher("/operator/operator_list.jsp").forward(request, response);
		
		
	}

}
