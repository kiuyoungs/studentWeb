package edu.tjpu.task.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBManager {
	private static Connection conn;
	private static ComboPooledDataSource pooledDS;

	
	private static String driver="com.mysql.jdbc.Driver";
	private static String jdbcUrl="jdbc:mysql://localhost/taskms?unicodeEncoding=true&charactorSet=utf8";
	private static String user="root";
	private static String password="";
	
	public static Connection getConnection(){
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(jdbcUrl,user,password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	public static void beginTrasaction(Connection conn){
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void commit(Connection conn){
		try {
			conn.commit();
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void rollback(Connection conn){
		try {
			conn.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void close(Connection conn){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		conn=null;
	}
	static {
		//pooledDS = new ComboPooledDataSource("taskms");
/*			pooledDS.setUser("root");
		pooledDS.setPassword("1111");
		pooledDS.setJdbcUrl(
				"jdbc:mysql://127.0.0.1:3306/taskms?autoReconnect=true&useUnicode=true&characterEncoding=utf8");
		pooledDS.setDriverClass("com.mysql.jdbc.Driver ");
		pooledDS.setInitialPoolSize(2);
		pooledDS.setMinPoolSize(1);
		pooledDS.setMaxPoolSize(10);
		pooledDS.setMaxStatements(50);
		pooledDS.setMaxIdleTime(60);*/
	}

/*	private static String c3p0Properties = "c3p0.properties";

	 private ConnectionManager() throws Exception {
	  Properties p = new Properties();
	  p.load(this.getClass().getResourceAsStream(c3p0.Properties));
	  ds = new ComboPooledDataSource();
	  ds.setUser(p.getProperty("user"));
	  ds.setPassword(p.getProperty("user"));
	  ds.setJdbcUrl(p.getProperty("user"));
	  ds.setDriverClass(p.getProperty("user"));
	  ds.setInitialPoolSize(Integer.parseInt(p.getProperty("initialPoolSize")));
	  ds.setMinPoolSize(Integer.parseInt(p.getProperty("minPoolSize")));
	  ds.setMaxPoolSize(Integer.parseInt(p.getProperty("maxPoolSize")));
	  ds.setMaxStatements(Integer.parseInt(p.getProperty("maxStatements")));
	  ds.setMaxIdleTime(Integer.parseInt(p.getProperty("maxIdleTime")));
	 }*/

	public final static Connection getPooledConnection() {
		try {
			return pooledDS.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException("无法从数据源获取连接 ", e);
		}
	}

}
