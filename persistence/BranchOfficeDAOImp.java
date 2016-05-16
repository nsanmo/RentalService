package persistence;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import persistence.dto.BranchOfficeDTO;
import persistence.dto.CategoryDTO;
import exceptions.DAOException;


public class BranchOfficeDAOImp implements IBranchOfficeDAO{

		protected ConnectionManager connManager;

		public BranchOfficeDAOImp() throws DAOException {
			super();
			try {
				connManager= new ConnectionManager("vehiclerentalDB");
				}
			catch (ClassNotFoundException e) {
				throw new DAOException(e);
			}
		}

		@Override
		public List<BranchOfficeDTO> getBranchOffices() throws DAOException {
			try {
				connManager.connect();
				ResultSet rs=connManager.queryDB("select * from BRANCHOFFICE");
				connManager.close();
				
				List<BranchOfficeDTO> BranchOfficeDTOList = new ArrayList<BranchOfficeDTO>();
				
				try {
					while (rs.next()){
						BranchOfficeDTO boDTO = new BranchOfficeDTO(
								rs.getInt("ID"),
								rs.getString("ADDRESS"));
						
						BranchOfficeDTOList.add(boDTO);
						}
					return BranchOfficeDTOList;
				}
				catch (Exception e){throw new DAOException(e);}
			}
			catch (SQLException e){throw new DAOException(e);}	
			catch (DAOException e){throw e;}
			
		}
		
}


