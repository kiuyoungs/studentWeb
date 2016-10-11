package com.chinamobile.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.chinamobile.entity.Operator;

import util.JdbcUtil;

//操作员(Operator实体类---对应数据库中的一张表）的所有数据库操作都放在这个类中  Data Accessor
//Data Accessor提供的都是单个的操作。业务逻辑就是把多个单个操作组合，完成一件具体的业务
//---·1.查询帐号是否存在  2.查询余额 3.从A帐号扣除10000 4. 给B帐号加10000
public class OperatorDao {
	
	//
	//sql = "select * from t_operator where operator_name = ? and operator_pwd = ?";
	//第二个参数params是PreparedStatement的绑定参数
	public ArrayList<Operator> getAllOperators(String sql,ArrayList params) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Operator> oprList=new ArrayList<Operator>();
		try {
			// 直接调用JdbcUtil类写好的方法
			conn = JdbcUtil.getConn();
			// 3.创建执行sql语句的Statement对象
			pstmt = conn.prepareStatement(sql);
			
			//绑定参数
			for(int i=0 ; i < params.size(); i++){
				pstmt.setObject(i+1, params.get(i));
			}

			// 4.执行sql语句,如果是查询的话，返回一个结果集
			rs = pstmt.executeQuery();

			// 循环输出结果集中所有数据
			while (rs.next()) {
				//rs.next()指向的表中的一行记录，而一行记录对应的是一个Operator对象
				//把结果集中当前行的每列数据保存到Operator对象的对应的属性中
				Operator o = new Operator();
				o.setOperatorId(rs.getString(1));
				o.setOperatorName(rs.getString(2));
				o.setOperatorPwd(rs.getString(3));
				o.setIsAdmin(rs.getString(4));
				
				//把Operator对象加入到集合对象中
				oprList.add(o);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			// 6.释放资源
			JdbcUtil.free(rs, null, conn);
		}
		return oprList;
	}
	
	
	//修改登录验证的方法：使用PreparedStatement对象
	public boolean loginCheck1(String name, String pwd) {
		boolean r = false;
		Connection conn = null;
		PreparedStatement pstmt;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConn();
			
			//使用PreparedStatement不需要拼接sql语句，做法是在需要传参的地方使用?占位符
			String sql = "select * from t_operator where operator_name = ? and operator_pwd = ?";
			pstmt = conn.prepareStatement(sql);
			
			//参数绑定,注意参数的索引是从1开始
			pstmt.setString(1, name);
			pstmt.setString(2, pwd);
			
			System.out.println(sql);
			
			//不要使用executeQuery(sql)
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

	// 登录验证：查询
	public boolean loginCheck(String name, String pwd) {
		boolean r = false;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConn();
			stmt = conn.createStatement();
			// 参数如果不是数值类型的，那么需要加上''
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
		
		//测试批量删除
		String[] ids = {"4","5","sd"};
		od.deleteMany(ids);
	}

	//返回类型 集合类型,根据传入的sql语句查询出对应的结果
	public ArrayList<Operator> getAllOperators(String sql) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Operator> oprList=new ArrayList<Operator>();
		try {
			// 直接调用JdbcUtil类写好的方法
			conn = JdbcUtil.getConn();
			// 3.创建执行sql语句的Statement对象
			stmt = conn.createStatement();

			// 4.执行sql语句,如果是查询的话，返回一个结果集
			rs = stmt.executeQuery(sql);

			// 循环输出结果集中所有数据
			while (rs.next()) {
				//rs.next()指向的表中的一行记录，而一行记录对应的是一个Operator对象
				//把结果集中当前行的每列数据保存到Operator对象的对应的属性中
				Operator o = new Operator();
				o.setOperatorId(rs.getString(1));
				o.setOperatorName(rs.getString(2));
				o.setOperatorPwd(rs.getString(3));
				o.setIsAdmin(rs.getString(4));
				
				//把Operator对象加入到集合对象中
				oprList.add(o);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			// 6.释放资源
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
			// 直接调用JdbcUtil类写好的方法
			conn = JdbcUtil.getConn();
			// 3.创建执行sql语句的Statement对象
			stmt = conn.createStatement();

			// 定义一个要执行的sql语句
			String sql = "SELECT * from t_operator ";

			// 4.执行sql语句,如果是查询的话，返回一个结果集
			rs = stmt.executeQuery(sql);

			// 循环输出结果集中所有数据
			while (rs.next()) {
				//rs.next()指向的表中的一行记录，而一行记录对应的是一个Operator对象
				//把结果集中当前行的每列数据保存到Operator对象的对应的属性中
				Operator o = new Operator();
				o.setOperatorId(rs.getString(1));
				o.setOperatorName(rs.getString(2));
				o.setOperatorPwd(rs.getString(3));
				o.setIsAdmin(rs.getString(4));
				
				//把Operator对象加入到集合对象中
				oprList.add(o);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			// 6.释放资源
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

			// 下一步和查询有区别，executeQuery | 新增、修改、删除 executeUpdate
			r = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.free(null, stmt, conn);
		}
		return r;
	}

	//删除多个操作员。参数表示要删除的操作员的id，多个，数组
	public int deleteMany(String[] ids){
		int r =0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = JdbcUtil.getConn();
			String sql = "delete from t_operator where operator_id = ?";
			pstmt = conn.prepareStatement(sql);
			
			//使用批量更新
			for(int i=0; i<ids.length; i++){
				pstmt.setString(1, ids[i]);
				pstmt.addBatch();
			}
			
			//执行批量处理是在循环外  3条删除sql语句。   int[] {1,1,0}
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
			
			//使用PreparedStatement不需要拼接sql语句，做法是在需要传参的地方使用?占位符
			String sql = "delete from t_operator where operator_id =?";
			pstmt = conn.prepareStatement(sql);
			
			//参数绑定,注意参数的索引是从1开始
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
			
			//使用PreparedStatement不需要拼接sql语句，做法是在需要传参的地方使用?占位符
			String sql = "select * from t_operator where operator_id = ? ";
			pstmt = conn.prepareStatement(sql);
			
			//参数绑定,注意参数的索引是从1开始
			pstmt.setString(1, oprId);
			
			
			//不要使用executeQuery(sql)
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


	//查询总行数
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
