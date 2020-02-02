package Controller;

import java.awt.Color;
import java.awt.Image;
import java.lang.reflect.Array;
import java.sql.Connection;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Alloggio.Alloggio;
import Alloggio.ServiziAlloggio;
import Attrazione.Attrazione;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Connessione.DatabaseConnection;
import DAO.*;

import Entità.*;
import Swing.HomePage;
import Swing.LocationPage;
import Entità.Location;
import Entità.Utente;
import Ristorazione.Braceria;
import Ristorazione.Pizzeria;
import Ristorazione.Ristorazione;
import Ristorazione.SushiBar;
import Swing.Login;
import Swing.Register;
import Swing.VediRecensioni;
import SwingDialog.EliminaRecensione;
import SwingDialog.InserisciRecensione;
import SwingDialog.ModificaRecensione;
import Utility.ModelloTabella;

public class Controller {
	Login login;
	Register register;
	HomePage homepage;
	LocationPage locationpage;
	VediRecensioni vedirecensioni;

	EliminaRecensione eliminarecensione;
	ModificaRecensione modificarecensione;
	InserisciRecensione inseriscirecensione;

	ModelloTabella model;

	private Utente utente=null;
	private String IDlocationScelta;
	private Location locationDaVedere;
	private int filtroMediaVoto;
	private ArrayList<Location> location;	
	private ArrayList<Residenza> residenze;

	public static void main(String[] args) {

		Controller ctrl = new Controller();

	}

	public Controller() {

		login = new Login(this);
		login.setVisible(true);
		register = new Register(this);
		homepage = new HomePage(this);
		locationpage = new LocationPage(this);
		vedirecensioni = new VediRecensioni(this);

		eliminarecensione = new EliminaRecensione(this);
		modificarecensione = new ModificaRecensione(this);
		inseriscirecensione = new InserisciRecensione(this);

		location = new ArrayList<Location>();

	}

	//-------------------------------------------------------------------------------------------------


	public void aggiungiUtente(String user, String first, String last, String pass) {
		Utente utente = new Utente(user,first,last,pass);
		UtenteDAO utenteDAO = new UtenteDAO(this);
		try {
			utenteDAO.inserisciUtente(utente);
			JOptionPane.showMessageDialog(null, "Registrazione avvenuta con successo", "Esito registrazione", JOptionPane.INFORMATION_MESSAGE);

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
			JOptionPane.showMessageDialog(null, "Login effettuato, ciao"+" "+this.utente.getUsername(), "Esito login", JOptionPane.INFORMATION_MESSAGE);	
			login.setVisible(false);
			homepage.setVisible(true);
		}else {
			JOptionPane.showMessageDialog(null, "Username o password errate", "Errore", JOptionPane.ERROR_MESSAGE);
			utente=null;
		}
	}

	public boolean isPassEqual(char[] password, char[] password2) {
		String psw = new String(password);
		String psw2 = new String(password2);
		if(psw.equals(psw2)) {
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

	public void getFilterLocation(String tipologia, String comune, String nome, int mediaVoto) {

		LocationDAO locDAO = new LocationDAO(this);
		ResidenzaDAO resDAO = new ResidenzaDAO(this);

		this.filtroMediaVoto=mediaVoto;
		this.residenze=resDAO.getResidenze(comune);
		this.location=locDAO.getLocations(tipologia, comune, nome);
	}


	public void aggiornaTable(DefaultTableModel modello) {

		int filtro= this.filtroMediaVoto;
		float media = 0.0f;

		RecensioneDAO recDAO = new RecensioneDAO(this);
		modello.getDataVector().removeAllElements();

		for(Location l : location) {

			for(Residenza r : residenze) {

				if(l.getCod_residenza().equals(r.getCod_res())) {

					media=recDAO.getMediaVotoLocale(l.getCod());

					if(media<=filtro) {

						if(l.getTipo().equals("Alloggio")) {
							Icon Icona = new ImageIcon(getClass().getResource("/Icons/HotelICON.png"));
							JLabel labelIMG = new JLabel();
							labelIMG.setIcon(Icona);

							modello.addRow(new Object[] {labelIMG,l.getCod(),l.getNome(),r.getVia(),r.getComune(),media});

						}else if(l.getTipo().equals("Attrazione")) {
							Icon Icona = new ImageIcon(getClass().getResource("/Icons/AttrazioneICON.png"));
							JLabel labelIMG = new JLabel();
							labelIMG.setIcon(Icona);

							modello.addRow(new Object[] {labelIMG,l.getCod(),l.getNome(),r.getVia(),r.getComune(),media});

						}else if(l.getTipo().equals("Ristorante")) {
							Icon Icona = new ImageIcon(getClass().getResource("/Icons/RestaurantICON.png"));
							JLabel labelIMG = new JLabel();
							labelIMG.setIcon(Icona);

							modello.addRow(new Object[] {labelIMG,l.getCod(),l.getNome(),r.getVia(),r.getComune(),media});

						}
					}
				}
			}
		}


		modello.fireTableDataChanged();

	}

	public boolean getLocationFromTable(JTable tabella) {

		String cod_locale;
		int rowSelected;

		if(!tabella.getSelectionModel().isSelectionEmpty()) {

			rowSelected=tabella.getSelectedRow();
			cod_locale=(String) tabella.getValueAt(rowSelected, 1);
			this.setLocationScelta(cod_locale);
			this.homepage.setVisible(false);
			this.openLocationPage();
			return true;

		}else {
			JOptionPane.showMessageDialog(null, "Selzeziona una riga", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}

	public ArrayList<String> getComuni() {
		ResidenzaDAO resDAO = new ResidenzaDAO(this);
		return resDAO.getAllComuni();
	}

	public void getLocationInformation() {

		LocationDAO locDAO = new LocationDAO(this);
		ResidenzaDAO resDAO = new ResidenzaDAO(this);
		RecensioneDAO recDAO = new RecensioneDAO(this);
		this.locationDaVedere=locDAO.getLocationFromID(IDlocationScelta);
		this.locationDaVedere.setResidenzaLocation(resDAO.getResidenzaFromID(this.locationDaVedere.getCod_residenza()));
		this.locationDaVedere.setRecensiondiLocation(recDAO.getAllRecensioniDiLocation(IDlocationScelta));

	}

	public float getMediaRecensioni() {
		int i = 0;
		float media = 0.0f;

		if(!this.locationDaVedere.getRecensiondiLocation().isEmpty()){

			for(Recensione r : this.locationDaVedere.getRecensiondiLocation()) {
				i++;
				media=media+r.getVoto();	    
			}

			media=media/i;
		}
		return media;
	}

	public void aggiornaLocationPage(){
		if(this.locationDaVedere.getTipo().equals("Alloggio")) {

			this.setAlloggioLabel();

		}else if(this.locationDaVedere.getTipo().equals("Attrazione")) {

			this.setAttrazioneInLabel();

		}else if(this.locationDaVedere.getTipo().equals("Ristorante")) {

			this.setRistorazioneInLabel();

		}

	}

	private void setAlloggioLabel() {

		AlloggioDAO allDAO = new AlloggioDAO(this);
		ServiziAlloggioDAO serviziAll = new ServiziAlloggioDAO(this);
		Alloggio all = allDAO.getAlloggio(this.locationDaVedere);
		ServiziAlloggio serviziAlloggio = serviziAll.getAlloggio(this.IDlocationScelta, this.locationDaVedere);
		all.setServiziAlloggio(serviziAlloggio);

		Object alloggioSpecializzato = this.getAlloggiosSpecializzato(all, allDAO);

		locationpage.setLocationPage(all.getNome(), all.getTipo()+", "+all.getTipoAlloggio(), all.getResidenzaLocation().toString(), all.getPartitaIva(), this.getMediaRecensioni(), all.getDescrizione(), alloggioSpecializzato.toString(), all.getServiziAlloggio().toString());
	}

	private void setRistorazioneInLabel() {

		RistorazioneDAO ristDAO = new RistorazioneDAO(this);
		Ristorazione rist = ristDAO.getRistorazione(locationDaVedere);
		this.setAttributiTipoRistorazione(rist, ristDAO);

		String informazioni="Informazioni: \nNumero posti: "+rist.getnPosti()+", Prezzo medio:"+rist.getPrezzoMedio();
	        locationpage.setLocationPage(rist.getNome(), rist.getTipo()+", "+rist.getTipoRistorazione().replace("Elenco completo", "Braceria, Pizzeria, Sushi Bar"), rist.getResidenzaLocation().toString(), rist.getPartitaIva(), this.getMediaRecensioni(), rist.getDescrizione(),informazioni , rist.toString());
	}

	private void setAttrazioneInLabel() {

		AttrazioneDAO attDAO = new AttrazioneDAO(this);
		Attrazione att = attDAO.getAttrazione(this.IDlocationScelta, this.locationDaVedere);

		String pagamento;

		if(att.isPagamento()) {
			pagamento="L'attrazione è a pagamento.";
		}else {
			pagamento="L'attrazione non è a pagamento.";
		}

		locationpage.setLocationPage(att.getNome(), att.getTipo()+", "+att.getTipoAttrazione(), att.getResidenzaLocation().toString(), att.getPartitaIva(), this.getMediaRecensioni(), att.getDescrizione(), pagamento, "Nessun servizio");
	}

	public void setAttributiTipoRistorazione(Ristorazione ristorante, RistorazioneDAO ristoranteDaSpecificare) {

		String tipoRistorante=ristorante.getTipoRistorazione();
		Braceria brace = ristoranteDaSpecificare.getBraceria(ristorante);
		Pizzeria pizza = ristoranteDaSpecificare.getPizzeria(ristorante);
		SushiBar sushibar = ristoranteDaSpecificare.getSushiBar(ristorante);

		ristorante.setBraceria(brace);
		ristorante.setPizzeria(pizza);
		ristorante.setSushiBar(sushibar);

		/*if(tipoRistorante.equals("Elenco Completo")) {

	}else if(tipoRistorante.equals("Braceria")) {

	}else if(tipoRistorante.equals("SushiBar")) {

	}else if(tipoRistorante.equals("Pizzeria")) {

	}else if(tipoRistorante.equals("Brace e Sushi")) {

	}else if(tipoRistorante.equals("Pizza e Brace")) {

	}else if(tipoRistorante.equals("Pizza e Sushi")) {

	}*/

	}

	public Object getAlloggiosSpecializzato(Alloggio alloggioScelto, AlloggioDAO alloggioDaSpecificare) {

		Object tipoAlloggio = null;

		if(alloggioScelto.getTipoAlloggio().equals("Hotel")) {
			tipoAlloggio=alloggioDaSpecificare.getAlloggioHotel(alloggioScelto);

		}else if(alloggioScelto.getTipoAlloggio().equals("BeB")) {
			tipoAlloggio=alloggioDaSpecificare.getAlloggioBeB(alloggioScelto);

		}else if(alloggioScelto.getTipoAlloggio().equals("Appartamento")) {
			tipoAlloggio=alloggioDaSpecificare.getAlloggioAppartamento(alloggioScelto);

		}

		return tipoAlloggio;
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
			JOptionPane.showMessageDialog(null, "Connessione non riuscita, controllare il collegamento", "Errore SQL", JOptionPane.ERROR_MESSAGE);
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

	//Getter e setter location scelta
	public String getLocationScelta() {
		return IDlocationScelta;
	}

	public void setLocationScelta(String locationScelta) {
		this.IDlocationScelta = locationScelta;
	}

	//Getter e setter filtro media voto
	public int getFiltroMediaVoto() {
		return filtroMediaVoto;
	}

	public void setFiltroMediaVoto(int filtroMediaVoto) {
		this.filtroMediaVoto = filtroMediaVoto;
	}

	//Getter e setter location da vedere
	public Location getLocationDaVedere() {
		return locationDaVedere;
	}

	public void setLocationDaVedere(Location locationDaVedere) {
		this.locationDaVedere = locationDaVedere;
	}


	//Reset e utility
	public void resetCampiReg(JTextField textFirstN, JTextField textLastN, JTextField textUserN, JPasswordField passwordField, JPasswordField passwordFieldR) {

		textFirstN.setText("");
		textLastN.setText("");
		textUserN.setText("");
		passwordField.setText("");
		passwordFieldR.setText("");

	}

	public void resetControlliReg(boolean controlloUsername, boolean controlloPassword, JLabel controlloUser, JLabel  controlloPass) {

		controlloUsername=false;
		controlloPassword=false;

		controlloUser.setForeground(Color.BLACK);
		controlloUser.setText("Il campo conterrà una lunghezza da 3 a 15 char alfanumerici.");

		controlloPass.setForeground(Color.BLACK);
		controlloPass.setText("Il campo conterrà A-Z, a-z, 0-9 e almeno un @#$%.");

	}

	public void setCellNotEditable(JTable tabella, ModelloTabella modello) {

		int indice_riga;
		int indice_colonna;

		indice_riga=tabella.getSelectedRow();
		indice_colonna=tabella.getSelectedColumn();
		modello.isCellEditable(indice_riga, indice_colonna);

	}

	//Open frame

	public void openRegister() {
		register.setVisible(true);
	}
	public void openLogin() {
		login.setVisible(true);
	}
	public void openHomePage() {
		homepage.setVisible(true);
	}
	public void openLocationPage() {
		locationpage.setVisible(true);
	}
	public void openVediRecensioni() {
		vedirecensioni.setVisible(true);
	}
	public void openEliminaDialog() {
		eliminarecensione.setVisible(true);
	}
	public void openModificaDialog() {
		modificarecensione.setVisible(true);
	}
	public void openInserisciDialog() {
		inseriscirecensione.setVisible(true);
	}
}