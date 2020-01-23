package Controller;

import java.sql.Connection;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Connessione.DatabaseConnection;
import DAO.LocationDAO;
import DAO.UtenteDAO;
import Entità.Location;
import Entità.Utente;
import Swing.Login;
import Swing.Register;

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
		UtenteDAO utenteDAO = new UtenteDAO(this);
		try {
			utenteDAO.inserisciUtente(utente);
			JOptionPane.showMessageDialog(null, "Registrazione effettuata con successo");
			
		} catch (SQLIntegrityConstraintViolationException e) {
			JOptionPane.showMessageDialog(null, "Il nome utente risulta già registrato", "Error", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Errore con il database", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void loginTry(String user, String pass) {
		UtenteDAO stdDAO = new UtenteDAO(this);
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

	
	public boolean controlloPass(JPasswordField passField) {
	    
	    String password = new String(passField.getPassword());
	    Pattern path = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,15})");
	    Matcher m = path.matcher(password);
	    boolean controllo = m.matches();
	    return controllo;
	}
	
	public boolean controlloUsername(JTextField utenteField) {
	    
	    String Username = utenteField.getText();
	    Pattern path = Pattern.compile("^[a-zA-Z0-9_-]{3,15}$");
	    Matcher m = path.matcher(Username);
	    boolean controllo = m.matches();
	    return controllo;
	   
	}
	
	public void GetLocations(String tipologia,String xx,String cod) {
		LocationDAO locDAO = new LocationDAO(this);
		locDAO.GetLocations(tipologia,xx,cod);
		
		
	}
	
//Get connessione
	public Connection getConnection() {
	    
	    try {

		if(DatabaseConnection.getConnect()==null) {
		    return DatabaseConnection.Connessione();
		}else {
		    return DatabaseConnection.getConnect();
		}

	    } catch (SQLException e) {
		JOptionPane.showMessageDialog(null, "Connessione non riuscita. Controllare il collegamento", "Errore SQL", JOptionPane.ERROR_MESSAGE);
		return null;
	    }	
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