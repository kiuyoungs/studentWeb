package com.chinamobile.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.chinamobile.entity.Operator;

import util.JdbcUtil;

//����Ա(Operatorʵ����---��Ӧ���ݿ��е�һ�ű����������ݿ�����������������  Data Accessor
//Data Accessor�ṩ�Ķ��ǵ����Ĳ�����ҵ���߼����ǰѶ������������ϣ����һ�������ҵ��
//---��1.��ѯ�ʺ��Ƿ����  2.��ѯ��� 3.��A�ʺſ۳�10000 4. ��B�ʺż�10000
public class OperatorDao {
	
	//
	//sql = "select * from t_operator where operator_name = ? and operator_pwd = ?";
	//�ڶ�������params��PreparedStatement�İ󶨲���
	public ArrayList<Operator> getAllOperators(String sql,ArrayList params) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Operator> oprList=new ArrayList<Operator>();
		try {
			// ֱ�ӵ���JdbcUtil��д�õķ���
			conn = JdbcUtil.getConn();
			// 3.����ִ��sql����Statement����
			pstmt = conn.prepareStatement(sql);
			
			//�󶨲���
			for(int i=0 ; i < params.size(); i++){
				pstmt.setObject(i+1, params.get(i));
			}

			// 4.ִ��sql���,����ǲ�ѯ�Ļ�������һ�������
			rs = pstmt.executeQuery();

			// ѭ��������������������
			while (rs.next()) {
				//rs.next()ָ��ı��е�һ�м�¼����һ�м�¼��Ӧ����һ��Operator����
				//�ѽ�����е�ǰ�е�ÿ�����ݱ��浽Operator����Ķ�Ӧ��������
				Operator o = new Operator();
				o.setOperatorId(rs.getString(1));
				o.setOperatorName(rs.getString(2));
				o.setOperatorPwd(rs.getString(3));
				o.setIsAdmin(rs.getString(4));
				
				//��Operator������뵽���϶�����
				oprList.add(o);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			// 6.�ͷ���Դ
			JdbcUtil.free(rs, null, conn);
		}
		return oprList;
	}
	
	
	//�޸ĵ�¼��֤�ķ�����ʹ��PreparedStatement����
	public boolean loginCheck1(String name, String pwd) {
		boolean r = false;
		Connection conn = null;
		PreparedStatement pstmt;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConn();
			
			//ʹ��PreparedStatement����Ҫƴ��sql��䣬����������Ҫ���εĵط�ʹ��?ռλ��
			String sql = "select * from t_operator where operator_name = ? and operator_pwd = ?";
			pstmt = conn.prepareStatement(sql);
			
			//������,ע������������Ǵ�1��ʼ
			pstmt.setString(1, name);
			pstmt.setString(2, pwd);
			
			System.out.println(sql);
			
			//��Ҫʹ��executeQuery(sql)
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				r = true;
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.free(rs, null, conn);
		}
		return r;
	}

	// ��¼��֤����ѯ
	public boolean loginCheck(String name, String pwd) {
		boolean r = false;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConn();
			stmt = conn.createStatement();
			// �������������ֵ���͵ģ���ô��Ҫ����''
			String sql = "SELECT * from t_operator WHERE operator_name = '"
					+ name + "' and operator_pwd ='" + pwd + "'";
			System.out.println(sql);
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				r = true;
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.free(rs, stmt, conn);
		}
		return r;
	}
	

	
	public static void main(String[] args) {
		OperatorDao  od = new OperatorDao();
	/*	ArrayList<Operator>  oprList = od.getAllOperators();
		for(int i=0; i<oprList.size(); i++){
			Operator o = oprList.get(i);
			System.out.println(o.getOperatorId() + "|" +o.getOperatorName());
		}*/
		
		//��������ɾ��
		String[] ids = {"4","5","sd"};
		od.deleteMany(ids);
	}

	//�������� ��������,���ݴ����sql����ѯ����Ӧ�Ľ��
	public ArrayList<Operator> getAllOperators(String sql) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Operator> oprList=new ArrayList<Operator>();
		try {
			// ֱ�ӵ���JdbcUtil��д�õķ���
			conn = JdbcUtil.getConn();
			// 3.����ִ��sql����Statement����
			stmt = conn.createStatement();

			// 4.ִ��sql���,����ǲ�ѯ�Ļ�������һ�������
			rs = stmt.executeQuery(sql);

			// ѭ��������������������
			while (rs.next()) {
				//rs.next()ָ��ı��е�һ�м�¼����һ�м�¼��Ӧ����һ��Operator����
				//�ѽ�����е�ǰ�е�ÿ�����ݱ��浽Operator����Ķ�Ӧ��������
				Operator o = new Operator();
				o.setOperatorId(rs.getString(1));
				o.setOperatorName(rs.getString(2));
				o.setOperatorPwd(rs.getString(3));
				o.setIsAdmin(rs.getString(4));
				
				//��Operator������뵽���϶�����
				oprList.add(o);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			// 6.�ͷ���Դ
			JdbcUtil.free(rs, stmt, conn);
		}
		return oprList;
	}
	
	

	public ArrayList<Operator> getAllOperators() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Operator> oprList=new ArrayList<Operator>();
		try {
			// ֱ�ӵ���JdbcUtil��д�õķ���
			conn = JdbcUtil.getConn();
			// 3.����ִ��sql����Statement����
			stmt = conn.createStatement();

			// ����һ��Ҫִ�е�sql���
			String sql = "SELECT * from t_operator ";

			// 4.ִ��sql���,����ǲ�ѯ�Ļ�������һ�������
			rs = stmt.executeQuery(sql);

			// ѭ��������������������
			while (rs.next()) {
				//rs.next()ָ��ı��е�һ�м�¼����һ�м�¼��Ӧ����һ��Operator����
				//�ѽ�����е�ǰ�е�ÿ�����ݱ��浽Operator����Ķ�Ӧ��������
				Operator o = new Operator();
				o.setOperatorId(rs.getString(1));
				o.setOperatorName(rs.getString(2));
				o.setOperatorPwd(rs.getString(3));
				o.setIsAdmin(rs.getString(4));
				
				//��Operator������뵽���϶�����
				oprList.add(o);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			// 6.�ͷ���Դ
			JdbcUtil.free(rs, stmt, conn);
		}
		return oprList;
	}
	
	public int addOperator(Operator opr) {
		int r = 0;
		Connection conn = null;
		Statement stmt = null;

		try {
			/*
			 * Class.forName("com.mysql.jdbc.Driver"); conn =
			 * DriverManager.getConnection("jdbc:mysql://localhost:3306/cma",
			 * "root", "root");
			 */

			conn = JdbcUtil.getConn();
			stmt = conn.createStatement();
			String sql = "insert into t_operator VALUES('" + opr.getOperatorId() + "','" 
			     + opr.getOperatorName()	+ "','" + opr.getOperatorPwd() + "','" + opr.getIsAdmin() + "')";
			System.out.println(sql);

			// ��һ���Ͳ�ѯ������executeQuery | �������޸ġ�ɾ�� executeUpdate
			r = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.free(null, stmt, conn);
		}
		return r;
	}

	//ɾ���������Ա��������ʾҪɾ���Ĳ���Ա��id�����������
	public int deleteMany(String[] ids){
		int r =0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = JdbcUtil.getConn();
			String sql = "delete from t_operator where operator_id = ?";
			pstmt = conn.prepareStatement(sql);
			
			//ʹ����������
			for(int i=0; i<ids.length; i++){
				pstmt.setString(1, ids[i]);
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

	public int deleteOperator(String oprId) {
		Connection conn = null;
		PreparedStatement pstmt;
		int r = 0;
		try {
			conn = JdbcUtil.getConn();
			
			//ʹ��PreparedStatement����Ҫƴ��sql��䣬����������Ҫ���εĵط�ʹ��?ռλ��
			String sql = "delete from t_operator where operator_id =?";
			pstmt = conn.prepareStatement(sql);
			
			//������,ע������������Ǵ�1��ʼ
			pstmt.setString(1, oprId);
			r = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.free(null, null, conn);
		}
		return r;
	}


	public Operator getOperatorById(String oprId) {
		Connection conn = null;
		PreparedStatement pstmt;
		ResultSet rs = null;
		Operator o = new Operator();
		try {
			conn = JdbcUtil.getConn();
			
			//ʹ��PreparedStatement����Ҫƴ��sql��䣬����������Ҫ���εĵط�ʹ��?ռλ��
			String sql = "select * from t_operator where operator_id = ? ";
			pstmt = conn.prepareStatement(sql);
			
			//������,ע������������Ǵ�1��ʼ
			pstmt.setString(1, oprId);
			
			
			//��Ҫʹ��executeQuery(sql)
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				o.setOperatorId(rs.getString(1));
				o.setOperatorName(rs.getString(2));
				o.setOperatorPwd(rs.getString(3));
				o.setIsAdmin(rs.getString(4));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.free(rs, null, conn);
		}
		return o;
	}


	public int updateOperator(Operator opr) {
		int r = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = JdbcUtil.getConn();
			String sql ="update t_operator set operator_name=? , operator_pwd=? ,is_admin=? where operator_id = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, opr.getOperatorName());
			pstmt.setString(2, opr.getOperatorPwd());
			pstmt.setString(3, opr.getIsAdmin());
			pstmt.setString(4, opr.getOperatorId());

			r = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.free(null, null, conn);
		}
		return r;
	}


	//��ѯ������
	public int getTotalRows(String sqlCount) {
		Connection conn = null;
		PreparedStatement pstmt;
		ResultSet rs = null;
		int r = 0;
		try {
			conn = JdbcUtil.getConn();
			
			pstmt = conn.prepareStatement(sqlCount);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				r = rs.getInt(1);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.free(rs, null, conn);
		}
		return r;
	}

}
