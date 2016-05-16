package com.company;
import java.util.ArrayList;
import java.util.HashMap;

public class BranchOffice {

	private String address;
	private int id;
	private VehicleRental boVr;
	
	public BranchOffice(int id, String address) {
		this.address = address;
		this.id = id;
	}

	public String getAddress(){
		return address;
	}
	public void setAddress(String address){
		this.address=address;
	}
	public int getId() {return id;}
	public void setId(int id) {	this.id = id;}

	
	public VehicleRental getBoVr() {
		return boVr;
	}
	public void setboVR(VehicleRental boVR) {
		this.boVr = boVR;
	}


	//Using name as indentifier
	private ArrayList <Employee> colboE = new ArrayList<Employee>();
	public Employee getEmployee(String identifier_Employee){
		for(Employee element: colboE)	{
			if(identifier_Employee.equals(element.getName())){
				return element;
			}
		}
		return null;
	}
	public void add_Employee(Employee o){
		colboE.add(o);
	}
	public void remove_Employee(String identifier_Employee){
		for(Employee element: colboE)	{
			if(identifier_Employee.equals(element.getName())){
				colboE.remove(element);
			}
		}
	}


	//Using plate number as identifier
	private ArrayList <Vehicle> colboV = new ArrayList<Vehicle>();
	
	public Vehicle getVehicle(String identifier_Vehicle){
		for(Vehicle element: colboV)	{
			if(identifier_Vehicle.equals(element.getPlate_number())){
				return element;
			}
		}
		return null;
	}
	
	public ArrayList<Vehicle> getVehicleList(){
		return colboV;
		}
	
	public void add_Vehicle(Vehicle o){
		colboV.add(o);
	}
	public void remove_Vehicle(String identifier_Vehicle){
		for(Vehicle element: colboV)	{
			if(identifier_Vehicle.equals(element.getPlate_number())){
				colboV.remove(element);
				break;
			}
		}
	}


	private HashMap<String, Reservation> colboRReturn = new HashMap<String, Reservation>();
	public Reservation getReturnReservation(String identifier_Reservation){	return colboRReturn.get(identifier_Reservation);	}

	public HashMap<String, Reservation> getTablaReservations(){
		HashMap<String, Reservation> map3 = new HashMap<String, Reservation>();
		map3.putAll(colboRReturn);
		map3.putAll(colboRPickup);
		return map3;
	}

	public void add_ReturnReservation(String nombre_res,Reservation o){
		colboRReturn.put(nombre_res, o);
	}
	public void remove_ReturnReservation(String identifier_Reservation) {
		colboRReturn.remove(identifier_Reservation);
	}


	private HashMap<String, Reservation> colboRPickup = new HashMap<String, Reservation>();
	public Reservation getPickupReservation(String identifier_Reservation){	return colboRPickup.get(identifier_Reservation);}
	public void add_PickupReservation(String nombre_res,Reservation o){
		colboRPickup.put(nombre_res, o);
	}
	public void remove_PickupReservation(String identifier_Reservation) {
		colboRPickup.remove(identifier_Reservation);
	}
}
