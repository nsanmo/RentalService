package persistence;

import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import exceptions.DAOException;
import persistence.dto.CategoryDTO;
import persistence.dto.CustomerDTO;



public class CustomerDAOImp implements ICustomerDAO{
	LocalDateTime dateTime;
	protected ConnectionManager connManager;

	public CustomerDAOImp() throws DAOException {
		super();
		try {
			connManager= new ConnectionManager("vehiclerentalDB");
			}
		catch (ClassNotFoundException e) {
			throw new DAOException(e);
			}
		}
	public CustomerDTO findCustomer(String dni) throws DAOException {
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from CUSTOMER where DNI= '"+dni+"'");
			connManager.close();
			
					if (rs.next()){
						dateTime = LocalDateTime.of(rs.getDate("DATEDRIVERLICENSE").toLocalDate(), 
								rs.getTime("DATEDRIVERLICENSE").toLocalTime());					
			
				return new CustomerDTO(
						rs.getString("ID"),
						rs.getString("NAMEANDSURNAME"),
						rs.getString("ADDRESS"),
						rs.getString("CITY"),
						rs.getString("POSTALCODE"),
						dateTime,
						rs.getString("DIGITSCC"),
						rs.getInt("MONTHCC"),
						rs.getInt("YEARCC"),
						rs.getInt("CVCCC"),
						rs.getString("TYPECC")
						);		
					}else
				return null;
		}
		catch (SQLException e){	throw new DAOException(e);}	
	}
	
	public void createCustomer(CustomerDTO customer) throws DAOException {
		
		try{

			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime dateTime = customer.getDateDriverLicense();
			String formattedDateTime=dateTime.format(formatter);
			String ins = "insert into CUSTOMER (DNI, NAMEANDSURNAME, ADDRESS, CITY, POSTALCODE, "
			                    + "DATEDRIVERLICENSE, DIGITSCC, MONTHCC, YEARCC, CVCCC, TYPECC) values ('"+customer.getDni()+"','"
			                    +customer.getNameAndSurname()+"','"
			                    +customer.getAddress()+"', '"+customer.getCity()+"','"+customer.getPostalCode()+"','"
			                    +formattedDateTime+"','"+customer.getDigitsCC()+"',"+customer.getMonthCC()+","+customer.getYearCC()+","
			                    +customer.getCvcCC()+",'"+customer.getTypeCC()+"')";
			
			
			
			connManager.connect();
			connManager.updateDB(ins);
			connManager.close();	
		}
		catch (SQLException e){	throw new DAOException(e);}	
	}
	
	public List<CustomerDTO> getCustomers() throws DAOException {
		try {
			connManager.connect();
			ResultSet rs = connManager.queryDB("select * from CUSTOMER");
			connManager.close();

			List<CustomerDTO> listCustomerDTO = new ArrayList<CustomerDTO>();

			try {
				while (rs.next()) {

					CustomerDTO customerDTO = new CustomerDTO(
							rs.getString("DNI").trim(),
							rs.getString("NAMEANDSURNAME").trim(),
							rs.getString("ADDRESS").trim(),
							rs.getString("CITY").trim(),
							rs.getString("POSTALCODE").trim(), 
							rs.getTimestamp("DATEDRIVERLICENSE").toLocalDateTime(),
							rs.getString("DIGITSCC").trim(), 
							rs.getInt("MONTHCC"),
							rs.getInt("YEARCC"), 
							rs.getInt("CVCCC"),
							rs.getString("TYPECC").trim());
					listCustomerDTO.add(customerDTO);
				}
				return listCustomerDTO;
			} catch (Exception e) {
				throw new DAOException(e);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} catch (DAOException e) {
			throw e;
		}

	}
}
