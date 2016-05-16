package persistence;

import java.util.List;

import exceptions.DAOException;
import persistence.*;
import persistence.dto.*;


public final class DAL {

	private ICategoryDAO catDAO;
	private IBranchOfficeDAO boDAO;
	private ICustomerDAO cuDAO;
	private IReservationDAO reDAO;
	private IVehicleDAO veDAO;
	private IEmployeeDAO eDAO;
	private IPickupDAO piDAO;
	
	private static DAL INSTANCE = new DAL();
	
	private DAL(){
		try {
			this.catDAO = new CategoryDAOImp();
			this.boDAO = new BranchOfficeDAOImp();
			this.cuDAO = new CustomerDAOImp();
			this.reDAO = new ReservationDAOImp();
			this.veDAO = new VehicleDAOImp();
			this.eDAO = new EmployeeDAOImp();
			this.piDAO = new PickupDAOImp();
			
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}
	public static DAL getDal(){
		return INSTANCE;
	}
	
	public List<CategoryDTO> getCategories(){
		try{
		return catDAO.getCategories();
		}
		catch (DAOException e){ return null; }
	}
	public List<BranchOfficeDTO> getBranchOffice(){
		try{
		return boDAO.getBranchOffices();
		}
		catch (DAOException e){ return null; }
	}
	public boolean createCustomer(CustomerDTO customerDTO) {
		try{
		cuDAO.createCustomer(customerDTO);
		return true;
		}catch(DAOException e){ return false;}
	}
	public boolean createReservation(ReservationDTO reservationDTO) {
		try{
		reDAO.createReservation(reservationDTO);
		return true;
		}catch(DAOException e){ return false;}
	}
	public List<ReservationDTO> getReservationsbyBranchOffice(int id) {
	    	try {
	    		return reDAO.getReservationsbyBranchOffice(id);
	    	} catch (DAOException e) {
	    		return null;
	    	}
	}
	 public List<CustomerDTO> getCustomers(){
	    	try{
	    		return cuDAO.getCustomers();
	    	}catch (DAOException e){
	    		return null;
	    	}
	    }
//	 public List<VehicleDTO> getVehiclesbyBranchOffice(int idBranchOffice){
//		 try{
//			 	return veDAO.getVehiclesbyBranchOffice(idBranchOffice);
//		 }catch(DAOException e){
//			 return null;
//		 }
//	 }
	public List<VehicleDTO> getVehicles() {
		try{
			return veDAO.getVehicles();
		}catch(DAOException e){
		 return null;
		}
	}
	public List<EmployeeDTO> getEmployees() {
		try{
			return eDAO.getEmployees();
		}catch(DAOException e){
			 return null;
		}
	}

	public List<ReservationDTO> getReservations() {
		try{
			return reDAO.getReservations();
		}catch(DAOException e){
			return null;
		}
	}
	public boolean createPickup(PickupDTO pDTO) {
		try{
			piDAO.createPickup(pDTO);
			return true;
		}catch(DAOException e){return false;}
		
	}
	public List<PickupDTO> getPickup() {
		try{
			return piDAO.getPickup();
		}catch(DAOException e){return null;}
	}
	
}
