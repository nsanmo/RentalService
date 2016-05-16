package persistence;

import java.util.List;

import exceptions.DAOException;
import persistence.dto.BranchOfficeDTO;
import persistence.dto.EmployeeDTO;

public interface IEmployeeDAO {
	public List<EmployeeDTO> getEmployees() throws DAOException;

}
