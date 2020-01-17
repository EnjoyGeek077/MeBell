package main;

import java.sql.Connection;

import swing.Login;
import swing.Register;
import testPerProgetto.DatabaseConnection;

public class Controller {
	Login log;
	Register register;
	DatabaseConnection datConn = new DatabaseConnection();

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
		return datConn.getConnection();
	}

	public void aggiungiUtente(String first, String last, String user, String string) {
		Utente utente = new Utente(first,last,user,string);
		UtenteDAO stdDAO = new UtenteDAO(this);
		stdDAO.inserisciStd(utente);
		register.setVisible(false);
		login();

	}


}
