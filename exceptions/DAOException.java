package exceptions;

@SuppressWarnings("serial")
public class DAOException extends Exception {

	public DAOException(String message) {
		super(message);
	}

	public DAOException(Exception e) {
		super(e.getMessage());
	}

}
