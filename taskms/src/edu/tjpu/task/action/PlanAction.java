package edu.tjpu.task.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.tjpu.task.dao.TaskDao;
import edu.tjpu.task.entities.Plan;
import edu.tjpu.task.entities.Task;
import edu.tjpu.task.entities.User;
import edu.tjpu.task.services.PlanService;

public class PlanAction extends ActionSupport {
	PlanService ps=new PlanService();
	private List<Plan> list;
	private List<Task> tlist;
	private Plan p;
	private int pid;
	private int tid;
	private int id;

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public List<Task> getTlist() {
		return tlist;
	}

	public void setTlist(List<Task> tlist) {
		this.tlist = tlist;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public Plan getP() {
		return p;
	}

	public void setP(Plan p) {
		this.p = p;
	}
	public List<Plan> getList() {
		return list;
	}

	public void setList(List<Plan> list) {
		this.list = list;
	}
	public String Listplan(){
		return "listplan";
	}
	public String toadd(){
		return "toadd";
	}
	public String listAll() throws Exception {
		list = ps.findAll();
		return SUCCESS;
	}
	public String Add() throws Exception {
		boolean flag = ps.addPlan(p);
		return (flag ? "toEmp" : ERROR);
	}
	public String Update() {
		boolean flag = ps.updateTask(p);
		return (flag ? "listplan" : ERROR);
	}
	public String mytask()throws Exception{
		int eid = ((User) ActionContext.getContext().getSession().get("user")).getId();
		//System.out.print(eid);
		tlist = ps.mytask(eid);
		
		return "toEmp";
	}
	public String myplan()throws Exception{
		int iid = ((User) ActionContext.getContext().getSession().get("user")).getId();
		list = ps.myplan(iid);
		return "toEmp";
	}
	public String complet(){
		TaskDao td = new TaskDao();
		int n = td.setStatus(tid,2);
		return "tolist";
	}
	public String detail(){
		p=ps.findById(pid);
		return "tomodi";
	}
	public String Delete() {
		boolean flag = ps.deletePlan(id);
		return (flag ? "toEmp" : ERROR);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
