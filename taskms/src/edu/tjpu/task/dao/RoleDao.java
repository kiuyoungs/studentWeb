package edu.tjpu.task.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import edu.tjpu.task.db.Dbtool;
import edu.tjpu.task.entities.Role;
import edu.tjpu.task.entities.User;

public class RoleDao {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	List<Role> list;
	// 查询用户
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Role> listAll() throws Exception {
		List<Role> list = null;
		// 创建连接
		conn = Dbtool.getConnection();
		// 创建SQL执行工具
		QueryRunner qRunner = new QueryRunner();
		// 执行SQL查询，并获取结果
		list = (List<Role>) qRunner.query(conn,
				"select * from role",
				new BeanListHandler(Role.class));
		// 输出查询结果
		// 关闭数据库连接

		if (conn != null)
			DbUtils.closeQuietly(conn);
		return list;
	}
}
