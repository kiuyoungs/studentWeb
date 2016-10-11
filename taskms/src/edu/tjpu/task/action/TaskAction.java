package edu.tjpu.task.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.tjpu.task.dao.PlanDao;
import edu.tjpu.task.entities.Plan;
import edu.tjpu.task.entities.Task;
import edu.tjpu.task.entities.User;
import edu.tjpu.task.services.TaskService;
import edu.tjpu.task.to.TOtask;

public class TaskAction extends ActionSupport {
	TaskService ts = new TaskService();
	Task t = new Task();
	int id;
	int pid;
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}
	List<TOtask> list ;
	List<Task> tlist;
	List<Plan> plist;
	public List<Plan> getPlist() {
		return plist;
	}

	public void setPlist(List<Plan> plist) {
		this.plist = plist;
	}

	public List<Task> getTlist() {
		return tlist;
	}

	public void setTlist(List<Task> tlist) {
		this.tlist = tlist;
	}

	public List<TOtask> getList() {
		return list;
	}

	public void setList(List<TOtask> list) {
		this.list = list;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Task getT() {
		return t;
	}

	public void setT(Task t) {
		this.t = t;
	}

	
	//下拉列表中的发布者的下属就是执行者，列出所有的执行者
	
	// 列出所有
	public String listAll() throws Exception {
		int id = ((User) ActionContext.getContext().getSession().get("user")).getId();
		list = ts.findAll(id);
		return "toMaster";
	}
 public String tolist(){
	 return "tolist";	 
 }
	// 添加
	public String Add() throws Exception {
		boolean flag = ts.addTask(t);
		return (flag ? "tolist" : ERROR);
	}
	public String toadd() {
		return "toadd";
	}
	// 修改
	public String Update() {
		boolean flag = ts.updateTask(t);
		return (flag ? "tolist" : ERROR);
	}
	public String toupdate() {
		return "toupdate";
	}
	// 删除
	public String Delete() {
		boolean flag = ts.deleteTask(id);
		return (flag ? "tolist": ERROR);
	}

	// 查找
	public String findById() {
		try {
			t = ts.findTaskById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "toupdate";
	}
	public String follow(){
		return "follow";
	}
	public String listTask(){
		int id = ((User) ActionContext.getContext().getSession().get("user")).getId();
		tlist = ts.findTask(id);
		return "toMaster";
	}
	public String findplan(){
		return "findplan";
	}
	public String listPlan() throws Exception{
		
		plist = ts.findPlan(id);
		return "toplan";
	}
	
}
