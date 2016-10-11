package com.chinamobile.entity;

import java.util.ArrayList;

public class ChargeRule {
	private String funId;
	
	//因为一个业务对应有多个收费项
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
