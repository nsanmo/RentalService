package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exceptions.DAOException;
import persistence.dto.BranchOfficeDTO;
import persistence.dto.EmployeeDTO;

public class EmployeeDAOImp implements IEmployeeDAO{
		protected ConnectionManager connManager;

		public EmployeeDAOImp() throws DAOException {
		super();
		try {
			connManager= new ConnectionManager("vehiclerentalDB");
			}
		catch (ClassNotFoundException e) {
			throw new DAOException(e);
		}
	}
	public List<EmployeeDTO> getEmployees() throws DAOException {
		try {
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from EMPLOYEE");
			connManager.close();
			
			List<EmployeeDTO> EmployeeDTOList = new ArrayList<EmployeeDTO>();
			try {
				while (rs.next()){
					EmployeeDTO emDTO = new EmployeeDTO(
							rs.getString("DNI"),
							rs.getString("NAME"),
							rs.getBoolean("ADMINISTRATOR"),
							rs.getInt("BRANCHOFFICE"));
					
					EmployeeDTOList.add(emDTO);
					}
				return EmployeeDTOList;
			}
			catch (Exception e){throw new DAOException(e);}
		}
		catch (SQLException e){throw new DAOException(e);}	
		catch (DAOException e){throw e;}
		
	}

}
