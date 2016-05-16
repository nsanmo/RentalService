package persistence;

import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import exceptions.DAOException;
import persistence.dto.CustomerDTO;
import persistence.dto.PickupDTO;
import persistence.dto.ReservationDTO;

public class PickupDAOImp implements IPickupDAO {
	LocalDateTime dateTime;
	protected ConnectionManager connManager;
	@Override
	public void createPickup(PickupDTO pDTO) throws DAOException {
		try{// TODO Auto-generated method stub
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime dateTime = pDTO.getDate();
			String formattedDateTime=dateTime.format(formatter);
			String ins = "insert into PICKUP (DATE, INSURANCEMODALITY, KMS,GASLEVEL,VEHICLE,EMPLOYEE)"
			                    + " values ('"+pDTO.getId()+"','"
			                    +formattedDateTime+"','"
			                    +pDTO.getInsuranceModality()+"','"
			                    +pDTO.getKms()+"', '"+pDTO.getGas_Level()+"','"+null+"','"
			                    +null+"')";
			
			//System.out.println(ins);//Debugging.
			connManager.connect();
			connManager.updateDB(ins);
			connManager.close();
		}catch(SQLException e){	throw new DAOException(e);}
	}
	@Override
	public List<PickupDTO> getPickup() throws DAOException {
		try {
			connManager.connect();
			ResultSet rs = connManager.queryDB("select * from PICKUP");
			connManager.close();

			List<PickupDTO> listPickupDTO = new ArrayList<PickupDTO>();

			try {
				while (rs.next()) {

					PickupDTO pDTO = new PickupDTO(
							rs.getInt("ID"),
							rs.getTimestamp("DATE").toLocalDateTime(),
							rs.getString("INSURANCEMODALITY").trim(),
							rs.getDouble("KMS"),
							rs.getDouble("GASLEVEL")
							//,rs.getString("VEHICLE").trim(), 
							//rs.getString("EMPLOYEE").trim()
							);
					listPickupDTO.add(pDTO);
				}
				return listPickupDTO;
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
