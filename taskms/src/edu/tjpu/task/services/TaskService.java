package edu.tjpu.task.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.tjpu.task.dao.TaskDao;
import edu.tjpu.task.dao.UserDao;
import edu.tjpu.task.entities.Plan;
import edu.tjpu.task.entities.Task;
import edu.tjpu.task.to.TOtask;


public class TaskService {
          TaskDao td=new TaskDao();
          
          public boolean addTask( Task t) throws Exception{
        	return  td.addTask(t);
        	
          }
          
          public List<TOtask> findAll(int id) throws Exception{
        	  List<TOtask> list= new ArrayList<TOtask>();
        	  list = td.findAll(id);
        	
			return list;
          }
     
          //–ﬁ∏ƒ
		public boolean updateTask(Task t) {
			int n=0;
			n = td.updateTask(t);
			return (n > 0 ? true : false);
		}
       //…æ≥˝
		public boolean deleteTask(int id) {
			int n=0;
			n = td.deleteTask(id);
			return (n > 0 ? true : false);
		}

      //≤È’“
		public Task findTaskById(int id) throws Exception {
			Task t=null;
			t=td.findTaskById(id);
			return t;
		}

		public List<Task> findTask(int id) {
			List<Task> tlist= new ArrayList<Task>();
      	  try {
			tlist = td.findTask(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      	
			return tlist;
		}

		public List<Plan> findPlan(int id) throws Exception{
			List<Plan> plist= new ArrayList<Plan>();
			plist = td.findPlan(id);
			return plist;
		}

		
}
