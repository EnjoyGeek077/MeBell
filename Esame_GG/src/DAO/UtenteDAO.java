package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Connessione.DatabaseConnection;
import Controller.Controller;
import Entità.Utente;


public class UtenteDAO {
	Controller controller;
	
	public UtenteDAO(Controller ctrl) {
		controller = ctrl;
	}

    	public void inserisciUtente(Utente utente) throws SQLException {
	    
		String query ="INSERT into utente values(?,?,?,?)";
		
			try {
			    
				PreparedStatement inserisciUtente = controller.getConnection().prepareStatement(query);
				inserisciUtente.setString(1, utente.getUsername());
				inserisciUtente.setString(2, utente.getNome());
				inserisciUtente.setString(3, utente.getCognome());
				inserisciUtente.setString(4, utente.getPassword());
				inserisciUtente.executeUpdate();
				
			} catch (SQLException e) {
				throw(e);
			}
	}
	
	public Utente trovaUtente(String user) {
	    
		String query = "SELECT * FROM utente WHERE username = ?";
		
		try {
		    
			PreparedStatement inserisciUtente = controller.getConnection().prepareStatement(query);
			inserisciUtente.setString(1, user);
			ResultSet rs = inserisciUtente.executeQuery();

			while(rs.next()) {
				Utente usr = new Utente(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
				return usr;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

}