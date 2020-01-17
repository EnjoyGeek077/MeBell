package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class main {

	public static void main(String[] args) {
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

		Connection conn = null;
		

		try {
			conn = DriverManager.getConnection(url, props);
//			String user = "'; drop table utente --"; esempio di sql injection
//			String pass = "franco";
			String query = "Select * from studente s join corso_di_laurea c on(c.id=s.CDL)";
			
			
			PreparedStatement s = conn.prepareStatement(query);
			
//			codice per impostare i parametri di un prepared statement
//			s.setString(1, user);
//			s.setString(2, pass);
			
			
			ResultSet rs = s.executeQuery();
			ArrayList<Studente> list = new ArrayList<Studente>();
			ArrayList<CDL> listaCdl = new ArrayList<CDL>();
			
			//esempio di lettura del result set mapping nel mondo object oriented
			while( rs.next() ) {
				CDL corso = new CDL();
				corso.setDescrizione(rs.getString(1/*parametro di esempi*/));
				corso.setId(rs.getInt(2/*parametro di esempi*/));
				corso.setNome(rs.getString(3/*parametro di esempi*/));
				
				// nota bene: bisogna gestire anche il caso in cui il corso non sia già presente 
				// nella lista listaCdl
				if(listaCdl.contains(corso)) {
					CDL curr = listaCdl.get(listaCdl.indexOf(corso));
					Studente st =  new Studente();
					st.setMatricola(rs.getString("matricola"));
					st.setCognome(rs.getString("cognome"));
					st.setNome(rs.getString("nome"));
					curr.getStudenti().add(st);
				}
				
			}
			
		}
		catch(SQLException e) {
			System.err.println("errore Sql");
//			e.printStackTrace();
		}
	}

}
