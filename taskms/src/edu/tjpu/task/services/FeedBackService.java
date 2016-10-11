package edu.tjpu.task.services;

import java.util.ArrayList;

import edu.tjpu.task.dao.FeedBackDao;
import edu.tjpu.task.entities.FeedBack;

public class FeedBackService {
    private FeedBackDao fbd=new FeedBackDao();
    public boolean addFeedBack(FeedBack fb){
    	int n= fbd.addFeedBack(fb);
    	return(n>0?true:false);
    }
	public int add(FeedBack fb) {
		int n = fbd.addFeedBack(fb);
		return n;
	}
	public ArrayList<FeedBack> listAll(int pid) {
		ArrayList<FeedBack> list = fbd.listAll(pid);
		return list;
	}
	public boolean delete(int fbid) {
		int n = 0;
		try {
			n = fbd.delete(fbid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (n > 0 ? true : false);
	}
}
