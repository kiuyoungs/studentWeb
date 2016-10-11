package com.chinamobile.entity;

public class Charge {
	private String chargeCode;
	private String chargeName;
	private float charge;
	
	private String checked="";//控制页面上的多选框是否被选中
	
	public void setChecked(String checked) {
		this.checked = checked;
	}
	public String getChecked() {
		return checked;
	}
	
	
	public String getChargeCode() {
		return chargeCode;
	}
	public void setChargeCode(String chargeCode) {
		this.chargeCode = chargeCode;
	}
	public String getChargeName() {
		return chargeName;
	}
	public void setChargeName(String chargeName) {
		this.chargeName = chargeName;
	}
	public float getCharge() {
		return charge;
	}
	public void setCharge(float charge) {
		this.charge = charge;
	}
	
	@Override
	public String toString() {
		return "code:"+this.getChargeCode()+" checked:" + this.getChecked();
	}
	
}
