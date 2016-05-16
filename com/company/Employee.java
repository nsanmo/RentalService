package com.company;

import java.util.HashMap;


public class Employee {
	private String name;
	private Boolean administrator;

	public Employee(String name, Boolean administrator) {
		this.name = name;
		this.administrator = administrator;
	}

	private BranchOffice eBO;
	public BranchOffice geteBO() { return eBO;	}
	public void seteBO(BranchOffice eBO) {	this.eBO = eBO;	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getAdministrator() {
		return administrator;
	}
	public void setAdministrator(Boolean administrator) {
		this.administrator = administrator;
	}

	private HashMap<String, Pickup> colePu = new HashMap<String, Pickup>();
	public Pickup getPickup(String identifier_pickup){
		return colePu.get(identifier_pickup);
	}
	public void add_Pickup(String nombre_res,Pickup o){
		colePu.put(nombre_res, o);
	}
	public void remove_Pickup(String identifier_pickup) {
		colePu.remove(identifier_pickup);
	}

	private HashMap<String, Return> coleR = new HashMap<String, Return>();
	public Return getReturn(String identifier_return){
		return coleR.get(identifier_return);
	}
	public void Return(String nombre_ret,Return o){
		coleR.put(nombre_ret, o);
	}
	public void remove_Return(String identifier_return) {
		coleR.remove(identifier_return);
	}

}
