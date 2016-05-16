package com.company;

import java.time.LocalDateTime;


public class Reservation {
	private int id;
	private Customer customer;
	private LocalDateTime pickupDate;
	private LocalDateTime returnDate;
	private String rentalModality;
	private BranchOffice rBOpickup;
	private BranchOffice rBOreturn;
	private Category category;
	private Pickup pickup;
	

	public Reservation(int id, Customer customer, LocalDateTime pickupDate, LocalDateTime returnDate, 
			String rentalModality, Pickup pickup, Category category, BranchOffice rBOpickup, BranchOffice rBOreturn) {
		this.id=id;
		this.customer = customer;
		this.pickupDate = pickupDate;
		this.returnDate = returnDate;
		this.rentalModality = rentalModality;
		this.pickup = pickup;
		this.category=category;
		this.rBOpickup=rBOpickup;
		this.rBOreturn=rBOreturn;
	}
	

	private VehicleRental rVR;
	public VehicleRental getrVR() {
		return rVR;
	}
	public void setrVR(VehicleRental rVR) {
		this.rVR = rVR;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public LocalDateTime getPickupDate() {
		return pickupDate;
	}
	public void setPickupDate(LocalDateTime pickupDate) {
		this.pickupDate = pickupDate;
	}
	public LocalDateTime getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(LocalDateTime returnDate) {
		this.returnDate = returnDate;
	}
	public String getRentalModality() {
		return rentalModality;
	}
	public void setRentalModality(String rentalModality) {
		this.rentalModality = rentalModality;
	}
	public BranchOffice getrBOpickup() {
		return rBOpickup;
	}
	public void setrBOpickup(BranchOffice rBOpickup) {
		this.rBOpickup = rBOpickup;
	}
	public BranchOffice getrBOreturn() {
		return rBOreturn;
	}
	public void setrBOreturn(BranchOffice rBOreturn) {
		this.rBOreturn = rBOreturn;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Pickup getPickup() {
		return pickup;
	}
	public void setPickup(Pickup pickup) {
		this.pickup = pickup;
	}

}