package edu.tjpu.task.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import edu.tjpu.task.db.Dbtool;
import edu.tjpu.task.entities.Plan;
import edu.tjpu.task.entities.Task;
import edu.tjpu.task.to.TOtask;


public class PlanDao {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	//列出计划
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Plan> listAll() throws Exception {
		List<Plan> list = null;
		// 创建连接
		conn = Dbtool.getConnection();
		// 创建SQL执行工具
		QueryRunner qRunner = new QueryRunner();
		// 执行SQL查询，并获取结果
		list = (List<Plan>) qRunner.query(conn,
				"select * from plan",
				new BeanListHandler(Plan.class));
		// 输出查询结果
		// 关闭数据库连接

		if (conn != null)
			DbUtils.closeQuietly(conn);
		return list;
	}
	//添加计划
	public int addPlan(Plan p) throws Exception {
    
		// 创建连接
		conn = Dbtool.getConnection();
		String sql = "insert into plans(id,title,content,starttime,endtime,userid,status,taskid) VALUES(?,?,?,?,?,?,?,?)";
		pstmt = conn.prepareStatement(sql);
		 pstmt.setInt(1, p.getId());	
		 pstmt.setString(2, p.getTitle());
		 pstmt.setString(3, p.getContent());
		 pstmt.setString(4, p.getStarttime());
		 pstmt.setString(5, p.getEndtime());
		 pstmt.setInt(6, p.getUserid());
		 pstmt.setInt(7, p.getStatus());
		 pstmt.setInt(8, p.getTaskid());
		int p1=pstmt.executeUpdate();
			return p1;
		}
	//查找
		public Plan findPlanById(int id) throws Exception {
			conn=Dbtool.getConnection();
			String sql="select * from plan where id=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			Plan p=new Plan();
			if(rs.next()){
				p.setId(rs.getInt(1));
				p.setTitle(rs.getString(2));
				p.setContent(rs.getString(3));
				p.setStarttime(rs.getString(4));
				p.setEndtime(rs.getString(5));
				p.setStatus(rs.getInt(6));
				p.setUserid(rs.getInt(7));
			}
			return p;
		}
		public int updateTask(Plan p) {
			int r = 0;
			Connection conn = null;
			PreparedStatement pstmt = null;

			try {
				conn = Dbtool.getConnection();
				String sql = "update plans set title=?,content=?,starttime=?,endtime=? where id=?";

				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, p.getTitle());
				pstmt.setString(2, p.getContent());
				pstmt.setString(3, p.getStarttime());
				pstmt.setString(4, p.getEndtime());
				//pstmt.setInt(5, p.getStatus());
				pstmt.setInt(5, p.getId());
				r = pstmt.executeUpdate();
			} catch (SQLException e) {

				e.printStackTrace();
			} finally {
				DbUtils.closeQuietly(conn);
			}
			return r;
		}
		
		
		public List<Plan> myplan(int iid) throws Exception{
			List<Plan> list= new ArrayList<Plan>();
			conn=Dbtool.getConnection();
			String sql="select * from plans where userid=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, iid);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				Plan p=new Plan();
				p.setId(rs.getInt(1));
				p.setTitle(rs.getString(2));
				p.setContent(rs.getString(3));
				p.setStarttime(rs.getString(4));
				p.setEndtime(rs.getString(5));
				p.setUserid(rs.getInt(6));
				p.setStatus(rs.getInt(7));
				list.add(p);
			}
			return list;
		}
		public Plan findById(int pid) throws Exception{
			
			conn=Dbtool.getConnection();
			String sql="select * from plans where id=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, pid);
			rs=pstmt.executeQuery();
			Plan p = new Plan();
			if(rs.next()){
				p.setId(rs.getInt(1));
				p.setTitle(rs.getString(2));
				p.setContent(rs.getString(3));
				p.setStarttime(rs.getString(4));
				p.setEndtime(rs.getString(5));
				p.setUserid(rs.getInt(6));
				p.setStatus(rs.getInt(7));
			}
			return p;
		}
		public int deletePlan(int id) {
			int r = 0;
			try {
				conn = Dbtool.getConnection();
				String sql = "delete  from plans where id=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, id);
				r = pstmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DbUtils.closeQuietly(conn);
			}
			return r;
		}
		

}
