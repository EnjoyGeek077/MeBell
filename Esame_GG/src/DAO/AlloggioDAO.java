package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Alloggio.Alloggio;
import Alloggio.Appartemento;
import Alloggio.BeB;
import Alloggio.Hotel;
import Controller.Controller;
import Entità.Location;

public class AlloggioDAO {

    Controller controller;

    public AlloggioDAO(Controller ctrl) {
	controller=ctrl;
    }

    public Alloggio getAlloggio(String cod, Location mainLoc) {
	String query = "SELECT * FROM alloggio WHERE cod=?";
	Alloggio alloggio=null;

	try {
	    PreparedStatement getAlloggio = controller.getConnection().prepareStatement(query);
	    getAlloggio.setString(1, cod);
	    ResultSet rs = getAlloggio.executeQuery();

	    while(rs.next()) {
		alloggio = new Alloggio(mainLoc, rs.getInt(2), rs.getString(3));
	    }

	    rs.close();
	    getAlloggio.close();

	} catch (SQLException e) {
	    e.printStackTrace();
	}

	return alloggio;
    }

    public Hotel getAlloggioHotel(Alloggio alloggio) {
	String query="SELECT * FROM hotel WHERE cod=?";
	Hotel hotel=null;

	try {
	    PreparedStatement getAttrazione = controller.getConnection().prepareStatement(query);
	    getAttrazione.setString(1, alloggio.getCod());
	    ResultSet rs = getAttrazione.executeQuery();

	    while(rs.next()) {
		hotel = new Hotel(alloggio, rs.getInt(2), rs.getInt(3), rs.getInt(4));
	    }

	    rs.close();
	    getAttrazione.close();

	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return hotel;

    }
    
    public BeB getAlloggioBeB(Alloggio alloggio) {
	String query="SELECT * FROM beb WHERE cod=?";
	BeB beb=null;

	try {
	    PreparedStatement getAttrazione = controller.getConnection().prepareStatement(query);
	    getAttrazione.setString(1, alloggio.getCod());
	    ResultSet rs = getAttrazione.executeQuery();

	    while(rs.next()) {
		beb = new BeB(alloggio, rs.getInt(2), rs.getInt(3), rs.getString(4));
	    }

	    rs.close();
	    getAttrazione.close();

	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return beb;

    }
    
    public Appartemento getAlloggioAppartamento(Alloggio alloggio) {
	String query="SELECT * FROM appartamento WHERE cod=?";
	Appartemento appartamento=null;

	try {
	    PreparedStatement getAttrazione = controller.getConnection().prepareStatement(query);
	    getAttrazione.setString(1, alloggio.getCod());
	    ResultSet rs = getAttrazione.executeQuery();

	    while(rs.next()) {
		appartamento = new Appartemento(alloggio,rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5));
	    }

	    rs.close();
	    getAttrazione.close();

	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return appartamento;

    }
}
