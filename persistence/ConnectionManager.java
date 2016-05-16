package persistence;
import java.sql.*;

public class ConnectionManager {
	private String sourceURL;
	private Connection dbcon = null;

	public ConnectionManager(String dbname) throws ClassNotFoundException {
		Class.forName("org.hsqldb.jdbcDriver");
		sourceURL = "jdbc:hsqldb:file:./data/" + dbname+";shutdown=true";
	}

	public void connect() throws SQLException {
		if (dbcon == null)
				dbcon = DriverManager.getConnection(sourceURL);
	}

	public void close() throws SQLException {
		if (dbcon != null) {
				dbcon.close();
				dbcon = null;
		}
	}

	public void updateDB(String sql) throws SQLException {
		if (dbcon != null) {
				Statement statement = dbcon.createStatement();
				statement.executeUpdate(sql);
		}
	}

	public ResultSet queryDB(String sql) throws SQLException {
		if (dbcon != null) {
				Statement statement = dbcon.createStatement();
				return statement.executeQuery(sql);
		}
		return null;
	}
}
