package com.chinamobile.entity;

//ʵ���࣬��Ҫ�������Ǵ������ݵġ�
//��Ľṹ��˽�����ԣ�˽�����Ժͣ������ϣ����е��ֶ�һ��
//          ��Щ���Ե�get��set����
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


