package edu.tjpu.task.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbutils.QueryRunner;



public class BaseDao {
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql;
	QueryRunner qrunner;
	
	public void setConnect(){
		conn=DBManager.getConnection();
	}
	
	public void setStatement(){
		if(conn==null){
			setConnect();
		}
		try {
			stmt=conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setPreparedStatement(String sql){
		if(conn==null){
			setConnect();
		}
		try {
			pstmt=conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void close(){
		DBManager.close(conn);
		rs=null;
		stmt=null;
		pstmt=null;
		
		conn=null;
	}
	
	public void commit(){
		DBManager.commit(conn);
	}
	
	public void rollback(){
		DBManager.rollback(conn);
	}

	public void beginTransaction(){
		DBManager.beginTrasaction(conn);
	}
	


}
