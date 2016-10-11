package edu.tjpu.task.to;

public class TOtask {
	private int id;
	private int issuer;
	private int executor;
	private String title;
	private String content;
	private int status;
	private String starttime;
	private String endtime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIssuer() {
		return issuer;
	}
	public void setIssuer(int issuer) {
		this.issuer = issuer;
	}
	public int getExecutor() {
		return executor;
	}
	public void setExecutor(int executor) {
		this.executor = executor;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
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
	
}
