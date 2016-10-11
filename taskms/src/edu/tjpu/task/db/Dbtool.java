package edu.tjpu.task.db;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;



import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Dbtool {
   	private static ComboPooledDataSource  dataSource = null;
	
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
	static {
		dataSource = new ComboPooledDataSource();// 与定义的named-config的name属性值相同
		 Properties p = new Properties();
		   try {
			p.load(Dbtool.class.getResourceAsStream("/c3p0"));
			   dataSource = new ComboPooledDataSource();
			   dataSource.setUser(p.getProperty("user"));
			   dataSource.setPassword(p.getProperty("password"));
			   dataSource.setJdbcUrl(p.getProperty("jdbcUrl"));
			   dataSource.setDriverClass(p.getProperty("driverClass"));
			   dataSource.setInitialPoolSize(Integer.parseInt(p.getProperty("initialPoolSize")));
			   dataSource.setMinPoolSize(Integer.parseInt(p.getProperty("minPoolSize")));
			   dataSource.setMaxPoolSize(Integer.parseInt(p.getProperty("maxPoolSize")));
			   //dataSource.setMaxStatements(Integer.parseInt(p.getProperty("maxStatements")));
			   dataSource.setMaxIdleTime(Integer.parseInt(p.getProperty("maxIdleTime")));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
