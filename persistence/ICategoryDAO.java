//ICategoryDAO
package persistence;
import java.util.List;
import persistence.dto.CategoryDTO;
import exceptions.*;

public interface ICategoryDAO {
 public CategoryDTO findCategory(String name)throws DAOException;

 public List <CategoryDTO> getCategories() throws DAOException;
}
