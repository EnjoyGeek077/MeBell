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

    public ArrayList<Location> getLocations(String tipologia, String comune, String nome) {
	
	String query = "SELECT * FROM location";
	
	if(tipologia!="Tutti" && comune=="Tutti" && nome=="") {
	    query = query+" WHERE tipologia_location="+tipologia;
	}else if(tipologia=="Tutti" && comune!="Tutti" && nome=="") {
	    query = query+" JOIN residenza on residenza.comune="+comune;
	}else if(tipologia=="Tutti" && comune=="Tutti" && nome!="") {
	    query = query+" WHERE tipologia_location="+nome;
	}else if(tipologia!="Tutti" && comune!="Tutti" && nome=="") {
	    query = query+" JOIN residenza on residenza.comune="+comune+" WHERE tipologia_location="+tipologia;
	}else if(tipologia=="Tutti" && comune!="Tutti" && nome!="") {
	    query = query+" JOIN residenza on residenza.comune="+comune+" WHERE nome="+nome;
	}else if(tipologia!="Tutti" && comune!="Tutti" && nome!="") {
	    query = query+" JOIN residenza on residenza.comune="+comune+" WHERE nome="+nome+" AND tipologia_location="+tipologia;
	}

	ArrayList<Location> locations = new ArrayList<Location>();

	try {

	    PreparedStatement getLoc = controller.getConnection().prepareStatement(query);
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
