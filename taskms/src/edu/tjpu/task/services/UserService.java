package edu.tjpu.task.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.tjpu.task.dao.UserDao;
import edu.tjpu.task.entities.User;
import edu.tjpu.task.to.TOUser;

public class UserService {
	UserDao ud = new UserDao();

	// �г�����
	public List<TOUser> listAll() {
		List<TOUser> list = new ArrayList<TOUser>();
		try {
			list = ud.listAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	// �г����й���Ա
		public ArrayList<User> listAllMaster() {
			ArrayList<User> mlist = new ArrayList<User>();
			try {
				mlist = (ArrayList<User>) ud.listAllMaster();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return  mlist;
		}

	// ���
	public boolean addUser(User u) {
		int n = 0;
		try {
			n = ud.insertUser(u);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (n > 0 ? true : false);
	}

	

	// ��¼
	public User login(User u) throws SQLException {
		User u1 = ud.logincheck(u);
		return u1;
	}

	// �޸�
	public boolean updateUser(User u) {
		int n = 0;
		try {
			n = ud.updateUser(u);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (n > 0 ? true : false);
	}

	// ɾ��
	public boolean deleteUser(int i) {
		int n = 0;
		try {
			n = ud.deleteUser(i);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (n > 0 ? true : false);
	}
	// ��ѯ
		public User findByName(User u) throws Exception {

			User u1 = null;
			u1 = ud.findByName(u.getName());
			return u1;
		}
	public User findById(int id) throws Exception {

		User u2 = null;
		u2 = ud.findById(id);
		return u2;
	}
	public int findByAccount(String account) throws SQLException {
		int n=ud.findByAccount(account);
		return n;
	}
}
