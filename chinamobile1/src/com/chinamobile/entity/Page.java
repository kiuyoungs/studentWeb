package com.chinamobile.entity;

public class Page {
	private int pageSize =5; //ÿҳ��ʾ��������5����
	private int currPage =1 ;//��ǰҳ
	private int totalPages; //��ҳ��
	
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
	
	//������ҳ��,����Ĳ����������������������� ������/ÿҳ���� �ó���ҳ��
	public void setTotalPages(int totalRows) {
		if(totalRows%pageSize==0){
			this.totalPages = totalRows/5;
		}else{
			this.totalPages = totalRows/5 + 1;
		}
	}
}
