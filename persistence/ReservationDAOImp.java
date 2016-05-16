package persistence;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import persistence.dto.CategoryDTO;
import persistence.dto.ReservationDTO;
import exceptions.DAOException;
import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class ReservationDAOImp implements IReservationDAO{
	protected ConnectionManager connManager;
	LocalDateTime dateTime1, dateTime2, dateTime3, dateTime4;

	public ReservationDAOImp() throws DAOException {
		super();
		try {
			connManager= new ConnectionManager("vehiclerentalDB");
			}
		catch (ClassNotFoundException e) {
			throw new DAOException(e);
			}
	}
	
	@Override
	public List<ReservationDTO> getReservationsbyBranchOffice (int idbranchoffice) throws DAOException {
		try {
			connManager.connect();
			ResultSet rs = connManager.queryDB("select * from RESERVATION where PICKUPPLACE = "
							+ idbranchoffice+" OR RETURNPLACE = "+idbranchoffice);
			connManager.close();
			
			List<ReservationDTO> listReservationDTO = new ArrayList<ReservationDTO>();
			try {
				while (rs.next()) {
					ReservationDTO resDTO = new ReservationDTO(
							rs.getInt("ID"), 
							rs.getTimestamp("PICKUPDATE").toLocalDateTime(),
							rs.getTimestamp("RETURNDATE").toLocalDateTime(),
							rs.getString("RENTALMODALITY").trim(),
							rs.getString("CATEGORY").trim(),
							rs.getString("CUSTOMER").trim(),
							rs.getInt("PICKUPPLACE"),
							rs.getInt("RETURNPLACE"));
					listReservationDTO.add(resDTO);
				}
				return listReservationDTO;
			} catch (Exception e) {
				throw new DAOException(e);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} catch (DAOException e) {
			throw e;
		}
	}

	public void createReservation(ReservationDTO reservation) throws DAOException {
		try {
		//	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		//	LocalDateTime dateTime = customer.getDateDriverLicense();
		//	String formattedDateTime=dateTime.format(formatter);
			
			String ins= "INSERT INTO RESERVATION VALUES ("
			+ reservation.getId()
			+ ",'"
			+ Timestamp.valueOf(reservation.getPickupDate())
			+ "','"
			+ Timestamp.valueOf(reservation.getReturnDate()) + "','"
			+ reservation.getRentalModality() + "','"
			+ reservation.getCategoryName() + "','"
			+ reservation.getCustomerDni() + "',"
			+ reservation.getIdPickupBranchOffice() + ","
			+ reservation.getIdReturnBranchOffice()+")";
			
			connManager.connect();
			connManager.updateDB(ins);
			connManager.close();
			
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		
	}

	@Override
	public List<ReservationDTO> getReservations() throws DAOException {
		try {
			connManager.connect();
			ResultSet rs = connManager.queryDB("select * from RESERVATION");
			connManager.close();
			
			List<ReservationDTO> listReservationDTO = new ArrayList<ReservationDTO>();
			try {
				while (rs.next()) {
					ReservationDTO resDTO = new ReservationDTO(
							rs.getInt("ID"), 
							rs.getTimestamp("PICKUPDATE").toLocalDateTime(),
							rs.getTimestamp("RETURNDATE").toLocalDateTime(),
							rs.getString("RENTALMODALITY").trim(),
							rs.getString("CATEGORY").trim(),
							rs.getString("CUSTOMER").trim(),
							rs.getInt("PICKUPPLACE"),
							rs.getInt("RETURNPLACE"));
					listReservationDTO.add(resDTO);
				}
				return listReservationDTO;
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

