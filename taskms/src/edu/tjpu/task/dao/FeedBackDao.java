package edu.tjpu.task.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.opensymphony.xwork2.ActionContext;

import edu.tjpu.task.db.Dbtool;
import edu.tjpu.task.entities.FeedBack;
import edu.tjpu.task.entities.User;

public class FeedBackDao extends BaseDao{
	
	
	//Ìí¼Ó·´À¡
 public int addFeedBack(FeedBack fb){
	 int n=0;
	 try {
		conn=Dbtool.getConnection();
		 sql="insert into feedbacks(content,userid,planid)values(?,?,?)";
		 pstmt=conn.prepareStatement(sql);
		 pstmt.setString(1, fb.getContent());
		 pstmt.setInt(2, fb.getUserid());
		 pstmt.setInt(3, fb.getPlanid());
		 
		 n=pstmt.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		if(conn!=null){
			DbUtils.closeQuietly(conn);
			}
	}
	 return n;
 }
public ArrayList<FeedBack> listAll(int pid) {
		ArrayList<FeedBack> list = null;
		if (conn == null)
			setConnect();

		if (qrunner == null)
			qrunner = new QueryRunner();
		try {
			if (pid != 0) {
				sql = "select *  from feedbacks  where planid=? ";
				list = (ArrayList<FeedBack>) qrunner.query(conn, sql, new BeanListHandler(FeedBack.class), pid);
			} else {
				int iid = ((User) ActionContext.getContext().getSession().get("user")).getId();
				sql = "select *  from feedbacks  where issuer=?";
				list = (ArrayList<FeedBack>) qrunner.query(conn, sql, new BeanListHandler(FeedBack.class), iid);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
public int delete(int fbid) {
	int r = 0;
	try {
		conn = Dbtool.getConnection();
		String sql = "delete  from feedbacks where id=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, fbid);
		r = pstmt.executeUpdate();

	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		DbUtils.closeQuietly(conn);
	}
	return r;
}
}
