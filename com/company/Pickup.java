package com.company;

import java.time.LocalDateTime;
import java.util.HashMap;

public class Pickup {

	private LocalDateTime date;
	private String insuranceModality;
	private double kms;
	private double gas_Level;
	private Employee pE;
	private Vehicle pV;
	private Reservation pR;
	private Return pRt;
	
	public Pickup(LocalDateTime date, String insuranceModality, double kms, double gas_Level) {
		this.date = date;
		this.insuranceModality = insuranceModality;
		this.kms = kms;
		this.gas_Level = gas_Level;
	}

	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public String getInsuranceModality() {
		return insuranceModality;
	}
	public void setInsuranceModality(String insuranceModality) {
		this.insuranceModality = insuranceModality;
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
	public Employee getpE() {
		return pE;
	}
	public void setpE(Employee pE) {
		this.pE = pE;
	}
	public Vehicle getpV() {
		return pV;
	}
	public void setpV(Vehicle pV) {
		this.pV = pV;
	}
	public Reservation getpR() {
		return pR;
	}
	public void setpR(Reservation pR) {
		this.pR = pR;
	}
	public Return getpRt() {
		return pRt;
	}
	public void setpRt(Return pRt) {
		this.pRt = pRt;
	}

	private HashMap<String, Damage> colpD = new HashMap<String, Damage>();
	public Damage getDamage(String identifier_damage){
		return colpD.get(identifier_damage);
	}
	public void add_Damage(String name_dam,Damage o){
		colpD.put(name_dam, o);
	}
	public void remove_Damage(String identifier_Damage) {
		colpD.remove(identifier_Damage);
	}
	
}
