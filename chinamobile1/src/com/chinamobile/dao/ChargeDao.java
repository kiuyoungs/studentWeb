package com.chinamobile.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.JdbcUtil;

import com.chinamobile.entity.Charge;

public class ChargeDao {
	//��ѯ���е�charge
	public ArrayList<Charge> getAllCharges(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Charge> chgList=new ArrayList<Charge>();
		try {
			conn = JdbcUtil.getConn();
			String sql = "select * from t_charge";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			// ѭ��������������������
			while (rs.next()) {
				Charge c = new Charge();
				c.setCharge(rs.getFloat("charge"));
				c.setChargeCode(rs.getString("charge_code"));
				c.setChargeName(rs.getString("charge_name"));
				chgList.add(c);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			// 6.�ͷ���Դ
			JdbcUtil.free(rs, null, conn);
		}
		return chgList;
	}

	public Charge getChargeByCode(String chargeCode) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Charge c = new Charge();
		try {
			conn = JdbcUtil.getConn();
			String sql = "select * from t_charge where charge_code = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, chargeCode);
			rs = pstmt.executeQuery();

			// ѭ��������������������
			if (rs.next()) {
				
				c.setCharge(rs.getFloat("charge"));
				c.setChargeCode(rs.getString("charge_code"));
				c.setChargeName(rs.getString("charge_name"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			// 6.�ͷ���Դ
			JdbcUtil.free(rs, null, conn);
		}
		return c;
	}
}
