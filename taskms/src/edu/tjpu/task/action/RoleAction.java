package edu.tjpu.task.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import edu.tjpu.task.entities.Role;
import edu.tjpu.task.services.RoleService;

public class RoleAction extends ActionSupport {
	RoleService rs = new RoleService();
	private Role r;

	

	public List<Role> getRlist() {
		return rlist;
	}

	public void setRlist(List<Role> rlist) {
		this.rlist = rlist;
	}

	List<Role> rlist;
	public Role getR() {
		return r;
	}

	public void setR(Role r) {
		this.r = r;
	}

	String msg = "";


	public String delete() {
		return msg;
	}

	public String add() {
		
		rs.add(r);
		return msg;
	}

	public String modify() {
		return msg;
	}

	public String listAll() throws Exception {
		rlist=rs.listAll();
		return SUCCESS;
	}

	public String findByAccount(String acc) {
		return msg;
	}

	public String findById(int rid) {
		return msg;
	}

}
