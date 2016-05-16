//IReservationDAO
package persistence;
import java.util.List;

import persistence.dto.ReservationDTO;
import exceptions.*;


public interface IReservationDAO {

// public ReservationDTO findReservation(int id) throws DAOException;
 
 public List <ReservationDTO> getReservationsbyBranchOffice(int idBranchOffice) throws DAOException;
  
 public void createReservation(ReservationDTO reservation) throws DAOException;

public List<ReservationDTO> getReservations() throws DAOException;
}