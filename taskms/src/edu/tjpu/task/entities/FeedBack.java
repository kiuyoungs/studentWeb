package edu.tjpu.task.entities;

public class FeedBack {
	private int id;
	private String title;
	private int issuer;
    public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getIssuer() {
		return issuer;
	}
	public void setIssuer(int issuer) {
		this.issuer = issuer;
	}
	private int planid;
    private String content;
    private int userid;
      public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPlanid() {
		return planid;
	}
	public void setPlanid(int planid) {
		this.planid = planid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
