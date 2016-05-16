package com.company;

import java.util.HashMap;

public class Return {
	private String date;
	private double costCharged;
	private double isCharged;
	private double kms;
	private double gas_Level;

	public Return(String date, double costCharged, double isCharged, double kms, double gas_Level) {
		this.date = date;
		this.costCharged = costCharged;
		this.isCharged = isCharged;
		this.kms = kms;
		this.gas_Level = gas_Level;
	}

	private Employee rtE;
	private Pickup rtP;

	public Employee getRtE() {
		return rtE;
	}
	public void setRtE(Employee rtE) {
		this.rtE = rtE;
	}
	public Pickup getRtP() {
		return rtP;
	}
	public void setRtP(Pickup rtP) {
		this.rtP = rtP;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getCostCharged() {
		return costCharged;
	}
	public void setCostCharged(double costCharged) {
		this.costCharged = costCharged;
	}
	public double getIsCharged() {
		return isCharged;
	}
	public void setIsCharged(double isCharged) {
		this.isCharged = isCharged;
	}
	public double getKms() {
		return kms;
	}
	public void setKms(double kms) {
		this.kms = kms;
	}
	public double getGas_Level() {
		return gas_Level;
	}
	public void setGas_Level(double gas_Level) {
		this.gas_Level = gas_Level;
	}



	private HashMap<String, Damage> colrtD = new HashMap<String, Damage>();
	public Damage getDamage(String identifier_damage){
		return colrtD.get(identifier_damage);
	}
	public void add_Damage(String name_dam,Damage o){
		colrtD.put(name_dam, o);
	}
	public void remove_Damage(String identifier_Damage) {
		colrtD.remove(identifier_Damage);
	}

	
}
