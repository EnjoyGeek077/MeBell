package sql_robbe;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class InterfacciaSql {
	Driver controller;
	Connection conn = null;
	public InterfacciaSql(Driver ctrl) {
		controller = ctrl;
		
	}
	
	public void getConnection() {
		if(conn==null) { //Conviene sempre usare private e get e set anche per la connessione al database
			try {
				Class.forName("org.postgresql.Driver");
				String url = "jdbc:postgresql://localhost/postgres";
				Properties props = new Properties();
				props.setProperty("user","postgres");
				props.setProperty("password","fedegar");
				
				conn = DriverManager.getConnection(url,props);
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			
		}
	}
	public ResultSet selectStatment() {
		Statement st;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery("SELECT * FROM Articolo;");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	

}
