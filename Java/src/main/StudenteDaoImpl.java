package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class StudenteDaoImpl implements StudenteDao{

	private Connection conn;
	
	public StudenteDaoImpl() {
		try {
			Class.forName("org.postgresql.Driver");
		}
		catch(ClassNotFoundException e) {
			System.err.println("Classe non trovata");
		}
		
		String url = "jdbc:postgresql://localhost/test";
		Properties props = new Properties();
		props.setProperty("user","postgres");
		props.setProperty("password","admin");

		 conn = null;
		

		try {
			conn = DriverManager.getConnection(url, props);			
		}catch (Exception e) {
			System.err.println("errore di connessione");
		}
	}
	
	
	@Override
	public List<Studente> getAllStudent() {
		try {
			Statement st = conn.createStatement();
			String query ="select * from studente";
			ResultSet rs = st.executeQuery(query);
			ArrayList<Studente> l = new ArrayList<Studente>();
			while (rs.next()) {
				Studente s = new Studente();
				s.setNome(rs.getString("nome"));
				l.add(s);
			}
			
			return l;
		}
		catch (SQLException e ) {
			System.err.println("sql exception");
			return null;
		}		
		
	}

}
