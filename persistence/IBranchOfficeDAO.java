//IBranchOfficeDAO
package persistence;

import java.util.List;
 
import persistence.dto.BranchOfficeDTO;
import exceptions.*;

public interface IBranchOfficeDAO {
	 public List <BranchOfficeDTO> getBranchOffices() throws DAOException;
}
