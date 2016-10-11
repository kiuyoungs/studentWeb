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
	// ��ѯ�û�
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Role> listAll() throws Exception {
		List<Role> list = null;
		// ��������
		conn = Dbtool.getConnection();
		// ����SQLִ�й���
		QueryRunner qRunner = new QueryRunner();
		// ִ��SQL��ѯ������ȡ���
		list = (List<Role>) qRunner.query(conn,
				"select * from role",
				new BeanListHandler(Role.class));
		// �����ѯ���
		// �ر����ݿ�����

		if (conn != null)
			DbUtils.closeQuietly(conn);
		return list;
	}
}
