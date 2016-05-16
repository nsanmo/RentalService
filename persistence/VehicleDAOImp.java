package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import exceptions.DAOException;
import persistence.dto.ReservationDTO;
import persistence.dto.VehicleDTO;

public class VehicleDAOImp implements IVehicleDAO{
	protected ConnectionManager connManager;

	public VehicleDAOImp() throws DAOException {
		super();
		try {
			connManager= new ConnectionManager("vehiclerentalDB");
			}
		catch (ClassNotFoundException e) {
			throw new DAOException(e);
			}
	}
//	public List<VehicleDTO> getVehiclesbyBranchOffice (int idBranchOffice) throws DAOException{}
//		
//			try {
//				connManager.connect();
//				ResultSet rs = connManager.queryDB("select * from VEHICLE where BRANCHOFFICE = "
//								+ idBranchOffice );
//				connManager.close();
//				
//				List<VehicleDTO> listVehicleDTO = new ArrayList<VehicleDTO>();
//				try {
//					while (rs.next()) {
//						VehicleDTO veDTO = new VehicleDTO(
//								rs.getString("PLATENUMBER").trim(), 
//								rs.getDouble("KMS"),
//								rs.getInt("BRANCHOFFICE"),
//								rs.getString("CATEGORY").trim(),
//								rs.getString("NAME").trim());
//						listVehicleDTO.add(veDTO);
//					}
//					return listVehicleDTO;
//				} catch (Exception e) {
//					throw new DAOException(e);
//				}
//			} catch (SQLException e) {
//				throw new DAOException(e);
//			} catch (DAOException e) {
//				throw e;
//			}
//		}		
//	}

	public List<VehicleDTO> getVehicles() throws DAOException{
		
			try {
				connManager.connect();
				ResultSet rs = connManager.queryDB("select * from VEHICLE");
				connManager.close();
				
				List<VehicleDTO> listVehicleDTO = new ArrayList<VehicleDTO>();
				try {
					while (rs.next()) {
						VehicleDTO veDTO = new VehicleDTO(
								rs.getString("PLATENUMBER").trim(), 
								rs.getDouble("KMS"),
								rs.getInt("BRANCHOFFICE"),
								rs.getString("CATEGORY").trim(),
								rs.getString("NAME").trim());
						listVehicleDTO.add(veDTO);
					}
					return listVehicleDTO;
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

