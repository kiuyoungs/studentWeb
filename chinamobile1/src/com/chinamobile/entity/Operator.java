package com.chinamobile.entity;

//实体类，主要的作用是传递数据的。
//类的结构：私有属性：私有属性和（基本上）表中的字段一致
//          这些属性的get、set方法
public class Operator {
	private String operatorId ;
	private String operatorName ;
	private String operatorPwd ;
	private String isAdmin ;
	public String getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}
	public String getOperatorName() {
		return operatorName;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	public String getOperatorPwd() {
		return operatorPwd;
	}
	public void setOperatorPwd(String operatorPwd) {
		this.operatorPwd = operatorPwd;
	}
	public String getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}
}


