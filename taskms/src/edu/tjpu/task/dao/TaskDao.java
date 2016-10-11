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

import com.opensymphony.xwork2.ActionContext;

import edu.tjpu.task.db.Dbtool;
import edu.tjpu.task.entities.Plan;
import edu.tjpu.task.entities.Task;
import edu.tjpu.task.entities.User;
import edu.tjpu.task.to.TOtask;


public class TaskDao extends BaseDao{
	//Connection conn;
	//PreparedStatement pstmt;
	//ResultSet rs;
   //列出全部任务
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<TOtask> findAll(int id)  throws Exception{
		List<TOtask> list = new ArrayList<TOtask>();
		conn=Dbtool.getConnection();
		String sql="select * from tasks where issuer=?";
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, id);
		rs=pstmt.executeQuery();
		
		while(rs.next()){
			TOtask t=new TOtask();
			t.setId(rs.getInt(1));
			t.setTitle(rs.getString(2));
			t.setContent(rs.getString(3));
			t.setStarttime(rs.getString(4));
			t.setEndtime(rs.getString(5));
			t.setStatus(rs.getInt(6));
			t.setExecutor(rs.getInt(7));
			t.setIssuer(rs.getInt(8));
			list.add(t);
		}
		return list;
	}
   //添加任务
	public boolean addTask(Task t) throws SQLException {
		int x=0;
		conn = Dbtool.getConnection();
		
		String sql = "insert into tasks (title,content,starttime,endtime,status,executor,issuer) VALUES(?,?,?,?,?,?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, t.getTitle());
		pstmt.setString(2, t.getContent());
		pstmt.setString(3, t.getStarttime());
		pstmt.setString(4, t.getEndtime());
		pstmt.setInt(5, t.getStatus());
		pstmt.setInt(6, t.getExecutor());
		pstmt.setInt(7, t.getIssuer());
		
		 x=pstmt.executeUpdate();
		return (x>0?true:false);
	}
	//删除
	public int deleteTask(int id) {
		int r = 0;
		Connection conn = null;
		PreparedStatement pstmt;
		try {
			conn = Dbtool.getConnection();
			String sql = "delete  from task where id=?";
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
	//修改
	public int updateTask(Task t) {
		int r = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = Dbtool.getConnection();
			String sql = "update tasks set title=?,content=?,starttime=?,endtime=?,status=?,executor=?,issuer=? where id=?";

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, t.getTitle());
			pstmt.setString(2, t.getContent());
			pstmt.setString(3, t.getStarttime());
			pstmt.setString(4, t.getEndtime());
			pstmt.setInt(5, t.getStatus());
			pstmt.setInt(6, t.getExecutor());
			pstmt.setInt(7, t.getIssuer());
			pstmt.setInt(8, t.getId());
			r = pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DbUtils.closeQuietly(conn);
		}
		return r;
	}
	//查找
	public Task findTaskById(int id) throws Exception {
		conn=Dbtool.getConnection();
		String sql="select * from tasks where id=?";
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, id);
		rs=pstmt.executeQuery();
		Task t=new Task();
		if(rs.next()){
			t.setId(rs.getInt(1));
			t.setTitle(rs.getString(2));
			t.setContent(rs.getString(3));
			t.setStarttime(rs.getString(4));
			t.setEndtime(rs.getString(5));
			t.setStatus(rs.getInt(6));
			t.setExecutor(rs.getInt(7));
			t.setIssuer(rs.getInt(8));
		}
		return t;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ArrayList<Task> listAll(String field, int eid) {
		ArrayList<Task> tlist = null;
		if (conn == null)
			setConnect();
		sql = "select * from tasks where "+field+"="+eid;
		if (qrunner == null)
			qrunner = new QueryRunner();
		try {
			tlist = (ArrayList<Task>) qrunner.query(conn, sql, new BeanListHandler(Task.class));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return tlist;
     
	}
	public int setStatus(int tid, int status) {
		sql = "update tasks set status=? where id=?";
		int n = 0;
		try {
			if (conn == null)
				setConnect();
			if (pstmt == null)
				pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, status);
			pstmt.setInt(2, tid);
			n = pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			this.close();
		}
		return n;
	
	}
	public List<Task> findTask(int id) throws Exception{
		List<Task> tlist = new ArrayList<Task>();
		conn=Dbtool.getConnection();
		String sql="select * from tasks where status=1 and issuer=?";
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, id);
		rs=pstmt.executeQuery();
		
		while(rs.next()){
			Task t=new Task();
			t.setId(rs.getInt(1));
			t.setTitle(rs.getString(2));
			t.setContent(rs.getString(3));
			t.setStarttime(rs.getString(4));
			t.setEndtime(rs.getString(5));
			t.setStatus(rs.getInt(6));
			t.setExecutor(rs.getInt(7));
			t.setIssuer(rs.getInt(8));
			tlist.add(t);
		}
		return tlist;
	}
	public List<Plan> findPlan(int id)  throws Exception{
		List<Plan> plist = new ArrayList<Plan>();
		conn=Dbtool.getConnection();
		String sql="select * from plans where taskid=?";
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, id);
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
			p.setTaskid(rs.getInt(8));
			plist.add(p);
		}
		return plist;
	}
	
	

}
