package com.chinamobile.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinamobile.dao.ChargeDao;
import com.chinamobile.entity.Charge;

public class ChargeChangeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//���ձ��ύ�� �������ֵ
		String chargeCode = request.getParameter("gmtyp");
		System.out.println("chargeCode:" + chargeCode);
		ChargeDao rDao = new ChargeDao();
		Charge chg = rDao.getChargeByCode(chargeCode);
		request.setAttribute("chg", chg);
		request.getRequestDispatcher("/charge/charge.jsp").forward(request, response);

	}

}
