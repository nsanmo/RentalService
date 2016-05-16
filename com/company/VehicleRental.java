package com.company;
import java.time.LocalDateTime;
import java.util.*;

import persistence.*;
import persistence.dto.*;


public class VehicleRental{
	private ArrayList<BranchOffice> branchOfficeList;
	private HashMap<String, Category> categoryList;
	private ArrayList <Customer> customerList;
	private ArrayList<Reservation> reservationList;
	private List<Vehicle> vehicleList;
	private List<Employee> employeeList;
	private List<Pickup> pickupList;
	private DAL dal;
	
	private static VehicleRental INSTANCE = new VehicleRental();
	
    public VehicleRental(){
    	this.branchOfficeList = new ArrayList<BranchOffice>();
    	this.categoryList = new HashMap<String, Category>();
    	this.customerList = new ArrayList<Customer>();
    	this.reservationList = new ArrayList<Reservation>();
    	this.vehicleList = new ArrayList<Vehicle>();
    	this.employeeList = new ArrayList<Employee>();
    	this.pickupList = new ArrayList<Pickup>();
    	dal = DAL.getDal();
        systemload();
    }
    public static VehicleRental getVehicleRental(){
        return INSTANCE;
    }
    public DAL getDal() {
		return dal;
	}
	public void setDal(DAL dal) {
		this.dal = dal;
	}
	
	// 
	public BranchOffice getBranchOffice(int identifier_BranchOffice){
        for(BranchOffice element: branchOfficeList)	{
            if(identifier_BranchOffice==(element.getId())){
                return element;
            }
        }
        return null;
    }
    public void add_BranchOffice(BranchOffice o){
    	branchOfficeList.add(o);
    }
    public void remove_BranchOffice(String identifier_BranchOffice){
        for(BranchOffice element: branchOfficeList)	{
            if(identifier_BranchOffice.equals(element.getAddress())){
            	branchOfficeList.remove(element);
            }
        }
    }
    public List<BranchOffice> branchOfficesList (){
        return branchOfficeList;
    }

    public HashMap<String, Reservation> resBranch (BranchOffice o){
        for(BranchOffice element: branchOfficeList)	{
            if(o.equals(element)) return  element.getTablaReservations();
        }
        return null;
    }
    public void add_Vehicle(Vehicle o){
    	vehicleList.add(o);
    }

    public void add_Employee(Employee o){
    	employeeList.add(o);
    }
    
    public Category getCategory(String identifier_Category){
        return categoryList.get(identifier_Category);
    }
    public void add_Category(String nombre_cat,Category o){
    	categoryList.put(nombre_cat, o);
    }
    public void remove_Category(String identifier_Category) {
    	categoryList.remove(identifier_Category);
    }
    public Category find_Category(String identifier_Category) {
    	return categoryList.get(identifier_Category);
    }

    public Collection<Category> categoryList() {
        Collection <Category> a= categoryList.values();
        return a;
    }
    
    public ArrayList<Customer> getCustomers(){
        return customerList;
    }
    public Customer getCustomer(String dni){
        for(Customer element: customerList)	{
            if(element.getDni().equals(dni)){
                return element;
            }
        }
        return null;
    }

    public void add_Customer(Customer o){
    	customerList.add(o);
    }
    public void remove_Customer(String identifier_Customer){
        for(Customer element: customerList)	{
            if(identifier_Customer.equals(element.getNameAndSurname())){
            	customerList.remove(element);
            }
        }
    }
   
    public List<Reservation> getReservations(){
        return reservationList;
    }
    public int getSize(){
    	return reservationList.size();
    }
    public void add_Reservation(Reservation o){
    	reservationList.add(o);
    }
    public void remove_Reservation(Reservation o) {
    	reservationList.remove(o);
    }
    
    public Reservation getReservation(int id) {
		Reservation reservaId = null;
		for (Reservation reservation : this.reservationList) {
			if (reservation.getId() == id) {
				reservaId = reservation;
				break;
			}
		}
		return reservaId;
	}
	
	// Control class code
    private void systemload(){
    	loadVehicles();
    	loadCustomer();
    	loadBO();  
        loadCategories();  
        loadReservations();
        loadCustomer();
        loadVehicles();
        loadEmployee();
        //loadPickup();
     }

	public static ArrayList<Vehicle> showAvailableVehicles(Reservation res){
    	BranchOffice bo = res.getrBOpickup();
    	ArrayList<Vehicle> boVehicles = bo.getVehicleList();
    	Category cat = res.getCategory();
    	ArrayList<Vehicle> aVehicleList= new ArrayList<Vehicle>();
    	
    	if(boVehicles.isEmpty()){
    		return null;
    	}else{
    		while(cat!=null){
        		for(Vehicle v : boVehicles){
        			if(v.getvCa()==cat) aVehicleList.add(v);
        		}
        		if(aVehicleList.isEmpty()){
        			cat = cat.getCaCa();
        		}else {
        			
        			return aVehicleList;
        		}
    		}
    		return null;
    	}
    }

	
	public ArrayList<Vehicle> listAvailableVehiclesByBO(BranchOffice bo){
    	ArrayList<Vehicle> vl=bo.getVehicleList();
    	if(vl.isEmpty()){
    		return null;
    	}
    		return vl;
    	}

	
// si todos los vehiculos estan a nulos

//	public static ArrayList<Vehicle> showAvailableVehicles(Category cat){//Return a list of available vehicles of
//			//a given Branch Office in the reserved category,
//			//or of an upper category. if no available veihicle,
//			//then return Null.
//			if(cat.listVehicles().isEmpty()){
//				if(cat.getCaCa()==null){
//					return null;
//				}else{
//				return showAvailableVehicles(cat.getCaCa());
//				}
//			}else{
//				return cat.listVehicles();
//			}
//	}
	
    
    
    /// ARREGLAR ESTO...!!!
    
//    private HashMap<String, Category> colvrCa = new HashMap<String, Category>();
//    
//    public Category getCategory(String identifier_Category){
//        return colvrCa.get(identifier_Category);
//    }
//    public void add_Category(String nombre_cat,Category o){
//            colvrCa.put(nombre_cat, o);
//    }
//    public void remove_Category(String identifier_Category) {
//        colvrCa.remove(identifier_Category);
//    }
//    public Category find_Category(String identifier_Category) {
//    	return colvrCa.get(identifier_Category);
//    }
//
//    public Collection<Category> categoryList() {
//        Collection <Category> a= colvrCa.values();
//        return a;
//    }
    
    
    

    

    
	
	private void loadCategories(){
		CategoryDTO catDTO;
		Category cat, upperCat;
		List<CategoryDTO> catDTOList= dal.getCategories();
		Iterator<CategoryDTO> it=catDTOList.iterator();
		
		while (it.hasNext()){
			catDTO=(CategoryDTO)it.next();
			add_Category(catDTO.getName(),new Category( catDTO.getName(),
			catDTO.getPriceUnlimitedMileage(),
			catDTO.getPriceFixedMileage(),
			catDTO.getPriceAdditionalKm(),
			catDTO.getPriceFullInsurance(),
			catDTO.getPricePartialInsurance()));
			}
			//Update the links that represent the ï¿½upperï¿½ association
			it=catDTOList.iterator();
			while (it.hasNext()){
				catDTO=(CategoryDTO)it.next();
				cat=getCategory(catDTO.getName());
				if (catDTO.getUpperCategoryName()!=null)
				upperCat=getCategory(catDTO.getUpperCategoryName());
				else upperCat=null;
				if (upperCat!=null)
				cat.setCaCa(upperCat);
		}
			
	}
	private void loadBO(){
		BranchOfficeDTO boDTO;
		List<BranchOfficeDTO> boDTOList = dal.getBranchOffice();
		Iterator<BranchOfficeDTO> it = boDTOList.iterator();
		
		while (it.hasNext()){
			boDTO=((BranchOfficeDTO)it.next());
			add_BranchOffice(new BranchOffice(boDTO.getId(),boDTO.getAddress()));
		}
	}
//	// BORRAR
	// Un load que lo traiga todo
//	//
//	private void loadReservations() {
//		List<Reservation> reservationbyBO=new ArrayList<Reservation>();
//		if(branchOfficeList!=null)
//			// Create and add the reservations to the collection
//			for (BranchOffice bo : branchOfficeList) {
//				reservationbyBO=listReservationByBranchOffice(bo.getId());
//				if(reservationbyBO!=null)
//					for (Reservation reserv : reservationbyBO) {
//						reservationList.add(reserv);
//					}
//			}
//	}
	
	private void loadReservations(){
		List<ReservationDTO> listReservationDTO = dal.getReservations();
			for(ReservationDTO resDTO : listReservationDTO){
				reservationList.add(new Reservation(
						resDTO.getId(),
						getCustomer(resDTO.getCustomerDni()),
						(resDTO.getPickupDate()),
						(resDTO.getReturnDate()),
						resDTO.getRentalModality(),
						(Pickup)null, /// ARREGLAR ESTO!!!
						getCategory(resDTO.getCategoryName()),
						getBranchOffice(resDTO.getIdPickupBranchOffice()),
						getBranchOffice(resDTO.getIdReturnBranchOffice())));
			}
		
	}
	
	
	private void loadCustomer() {
		List<CustomerDTO> listCustomerDTO = dal.getCustomers();

		if(listCustomerDTO!=null) 
			// Create and add all the customers to the collection
			for (CustomerDTO customerDTO : listCustomerDTO) {
				add_Customer(new Customer(
						customerDTO.getDni(),
						customerDTO.getNameAndSurname(), 
						customerDTO.getAddress(),
						customerDTO.getCity(), 
						customerDTO.getPostalCode(),
						customerDTO.getDateDriverLicense(), 
						customerDTO.getDigitsCC(),
						customerDTO.getMonthCC(), 
						customerDTO.getYearCC(), 
						customerDTO.getCvcCC(),
						customerDTO.getTypeCC()));
			}
	}
	// ESTO MOLA, RELACIÃ“N ENTRE OBJETOS.
	// COMPROBAMOS QUE EL NUEVO VEHICULO PERTENECE A UNA BRANCHOFFICE Y METEMOS EL 
	// VEHICULO EN LA LISTA DE BRANCHOFFICES
	// ASÃ� EL MÃ‰TODO DE ADRI FUNCIONARÃ�
	private void loadVehicles() {
		List<VehicleDTO> vehicleDTOList = dal.getVehicles();
		List<BranchOffice> bolist = branchOfficesList();
		for(VehicleDTO ved : vehicleDTOList){
				vehicleList.add(new Vehicle(ved.getPlate_number(), ved.getKms(), find_Category(ved.getCat())));
				for(BranchOffice bo: bolist){
					if(ved.getBo() == bo.getId()) bo.add_Vehicle(new Vehicle(ved.getPlate_number(), ved.getKms(), find_Category(ved.getCat())));
				}
				
		}
	}
	
	private void loadEmployee() {
		List<EmployeeDTO> employeeDTOList = dal.getEmployees();
		List<BranchOffice> bolist = branchOfficesList();
		for(EmployeeDTO em : employeeDTOList){
				employeeList.add(new Employee(em.getName(), em.isAdministrator()));
				for(BranchOffice bo: bolist){
					if(em.getBo() == bo.getId()) bo.add_Employee(new Employee(em.getName(), em.isAdministrator()));
				}
				
		}

	}

	private void loadPickup(){
		List<PickupDTO> pDTOList = dal.getPickup();
		for(PickupDTO pu : pDTOList){
			Pickup p=new Pickup(pu.getDate(),pu.getInsuranceModality(),pu.getKms(),pu.getGas_Level());
			pickupList.add(p);
			for(Reservation res : reservationList){
				if(res.getId()==pu.getId()){
					res.setPickup(p);
				}
				
			}
		}
	}
		
	
	
	public void createCustomer(Customer newCustomer) {
		CustomerDTO customerDTO = new CustomerDTO(newCustomer.getDni(),
                newCustomer.getNameAndSurname(), newCustomer.getAddress(),
                newCustomer.getCity(), newCustomer.getPostalCode(),
                newCustomer.getDateDriverLicense(), newCustomer.getDigitsCC(),
                newCustomer.getMonthCC(), newCustomer.getYearCC(), newCustomer.getCvcCC(),
                newCustomer.getTypeCC());
		
		
	// add it to collection
	add_Customer(newCustomer);
	// requests DAL to make it persistent
	dal.createCustomer(customerDTO);
	
	}
	private void add_Pickup(Pickup p) {
		pickupList.add(p);
		}
	
	private void createPickup(Pickup p,int resId) {
       	PickupDTO pDTO = new PickupDTO(resId,p.getDate(),p.getInsuranceModality(), p.getKms(),p.getGas_Level());
       	//add in memory.
       	add_Pickup(p);
       	//add to DB
       	dal.createPickup(pDTO);
		
	}
	
	
	
	public int creaReservation(String dni, LocalDateTime pickupDate, LocalDateTime returnDate, int idPUBO, int idRBO,
			String nameCat, String modRental) {
			LocalDateTime today = LocalDateTime.now();
	
		Customer customerReservation = getCustomer(dni);
		Category categ = getCategory(nameCat);
		BranchOffice boPickup = getBranchOffice(idPUBO);
		BranchOffice boReturn = getBranchOffice(idRBO);
		
		int idReserva = getSize() + 1;
		
		Reservation reservation = new Reservation(idReserva, customerReservation, pickupDate, 
				returnDate, modRental, null, categ, boPickup, boReturn);
		add_Reservation(reservation);
		
		ReservationDTO reservationDTO = new ReservationDTO(idReserva, pickupDate, 
				returnDate, modRental, 
				nameCat, dni, idPUBO , idRBO);
		dal.createReservation(reservationDTO);
		
		return idReserva;
	}
	
	public void createReservation(Reservation res){
		creaReservation(""+res.getId(), res.getPickupDate(), res.getReturnDate(), res.getrBOpickup().getId(),
				res.getrBOreturn().getId(), res.getCategory().getName(), res.getRentalModality());
	} 
	
	
		// BORRAR EL BUENO ES EL DE BAJO
		// Hacerlo sobre la lista donde tienes todas las reservations
//		public List<Reservation> listReservationByBranchOffice(int id) {
//			List<ReservationDTO> reservationDTOList = dal.getReservationsbyBranchOffice(id);
//			List<Reservation> reservationList = new ArrayList<Reservation>();
//			if(reservationDTOList!=null) 
//				for (ReservationDTO reservation : reservationDTOList) {
//					reservationList.add(new Reservation(
//							reservation.getId(),
//							getCustomer(reservation.getCustomerDni()),
//							(reservation.getPickupDate()),
//							(reservation.getReturnDate()),
//							reservation.getRentalModality(),
//							(Pickup)null,
//							getCategory(reservation.getCategoryName()),
//							getBranchOffice(reservation.getIdPickupBranchOffice()),
//							getBranchOffice(reservation.getIdReturnBranchOffice())));
//					
//				}
//			return reservationList;
//		}
	
	public List<Reservation> listReservationByBranchOffice(int id) {
		List<Reservation> reserListBO = new ArrayList <Reservation>();
		List<Reservation> reserList = getReservations();
		for(Reservation res: reserList)	{
			if(res.getrBOpickup().getId() == id || res.getrBOreturn().getId() == id ){
				reserListBO.add(res);
			}
		}
		return reserListBO;
	}
		
	
	    public void  ReservationToPickup(String insuranceModality, double kms,double gas_Level,Vehicle v,BranchOffice bo, int resId){
	    	//Crerate PickUp.
	    	LocalDateTime today = LocalDateTime.now();
	       	Pickup p = new Pickup(today,insuranceModality, kms,gas_Level);
	       	//add to DB
	       	//createPickup(p,resId);
	        //update other Clases.	
	        bo.remove_Vehicle(v.getPlate_number());
	        v.add_Pickup(""+resId, p);
	        v.setvBo(null);
	        }
	
	    
	   
	

}