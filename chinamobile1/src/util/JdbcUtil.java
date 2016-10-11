package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class JdbcUtil {
	private static String url = "jdbc:mysql://localhost:3306/cma1";
	private static String username = "root";
	private static String password = "root";
	
	
	//载入驱动放在静态代码块中，只加载一次
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConn() throws SQLException{
		return DriverManager.getConnection(url,username,password);
	}
	
	
	public static void free(ResultSet rs,Statement stmt,Connection conn){
		try {
			if(rs!= null){
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(stmt!=null){
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				try {
					if(conn!=null){
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
