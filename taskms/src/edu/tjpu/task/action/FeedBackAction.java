package edu.tjpu.task.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import edu.tjpu.task.entities.FeedBack;
import edu.tjpu.task.services.FeedBackService;

@SuppressWarnings("serial")
public class FeedBackAction extends ActionSupport {
      FeedBackService fs=new FeedBackService();
      private int pid;
      private int fbid;
      public int getFbid() {
		return fbid;
	}

	public void setFbid(int fbid) {
		this.fbid = fbid;
	}
	private FeedBack fb;
      ArrayList<FeedBack> fblist;
      public FeedBack getFb() {
		return fb;
	}

	public void setFb(FeedBack fb) {
		this.fb = fb;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public ArrayList<FeedBack> getFblist() {
		return fblist;
	}

	public void setFblist(ArrayList<FeedBack> fblist) {
		this.fblist = fblist;
	}

	
    
	public String toadd(){
		return "toadd";
	}
	public String add(){
		int n = fs.add(fb);
		return "toemp";
	}
	public String listAll(){
		fblist = fs.listAll(pid);
		return "toemp";
	}
	public String del(){
		boolean flag = fs.delete(fbid);
		return (flag ? "tolist" : ERROR);
	}
	public String tolist(){
		return "tolist";
	}
}
