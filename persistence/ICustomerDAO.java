//ICustomerDAO
package persistence;

import java.util.List;

import exceptions.*;
import persistence.dto.CustomerDTO;


public interface ICustomerDAO {
	public CustomerDTO findCustomer(String dni)throws DAOException;
	
	public void createCustomer(CustomerDTO customer) throws DAOException;
	
	 public List<CustomerDTO> getCustomers() throws DAOException;

}