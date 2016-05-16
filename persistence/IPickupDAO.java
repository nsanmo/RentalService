package persistence;
import java.time.LocalDateTime;
import java.util.List;
import exceptions.*;
import persistence.dto.PickupDTO;
import persistence.dto.ReservationDTO;

public interface IPickupDAO {
public void createPickup(PickupDTO pDTO) throws DAOException;
public List <PickupDTO> getPickup() throws DAOException;
}
