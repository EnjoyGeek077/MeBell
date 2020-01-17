package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import testPerProgetto.DatabaseConnection;


public class UtenteDAO {
	
	public void inserisciUser(Utente utente) throws SQLException {
		Connection conn = null;
		String query ="INSERT into utente values(?,?,?,?)";
			try {
				conn=DatabaseConnection.Connessione();
				PreparedStatement inserisciUtente = conn.prepareStatement(query);
				inserisciUtente.setString(1, utente.getNickname());
				inserisciUtente.setString(2, utente.getNome());
				inserisciUtente.setString(3, utente.getCognome());
				inserisciUtente.setString(4, utente.getPassword());
				inserisciUtente.executeUpdate();
			} catch (SQLException e) {
				throw(e);
			}
	}
	public Utente trovaUtente(String user) {
		Connection conn = null;
		String query = "SELECT * FROM utente WHERE username = ?";
		try {
			conn=DatabaseConnection.Connessione();
			PreparedStatement inserisciUtente = conn.prepareStatement(query);
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
