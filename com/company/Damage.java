package com.company;


public class Damage {
	
	private String zone;
	private String description;

	public Damage(String zone, String description) {
		this.zone = zone;
		this.description = description;
	}

	private Pickup dP;
	private Return dRt;
	
	public Pickup getdP() {
		return dP;
	}
	public void setdP(Pickup dP) {
		this.dP = dP;
	}
	public Return getdRt() {
		return dRt;
	}
	public void setdRt(Return dRt) {
		this.dRt = dRt;
	}
	public String getZone() {
		return zone;
	}
	public void setZone(String zone) {
		this.zone = zone;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	
}
