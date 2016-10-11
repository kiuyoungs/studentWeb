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


//加上分页功能
public class OperatorQueryServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//两个参数，代表的是两个查询条件.用户有可能提交了，也有可能没提交
		String name = request.getParameter("Operator_Name");
		String id = request.getParameter("Operator_ID");
		
		//获取查询标识 ,如果是从左侧菜单提交的请求，或者是点击“立即查询”按钮提交的请求，oprFlag =1
		//而如果是点击分页按钮，则oprFlag = null
		String oprFlag = request.getParameter("oprFlag");
		
		int currPage = 1;//代表当前的页数
		if(request.getParameter("currPage")!= null){
		  currPage = Integer.parseInt(request.getParameter("currPage"));
		}
		
		Page page = new Page();
		
		//需要把当前页currPage保存到request域中，给jsp页面中的上一页、下一页的超链接使用
		//request.setAttribute("currPage", currPage);
		
		int beginIndex = (currPage-1) * page.getPageSize();
		
		HttpSession session = request.getSession();
		String condition  = "";//用来保存查询条件
		
		//只有点击分页按钮时才需要取查询条件
		if(session.getAttribute("condition")!=null && oprFlag == null){
			condition = session.getAttribute("condition").toString();
		}
		
		//查询所有记录数
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
		
		session.setAttribute("condition",condition);//把查询条件保存到session。
		
		//加上Limit 子句
		sql = sql + " limit "+beginIndex+", 5 ";
		
		
		//1.调用Dao类中的方法获取所有操作员
		OperatorDao oprDao = new OperatorDao();
		
		int totalRows = oprDao.getTotalRows(sqlCount);
		
		page.setTotalPages(totalRows);
		page.setCurrPage(currPage);
		request.setAttribute("p", page);
		
		ArrayList<Operator> oprList = oprDao.getAllOperators(sql);
		
		//2.把数据oprList保存到某个域中 request ， 传递到jsp 中，
		request.setAttribute("oprList", oprList);
		
		//3.  跳转到operator_list.jsp
		request.getRequestDispatcher("/operator/operator_list.jsp").forward(request, response);
	}

}
