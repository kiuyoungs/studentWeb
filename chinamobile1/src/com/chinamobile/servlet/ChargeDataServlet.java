package com.chinamobile.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinamobile.dao.ChargeDao;
import com.chinamobile.dao.ChargeRuleDao;
import com.chinamobile.entity.Charge;

public class ChargeDataServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//接收表单提交的 下拉框的值
		String chargeCode = request.getParameter("gmtyp");
	
		ChargeDao cDao = new ChargeDao();
		
		//调用ChargeDao getCharges(),查询出所有的费用记录
		ArrayList<Charge> chgList =  cDao.getAllCharges();
		
		//chargeCode==null表示从左侧菜单提交进入的
		if(chargeCode!=null){
			Charge chg = cDao.getChargeByCode(chargeCode);
			request.setAttribute("cha", chg);//cha表示当前选中的Charge对象
		}else{
			//表示从左侧菜单进入的
			request.setAttribute("cha", chgList.get(0));
		}
		
		//需要到t_charge_rule表中读取开户业务配置的收费规则
		ChargeRuleDao crDao = new ChargeRuleDao();
		ArrayList<String> chargeCodeList = crDao.getChargeRuleById("O");//chargeCodeList中保存的是被选中的项目
		
		for(int i=0; i<chgList.size();i++){
			Charge c = chgList.get(i);
			for(int j=0;j<chargeCodeList.size();j++){
				if(c.getChargeCode().equals(chargeCodeList.get(j))){
					c.setChecked("checked");
				}
			}
		}
		System.out.println(chgList);
		
		request.setAttribute("chgList", chgList);
		
		//跳转到jsp页面
		request.getRequestDispatcher("/charge/charge.jsp").forward(request, response);
	}

}
