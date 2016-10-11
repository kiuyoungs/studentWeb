package edu.tjpu.task.services;

import java.util.ArrayList;
import java.util.List;

import edu.tjpu.task.dao.PlanDao;
import edu.tjpu.task.dao.TaskDao;
import edu.tjpu.task.entities.Plan;
import edu.tjpu.task.entities.Task;

public class PlanService {
private PlanDao pd=new PlanDao();

public boolean addPlan(Plan p) throws Exception {
	// TODO Auto-generated method stub
	
	int n=pd.addPlan(p);
	
	return (n>0?true:false);
}

public List<Plan> findAll() throws Exception {
	  List<Plan> list= new ArrayList<Plan>();
	  list = pd.listAll();
	
	return list;
}

public boolean updateTask(Plan p) {
	int n=0;
	n = pd.updateTask(p);
	return (n > 0 ? true : false);
	
}

public ArrayList<Task> mytask(int eid) throws Exception{
	ArrayList<Task> tlist= new ArrayList<Task>();
	TaskDao td = new TaskDao();
	tlist =td.listAll("executor",eid);
	return tlist;
}

public List<Plan> myplan(int iid) throws Exception{
	List<Plan> list= new ArrayList<Plan>();
	list = pd.myplan(iid);
	return list;
}

public Plan findById(int pid) {
	Plan p = null;
	try {
		p = pd.findById(pid);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return p;
}

public boolean deletePlan(int id) {
	int n = 0;
	try {
		n = pd.deletePlan(id);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return (n > 0 ? true : false);
}

}
