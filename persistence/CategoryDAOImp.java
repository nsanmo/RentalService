//CategoryDAOImp
package persistence;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import persistence.dto.CategoryDTO;
import exceptions.DAOException;

public class CategoryDAOImp implements ICategoryDAO {
	protected ConnectionManager connManager;

	public CategoryDAOImp() throws DAOException {
		super();
		try {
			connManager= new ConnectionManager("vehiclerentalDB");
			}
		catch (ClassNotFoundException e) {
			throw new DAOException(e);
			}
		}
	

	  
	public List <CategoryDTO> getCategories() throws DAOException {
		try {
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from CATEGORY");
			connManager.close();
			
			List<CategoryDTO> categoryDTOList = new ArrayList<CategoryDTO>();
			
			try {
				while (rs.next()){
					CategoryDTO catDTO = new CategoryDTO(
							rs.getString("NAME"),
							rs.getDouble("PRICEUNLIMITEDMILEAGE"),
							rs.getDouble("PRICEFIXEDMILEAGE"),
							rs.getDouble("PRICEADDITIONALKM"),
							rs.getDouble("PRICEFULLINSURANCE"),
							rs.getDouble("PRICEPARTIALINSURANCE"),
							rs.getString("UPPERCATEGORY"));
					
					categoryDTOList.add(catDTO);
					}
				return categoryDTOList;
			}
			catch (Exception e){throw new DAOException(e);}
		}
		catch (SQLException e){throw new DAOException(e);}	
		catch (DAOException e){throw e;}
	
	}

	  
	public CategoryDTO findCategory(String name)throws DAOException{
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from CATEGORY where NAME= '"+name+"'");
			connManager.close();
		
			if (rs.next())
				return new CategoryDTO(
						rs.getString("NAME"),
						rs.getDouble("PRICEUNLIMITEDMILEAGE"),
						rs.getDouble("PRICEFIXEDMILEAGE"),
						rs.getDouble("PRICEADDITIONALKM"),
						rs.getDouble("PRICEFULLINSURANCE"),
						rs.getDouble("PRICEPARTIALINSURANCE"),
						rs.getString("UPPERCATEGORY"));
			else
				return null;
			
		}
		catch (SQLException e){	throw new DAOException(e);}	
	}
}
