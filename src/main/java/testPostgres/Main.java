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
			String insertTableSQL = "CREATE TABLE `treinamento` (\r\n" + 
					"  `id` int(11) NOT NULL,\r\n" + 
					"  `nome` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,\r\n" + 
					"  `atividade` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,\r\n" + 
					"  `mediaAccelX` float NOT NULL,\r\n" + 
					"  `mediaAccelY` float NOT NULL,\r\n" + 
					"  `mediaAccelZ` float NOT NULL,\r\n" + 
					"  `rmsAccelX` float NOT NULL,\r\n" + 
					"  `rmsAccelY` float NOT NULL,\r\n" + 
					"  `rmsAccelZ` float NOT NULL,\r\n" + 
					"  `mediaGyroX` float NOT NULL,\r\n" + 
					"  `mediaGyroY` float NOT NULL,\r\n" + 
					"  `mediaGyroZ` float NOT NULL,\r\n" + 
					"  `rmsGyroX` float NOT NULL,\r\n" + 
					"  `rmsGyroY` float NOT NULL,\r\n" + 
					"  `rmsGyroZ` float NOT NULL\r\n" + 
					")";
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


