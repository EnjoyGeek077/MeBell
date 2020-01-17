package main;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.swing.JOptionPane;

import Connessione.DatabaseConnection;
import swing.Login;
import swing.Register;

public class Controller {
	Login login;
	Register register;
	
	private Utente utente=null;

	public static void main(String[] args) {
		
	    Controller ctrl = new Controller();
	    
	}
	
	public Controller() {
	  
	  login = new Login(this);
	  login.setVisible(true);
	  register = new Register(this);
	    
	}
	
//-------------------------------------------------------------------------------------------------


	public void aggiungiUtente(String first, String last, String user, String pass) {
		Utente utente = new Utente(first,last,user,pass);
		UtenteDAO stdDAO = new UtenteDAO();
		try {
			stdDAO.inserisciUtente(utente);
		} catch (SQLIntegrityConstraintViolationException e) {
			JOptionPane.showMessageDialog(null, "Il nome utente risulta già registrato", "Error", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Errore con il database", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void loginTry(String user, String pass) {
		UtenteDAO stdDAO = new UtenteDAO();
		utente = stdDAO.trovaUtente(user);
		if (utente!=null && utente.getPassword().equals(pass)) {
			JOptionPane.showMessageDialog(null, "Login effettuato");
		}else {
			JOptionPane.showMessageDialog(null, "Username o password errate", "Errore", JOptionPane.ERROR_MESSAGE);
			utente=null;
		}
	}
	
	public boolean isPassEqual(char[] password, char[] password2) {
		String psw = new String(password);
		String psw2 = new String(password2);
		if(psw.equals(psw2) && psw!="") {
			return true;
		}
		return false;
	}



//Getter e setter utente loggato
	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

//Open frame
	
	public void openRegister() {
	        register.setVisible(true);
	    }
	
	public void openLogin() {
	        login.setVisible(true);
	    }
	
	
}