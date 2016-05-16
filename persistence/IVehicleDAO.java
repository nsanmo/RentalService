package persistence;

import java.util.List;

import exceptions.DAOException;
import persistence.dto.ReservationDTO;
import persistence.dto.VehicleDTO;

public interface IVehicleDAO {
	//public List<VehicleDTO> getVehiclesbyBranchOffice (int idBranchOffice)throws DAOException;

	public List<VehicleDTO> getVehicles() throws DAOException;
}
