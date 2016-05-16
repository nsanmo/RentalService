package com.company;

import java.util.ArrayList;

public class Category {
	private String name;
	private double prizeUnlimitedMileage;
	private double prizeFixedMileage;
	private double prizeAdditionalKm;
	private double prizeFullInsurance;
	private double prizePartialInsurance;
	private Category caCa;

	public Category(String name, double prizeUnlimitedMileage, double prizeFixedMileage, double prizeAdditionalKm, double prizeFullInsurance, double prizePartialInsurance) {
		this.name = name;
		this.prizeUnlimitedMileage = prizeUnlimitedMileage;
		this.prizeFixedMileage = prizeFixedMileage;
		this.prizeAdditionalKm = prizeAdditionalKm;
		this.prizeFullInsurance = prizeFullInsurance;
		this.prizePartialInsurance = prizePartialInsurance;
		this.caCa=null;
	}

	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public void setPrizeUnlimitedMileage(double prizeUnlimitedMileage) {
		this.prizeUnlimitedMileage = prizeUnlimitedMileage;
	}
	public double getPrizeFixedMileage() {
		return prizeFixedMileage;
	}
	public void setPrizeFixedMileage(double prizeFixedMileage) {
		this.prizeFixedMileage = prizeFixedMileage;
	}
	public double getPrizeAdditionalKm() {
		return prizeAdditionalKm;
	}
	public void setPrizeAdditionalKm(double prizeAdditionalKm) {
		this.prizeAdditionalKm = prizeAdditionalKm;
	}
	public double getPrizeFullInsurance() {
		return prizeFullInsurance;
	}
	public void setPrizeFullInsurance(double prizeFullInsurance) {
		this.prizeFullInsurance = prizeFullInsurance;
	}
	public double getPrizePartialInsurance() {
		return prizePartialInsurance;
	}
	public void setPrizePartialInsurance(double prizePartialInsurance) {this.prizePartialInsurance = prizePartialInsurance;
	}
	public double getPrizeUnlimitedMileage() {
		return prizeUnlimitedMileage;
	}



	private VehicleRental caVr;
	public VehicleRental getCaVR() {return caVr;}
	public void setCaVR(VehicleRental caVR) {this.caVr = caVR;}

	public Category getCaCa() {	return caCa;}
	public void setCaCa(Category caCa) {this.caCa = caCa;}

	//Using plate number as identifier
	private ArrayList<Vehicle> colcaV = new ArrayList<Vehicle>();
	public Vehicle getVehicle(String identifier_Vehicle){
		for(Vehicle element: colcaV)	{
			if(identifier_Vehicle.equals(element.getPlate_number())){
				return element;
			}
		}
		return null;
	}
	public void add_Vehicle(Vehicle o){
		colcaV.add(o);
	}
	public void remove_Vehicle(String identifier_Vehicle){
		for(Vehicle element: colcaV)	{
			if(identifier_Vehicle.equals(element.getPlate_number())){
				colcaV.remove(element);
			}
		}
	}
}

