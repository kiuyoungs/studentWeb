package edu.tjpu.task.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.tjpu.task.entities.User;
import edu.tjpu.task.services.UserService;
import edu.tjpu.task.to.TOUser;

public class UserAction extends ActionSupport {
	UserService us = new UserService();
	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}
	User u;
	
	int id;
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	String msg = "";
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	List<TOUser> list ;
	public List<TOUser> getList() {
		return list;
	}

	public void setList(List<TOUser> list) {
		this.list = list;
	}
	ArrayList<User> mlist;
	public ArrayList<User> getMlist() {
		return mlist;
	}

	public void setMlist(ArrayList<User> mlist) {
		this.mlist = mlist;
	}

	//�г�����
	public String listAll() {
		 list = us.listAll();	 
		return SUCCESS;
	}
	public String tolist() {
		return "tolist";
	}
  //�г����й���Ա
	public String listAllMaster(){
		mlist=us.listAllMaster();
		return SUCCESS;
	}
	//��¼���
	public String login() throws SQLException{
		//�ж��Ƿ��п�
		if (u.getAccount().equals("") || u.getPswd().equals("")) {
			return ERROR;
		} else if 
	       //�ж����޴���
	
			(us.login(u).getId()!=0) {
			u=us.login(u);
			int n = -1;
			if (u == null) {
				msg = "toLogin";
			} else {
        	ActionContext.getContext().getSession().put("user", u);
			 n=us.login(u).getRole_id();
			switch (n) {

			case 1:
				msg = "toAdmin";//����Ա
				break;

			case 2:
				msg = "toMaster";//����
				break;
			case 3:
				msg = "toEmp";//Ա��
				break;
			default:
				msg = "toLogin";
			}
			}
		}return msg;
	}
		
	// ���
	public String Add() {
		boolean flag = us.addUser(u);
		return (flag ? "tolist": ERROR);
	}
	public String toadd() {
		return "toAdd";
	}
	// �޸�
	public String Update() {
		boolean flag = us.updateUser(u);
		return (flag ? "tolist" : ERROR);
	}
	public String toupdate() {
		return "toupdate";
	}
	// ɾ��
	public String Delete() {
		boolean flag = us.deleteUser(id);
		return (flag ? "tolist" : ERROR);
	}
  //����
	public String findByName() {
		try {
			u = us.findByName(u);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
	//����
	public String findById() {
		try {
			u = us.findById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "toupdate";
	}
	//����˻�
	public String checkAccount() throws SQLException{
		int n=us.findByAccount(u.getAccount());
		if(n>0) msg="���˺��Ѵ��ڣ������";
		return "check";
	}
	//�˳�
	public String logout(){
		ActionContext.getContext().getSession().put("current_user", null);
		return "toLogin";
	}
}
