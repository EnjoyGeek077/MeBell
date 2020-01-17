package testPerProgetto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
private Connection conn=null;

	
	public Connection getConnection() {
		if(conn==null) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				Properties props = new Properties();
				props.setProperty("user","C##Utente");
				props.setProperty("password","OracleADMIN");
				
				conn = DriverManager.getConnection(url,props);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return conn;
	}
}
