package main;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.swing.JOptionPane;

import swing.Login;
import swing.Register;
import testPerProgetto.DatabaseConnection;

public class Controller {
	Login log;
	Register register;
	DatabaseConnection datConn;
	private Utente utente=null;

	public static void main(String[] args) {
		Login frame = new Login();
		frame.setVisible(true);
		
	}
	
	public void registrati() {
		if(register==null) {
			register = new Register();
		}
		register.setVisible(true);
	}

	public void login() {
		if (log==null){
			log = new Login();
		}
		log.setVisible(true);
	}
	public Connection getConn() {
		try {
			return DatabaseConnection.Connessione();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	public void aggiungiUtente(String first, String last, String user, String pass) {
		Utente utente = new Utente(first,last,user,pass);
		UtenteDAO stdDAO = new UtenteDAO();
		try {
			stdDAO.inserisciUser(utente);
		} catch (SQLIntegrityConstraintViolationException e) {
			JOptionPane.showMessageDialog(null, "ERRORE", "Il nome utente risulta già registrato", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRORE");
		}
	}

	public void log(String user, String pass) {
		UtenteDAO stdDAO = new UtenteDAO();
		utente = stdDAO.trovaUtente(user);
		if (utente!=null && utente.getPassword().equals(pass)) {
			JOptionPane.showMessageDialog(null, "Log effettuato");
		}else {
			JOptionPane.showMessageDialog(null, "ERRORE", "Username o password errate", JOptionPane.ERROR_MESSAGE);
			utente=null;
		}
	}
	
	
	
//getter e setter
	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}
}
