package com.chinamobile.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinamobile.dao.OperatorDao;
import com.chinamobile.entity.Operator;
import com.chinamobile.entity.Page;


//���Ϸ�ҳ����
public class OperatorQueryServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�����������������������ѯ����.�û��п����ύ�ˣ�Ҳ�п���û�ύ
		String name = request.getParameter("Operator_Name");
		String id = request.getParameter("Operator_ID");
		
		//��ȡ��ѯ��ʶ ,����Ǵ����˵��ύ�����󣬻����ǵ����������ѯ����ť�ύ������oprFlag =1
		//������ǵ����ҳ��ť����oprFlag = null
		String oprFlag = request.getParameter("oprFlag");
		
		int currPage = 1;//����ǰ��ҳ��
		if(request.getParameter("currPage")!= null){
		  currPage = Integer.parseInt(request.getParameter("currPage"));
		}
		
		Page page = new Page();
		
		//��Ҫ�ѵ�ǰҳcurrPage���浽request���У���jspҳ���е���һҳ����һҳ�ĳ�����ʹ��
		//request.setAttribute("currPage", currPage);
		
		int beginIndex = (currPage-1) * page.getPageSize();
		
		HttpSession session = request.getSession();
		String condition  = "";//���������ѯ����
		
		//ֻ�е����ҳ��ťʱ����Ҫȡ��ѯ����
		if(session.getAttribute("condition")!=null && oprFlag == null){
			condition = session.getAttribute("condition").toString();
		}
		
		//��ѯ���м�¼��
		String sqlCount =" SELECT count(*) from t_operator where 1=1  ";
		
		String sql =" SELECT * from t_operator where 1=1 ";
		
		if(name!=null && !name.equals("")){
			condition =  " and operator_name like '%" +name +"%'";
		}
		
		if(id!=null && !id.equals("")){
			condition = condition + " and operator_id ='" + id +"'";
		}
		
		sql = sql + condition;
		sqlCount = sqlCount + condition;
		
		session.setAttribute("condition",condition);//�Ѳ�ѯ�������浽session��
		
		//����Limit �Ӿ�
		sql = sql + " limit "+beginIndex+", 5 ";
		
		
		//1.����Dao���еķ�����ȡ���в���Ա
		OperatorDao oprDao = new OperatorDao();
		
		int totalRows = oprDao.getTotalRows(sqlCount);
		
		page.setTotalPages(totalRows);
		page.setCurrPage(currPage);
		request.setAttribute("p", page);
		
		ArrayList<Operator> oprList = oprDao.getAllOperators(sql);
		
		//2.������oprList���浽ĳ������ request �� ���ݵ�jsp �У�
		request.setAttribute("oprList", oprList);
		
		//3.  ��ת��operator_list.jsp
		request.getRequestDispatcher("/operator/operator_list.jsp").forward(request, response);
	}

}
