package com.company;

import java.util.HashMap;

public class Vehicle {
	private String plate_number;
	private double kms;
	private BranchOffice vBo;
	
	public Vehicle(String plate_number, double kms, Category ca) {
		this.plate_number = plate_number;
		this.kms = kms;
		this.vCa=ca;
	}

	public String getPlate_number() {
		return plate_number;
	}
	public void setPlate_number(String plate_number) {
		this.plate_number = plate_number;
	}
	public double getKms() {
		return kms;
	}
	public void setKms(double kms) {
		this.kms = kms;
	}

	
	public BranchOffice getvBo() {return vBo;}
	public void setvBo(BranchOffice vBo) {	this.vBo = vBo;	}

	private Category vCa;
	public Category getvCa() {
		return vCa;
	}
	public void setvCa(Category vCa) {
		this.vCa = vCa;
	}

	private HashMap<String, Pickup> colvPu = new HashMap<String, Pickup>();
	public Pickup getPickup(String identifier_pickup){
		return colvPu.get(identifier_pickup);
	}
	public void add_Pickup(String nombre_res, Pickup o){
		colvPu.put(nombre_res, o);
	}
	public void remove_Pickup(String identifier_pickup) {
		colvPu.remove(identifier_pickup);
	}
}
