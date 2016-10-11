package edu.tjpu.task.services;

import java.util.List;

import edu.tjpu.task.dao.RoleDao;
import edu.tjpu.task.entities.Role;

public class RoleService {
	RoleDao rd=new RoleDao();
	public void add(Role r) {
		// TODO Auto-generated method stub
		
	}

	public List<Role> listAll() throws Exception {
		return rd.listAll();
		
	}
}
