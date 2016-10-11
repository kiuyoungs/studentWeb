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
		
		//���ձ��ύ�� �������ֵ
		String chargeCode = request.getParameter("gmtyp");
	
		ChargeDao cDao = new ChargeDao();
		
		//����ChargeDao getCharges(),��ѯ�����еķ��ü�¼
		ArrayList<Charge> chgList =  cDao.getAllCharges();
		
		//chargeCode==null��ʾ�����˵��ύ�����
		if(chargeCode!=null){
			Charge chg = cDao.getChargeByCode(chargeCode);
			request.setAttribute("cha", chg);//cha��ʾ��ǰѡ�е�Charge����
		}else{
			//��ʾ�����˵������
			request.setAttribute("cha", chgList.get(0));
		}
		
		//��Ҫ��t_charge_rule���ж�ȡ����ҵ�����õ��շѹ���
		ChargeRuleDao crDao = new ChargeRuleDao();
		ArrayList<String> chargeCodeList = crDao.getChargeRuleById("O");//chargeCodeList�б�����Ǳ�ѡ�е���Ŀ
		
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
		
		//��ת��jspҳ��
		request.getRequestDispatcher("/charge/charge.jsp").forward(request, response);
	}

}
