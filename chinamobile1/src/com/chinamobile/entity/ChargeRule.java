package com.chinamobile.entity;

import java.util.ArrayList;

public class ChargeRule {
	private String funId;
	
	//��Ϊһ��ҵ���Ӧ�ж���շ���
	private ArrayList<String> ChargeCode;
	
	public String getFunId() {
		return funId;
	}
	public void setFunId(String funId) {
		this.funId = funId;
	}
	public void setChargeCode(ArrayList<String> chargeCode) {
		ChargeCode = chargeCode;
	}
	public ArrayList<String> getChargeCode() {
		return ChargeCode;
	}

}
