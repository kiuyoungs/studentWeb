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
import edu.tjpu.task.entities.User;
import edu.tjpu.task.to.TOUser;

public class UserDao {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	// 查询用户
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<TOUser> listAll() throws Exception {
		List<TOUser> list = null;
		String sql = "select u.id id,u.account account,u.name name,u.birthday birthday,u.entry entry,r.desc role,u1.name leader from users u,role r,users u1 where (u.role_id=r.id and u.leader_id=u1.id) union select u.id id,u.account account,u.name name,u.birthday birthday,u.entry entry, r.desc role,'' leader from users u,role r where u.role_id=r.id and  u.leader_id=0  order by id;";
		// 创建连接
		conn = Dbtool.getConnection();
		// 创建SQL执行工具
		QueryRunner qRunner = new QueryRunner();
		// 执行SQL查询，并获取结果
		list = (List<TOUser>) qRunner.query(conn,
				sql,
				new BeanListHandler(TOUser.class));
		// 输出查询结果
		// 关闭数据库连接

		if (conn != null)
			DbUtils.closeQuietly(conn);
		return list;
	}
	//列出管理员
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ArrayList<User> listAllMaster() throws SQLException{
		ArrayList<User> mlist=null;
		// 创建连接
				conn = Dbtool.getConnection();
				// 创建SQL执行工具
				QueryRunner qRunner = new QueryRunner();
				 String sql = "select id ,name,account  from users  where role_id=2";
				// 执行SQL查询，并获取结果
				mlist = (ArrayList<User>) qRunner.query(conn,
						sql,
						new BeanListHandler(User.class));
				// 输出查询结果
				// 关闭数据库连接

				if (conn != null)
					DbUtils.closeQuietly(conn);
				return mlist;
	}


	// 添加用户
	public int insertUser(User u) throws Exception {

		// 创建连接
		conn = Dbtool.getConnection();	
		String sql = "insert into users (id,name,account,pswd,leader_id,role_id,birthday,entry) VALUES(?,?,?,?,?,?,?,?)";
		pstmt = conn.prepareStatement(sql);
		 pstmt.setInt(1, u.getId());	
		 pstmt.setString(2, u.getName());
		 pstmt.setString(3, u.getAccount());
		 pstmt.setString(4, u.getPswd());
		 pstmt.setInt(5,u.getLeader_id());
		 pstmt.setInt(6, u.getRole_id());
		 pstmt.setString(7, u.getBirthday());
		 pstmt.setString(8, u.getEntry());
		int n = pstmt.executeUpdate();
		return n;
	}

	// 查找
	public int findByAccount(String account) throws SQLException {
		int n=0;
		conn = Dbtool.getConnection();
		String sql = "select count(*) from users where account=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,account);
		rs = pstmt.executeQuery();
		if (rs.next())
			n = rs.getInt(1);
		return n;
	}
	public User findByName(String name) throws Exception {
		conn = Dbtool.getConnection();
		String sql = "select * from users where name=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, name);

		rs = pstmt.executeQuery();
		User u = new User();
		if (rs.next()) {

			u.setId(rs.getInt(1));
			u.setName(rs.getString(2));
			u.setAccount(rs.getString(3));
			u.setPswd(rs.getString(4));
            u.setRole_id(rs.getInt(5));
            u.setBirthday(rs.getString(6));
            u.setEntry(rs.getString(7));
		}
		return u;
	}
	
	public User findById(int id) throws Exception {
		conn = Dbtool.getConnection();
		String sql = "select * from users where id=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, id);

		rs = pstmt.executeQuery();
		User u = new User();
		if (rs.next()) {

			u.setId(rs.getInt(1));
			u.setName(rs.getString(2));
			u.setAccount(rs.getString(3));
			u.setPswd(rs.getString(4));
            u.setRole_id(rs.getInt(5));
            u.setBirthday(rs.getString(6));
            u.setEntry(rs.getString(7));
            u.setLeader_id(rs.getInt(8));
		}
		return u;
	}
  /*
	// 登录
	public boolean logincheck(String name, String pswd) {
		boolean r = false;
		Connection conn = null;
		PreparedStatement pstmt;
		ResultSet rs = null;
		try {
			conn = Dbtool.getConnection();
			String sql = "select * from user where name=? and pswd=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, pswd);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				r = true;
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtils.closeQuietly(conn);
		}
		return r;
	}
	*/
	//登录检查
	public User logincheck(User u) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt;
		ResultSet rs = null;
	   User u1=new User();
			try {
				conn = Dbtool.getConnection();
				String sql = "select * from users where account=? and pswd=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, u.getAccount());
				pstmt.setString(2, u.getPswd());
				rs = pstmt.executeQuery();
				if (rs.next()) {
					u1.setId(rs.getInt(1));
					u1.setName(rs.getString(2));
					u1.setAccount(rs.getString(3));
					u1.setPswd(rs.getString(4));
					   u1.setRole_id(rs.getInt(5));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				return u1;
		
	}
	// 修改 
	public int updateUser(User u) {
		int r = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = Dbtool.getConnection();
			String sql = "update users set name=?,account=?,pswd=?,role_id=?,birthday=?,entry=?,leader_id=?where id=?";

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, u.getName());
			pstmt.setString(2, u.getAccount());
			pstmt.setString(3, u.getPswd());
			pstmt.setInt(4, u.getRole_id());
			pstmt.setString(5 ,u.getBirthday());
			pstmt.setString(6, u.getEntry());
			pstmt.setInt(7, u.getLeader_id());
			pstmt.setInt(8, u.getId());
			r = pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DbUtils.closeQuietly(conn);
		}
		return r ;
	}

	// 删除
	public int deleteUser(int i) {
		int r = 0;
		Connection conn = null;
		PreparedStatement pstmt;
		try {
			conn = Dbtool.getConnection();
			String sql = "delete  from users where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, i);
			r = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtils.closeQuietly(conn);
		}
		return r;
	}

	// 删除批量
	public int deletemanyuser(String[] ids) {
		int r = 0;
		Connection conn = null;
		PreparedStatement pstmt;

		try {
			conn = Dbtool.getConnection();
			String sql = "delete  from t_operator where operator_id=?";
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < ids.length; i++) {
				pstmt.setString(1, ids[i]);
				pstmt.addBatch();
			}
			int r1[] = pstmt.executeBatch();
			r = r1[0];
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtils.closeQuietly(conn);
		}
		return r;
	}


	
}
