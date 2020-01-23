package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Controller.Controller;
import Entità.Location;
import Entità.Utente;

public class LocationDAO {
    Controller controller;

    public LocationDAO(Controller ctrl) {
	controller = ctrl;
    }

    public ArrayList<Location> GetLocations(String tipologia, String xx, String cod) {
	String query = "SELECT * FROM location";
	if(tipologia!=null && xx!=null) {
	    query=(query+" "+tipologia);
	}else if(tipologia!=null) {
	    query=(query+" "+tipologia);
	}else if(xx!=null){
	    query=(query+" "+xx);
	}

	ArrayList<Location> locations = new ArrayList<Location>();

	try {

	    PreparedStatement getLoc = controller.getConnection().prepareStatement(query);
	    //getLoc.setString(1, );
	    ResultSet rs = getLoc.executeQuery();

	    while(rs.next()) {
		Location loc = new Location(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
		locations.add(loc);

	    }

	} catch (SQLException e) {
	    e.printStackTrace();
	}

	return locations;
    }
}
