package testPostgres;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		try {
			Connection conn = getConnection();
			String insertTableSQL = "CREATE TABLE treinamento";
			PreparedStatement preparedStatement = conn.prepareStatement(insertTableSQL);
			preparedStatement.executeQuery();
			conn.close();
			
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private static Connection getConnection() throws URISyntaxException, SQLException {
	    String dbUrl = System.getenv("JDBC_DATABASE_URL");
	    return DriverManager.getConnection(dbUrl);
	}
}


