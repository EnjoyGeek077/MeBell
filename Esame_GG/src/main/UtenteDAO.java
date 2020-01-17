package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UtenteDAO {
	private Connection conn;
	private Controller controller;
	
	
	public UtenteDAO(Controller ctrl) {
		controller = ctrl;
	}


	public void inserisciStd(Utente utente) {
		conn=controller.getConn();
		try {
			/*PreparedStatement inserisciUtente = conn.prepareStatement("INSERT into utente values(?,?,?,?);");
			inserisciUtente.setString(1,"'ciao'");//utente.getNome());
			inserisciUtente.setString(2, "'ciao'");//utente.getCognome());
			inserisciUtente.setString(3, "'ciao'");//utente.getNickname());
			inserisciUtente.setString(4, "'ciao'");//utente.getPassword());
			inserisciUtente.executeUpdate();*/
			Statement st = conn.createStatement();
			String query="SELECT * FROM utente;";
			ResultSet rs = st.executeQuery(query);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
