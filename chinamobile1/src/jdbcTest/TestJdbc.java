package jdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import util.JdbcUtil;

public class TestJdbc {
	
	public void getAllOperators(){
		try {
			//1.注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			//2.创建连接
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cma", "root", "root");
			System.out.println("conn:" +conn);
			
			//3.创建执行sql语句的Statement对象
			Statement stmt = conn.createStatement();
			
			//定义一个要执行的sql语句
			String sql = "SELECT * from t_operator ";
			
			//4.执行sql语句,如果是查询的话，返回一个结果集
			ResultSet rs = stmt.executeQuery(sql);
			
			//5.如何从结果集里获取数据.开始游标在第一行的前面，next()表示把游标移动到第1行
			/*rs.next();
			String id1 = rs.getString(1);//参数1表示第1列。现在取到的数据是第1行第1列的
			System.out.println(id1);
			String name1 = rs.getString(2);//参数2表示第2列。现在取到的数据是第1行第2列的
			System.out.println(name1);*/
			
			//循环输出结果集中所有数据
			while(rs.next()){
				//rs.next()做了两件事，第一件事：判断有没有下一行，如果有，返回true；如果没有，返回false;
				//第二件事：如果有下一行，把光标移到下一行
				String id1 = rs.getString(1);//参数1表示第1列。现在取到的数据是第1行第1列的
				System.out.println(id1);
				String name1 = rs.getString(2);//参数2表示第2列。现在取到的数据是第1行第2列的
				System.out.println(name1);
				System.out.println("---------------------------------");
			}
			
			
			
		/*	rs.next();
			String id2 = rs.getString(1);//参数1表示第1列。现在取到的数据是第2行第1列的
			System.out.println(id2);
			String name2 = rs.getString(2);//参数2表示第2列。现在取到的数据是第2行第2列的
			System.out.println(name2);*/
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			//如果连接数据库失败，那么执行catch里的语句
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}finally{
			//6.释放资源
		}
	}
	

	//有条件的查询
	public void getOperatorById(String id){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cma", "root", "root");
			Statement stmt = conn.createStatement();
			//参数如果不是数值类型的，那么需要加上''
			String sql = "SELECT * from t_operator where operator_id ='" +id+"'";
			System.out.println(sql );
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				String name1 = rs.getString(2);
				System.out.println(name1);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean loginCheck (String name,String pwd){
		boolean r = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cma", "root", "root");
			Statement stmt = conn.createStatement();
			//参数如果不是数值类型的，那么需要加上''
			String sql = "SELECT * from t_operator WHERE operator_name = '"+name+"' and operator_pwd ='"+pwd+"'";
			System.out.println(sql );
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				r = true;
			}
			
			rs.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//rs.close();
		}
		return r;
	}
	
	public int insertOperator(String id,String name,String pwd,String isAdmin){
		int r = 0;
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
		/*	Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cma", "root", "root");*/
			
			conn = JdbcUtil.getConn();
			stmt = conn.createStatement();
			String sql = "insert into t_operator VALUES('"+id+"','"+name+"','" +pwd+  "','"+isAdmin+"')";
			System.out.println(sql);
			
			//下一步和查询有区别，executeQuery |  新增、修改、删除 executeUpdate
			r = stmt.executeUpdate(sql);
			System.out.println("影响的行数：" + r);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.free(null, stmt, conn);
		}
		return r;
	}
	
	
	//更新数据
	public int updateOperator(String id,String name,String pwd,String isAdmin){
		int r = 0;
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cma", "root", "root");
			
			stmt = conn.createStatement();
			String sql = "UPDATE t_operator set operator_name='"+name+"' ,operator_pwd='"+pwd+"' ,is_admin='"+isAdmin+"'  where operator_id = '"+id+"'";
			System.out.println(sql);
			
			//下一步和查询有区别，executeQuery |  新增、修改、删除 executeUpdate
			r = stmt.executeUpdate(sql);
			System.out.println("影响的行数：" + r);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//不管有没有异常都会执行
			if(stmt!=null){
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(conn !=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return r;
	}
	
	public static void main(String[] args) {
		
		TestJdbc t = new TestJdbc();
		//t.getOperatorById("o002");
//		boolean r =  t.loginCheck("john","234reer" );
//		t.insertOperator("o006", "zhang", "666", "Y");
		//t.updateOperator("o002", "李四", "0000", "Y");
		
		for(int i=10; i<3500;i++){
			t.insertOperator(i+"", "aaa", "11", "N");
		}
		
	}

}
