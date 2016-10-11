package edu.tjpu.task.entities;

import java.util.List;

public class Task {
	private int id;
	private String title;
	private String content;
	private String starttime;
	private String endtime;
	private int status;// 状态
	private int executor;// 执行者
	public int getExecutor() {
		return executor;
	}

	public void setExecutor(int executor) {
		this.executor = executor;
	}

	private int issuer;// 发布者
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	

	public int getIssuer() {
		return issuer;
	}

	public void setIssuer(int issuer) {
		this.issuer = issuer;
	}

}
