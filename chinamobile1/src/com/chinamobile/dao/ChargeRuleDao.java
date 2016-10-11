package com.chinamobile.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.JdbcUtil;

import com.chinamobile.entity.Charge;
import com.chinamobile.entity.ChargeRule;

public class ChargeRuleDao {
	//id = O  ������chargeCode�Ϳ�����
	public ArrayList<String> getChargeRuleById(String funid){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<String> chargeCodeList= new ArrayList<String>();
		try {
			conn = JdbcUtil.getConn();
			String sql = "select * from t_charge_rule where fun_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,funid);
			rs = pstmt.executeQuery();

			// ѭ��������������������
			while (rs.next()) {
				chargeCodeList.add(rs.getString("charge_code"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			// 6.�ͷ���Դ
			JdbcUtil.free(rs, null, conn);
		}
		return chargeCodeList;
	}
}
