package com.chinamobile.entity;

public class Page {
	private int pageSize =5; //每页显示的行数（5条）
	private int currPage =1 ;//当前页
	private int totalPages; //总页数
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	public int getTotalPages() {
		return totalPages;
	}
	
	//计算总页数,传入的参数是总行数，方法体中用 总行数/每页行数 得出总页数
	public void setTotalPages(int totalRows) {
		if(totalRows%pageSize==0){
			this.totalPages = totalRows/5;
		}else{
			this.totalPages = totalRows/5 + 1;
		}
	}
}
