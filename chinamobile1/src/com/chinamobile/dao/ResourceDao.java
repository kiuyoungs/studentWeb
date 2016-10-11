package com.chinamobile.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import util.JdbcUtil;

public class ResourceDao {

	
	public int addResource(String type, long beginInt, long endInt) {
		int r =0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = JdbcUtil.getConn();
			String sql = "insert into t_mobiles (mobile_number,mobile_type) values(?,?)";
			pstmt = conn.prepareStatement(sql);
			
			//ʹ����������
			for(long i=beginInt; i<=endInt; i++){
				pstmt.setString(1, i+"");
				pstmt.setString(2, type);
				pstmt.addBatch();
			}
			
			//ִ��������������ѭ����  3��ɾ��sql��䡣   int[] {1,1,0}
			int[] r1 =pstmt.executeBatch();
			
			r=r1[0];
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.free(null, null, conn);
		}
		return r;
	}

	public int addResource(String type, ArrayList<String> phoneList) {
		int r =0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = JdbcUtil.getConn();
			String sql = "insert into t_mobiles (mobile_number,mobile_type) values(?,?)";
			pstmt = conn.prepareStatement(sql);
			
			//ʹ����������
			for(int i=0; i<phoneList.size(); i++){
				pstmt.setString(1, phoneList.get(i));
				pstmt.setString(2, type);
				pstmt.addBatch();
			}
			
			//ִ��������������ѭ����  3��ɾ��sql��䡣   int[] {1,1,0}
			int[] r1 =pstmt.executeBatch();
			
			r=r1[0];
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.free(null, null, conn);
		}
		return r;
	}

}
