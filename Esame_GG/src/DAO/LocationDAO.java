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
	
	if(!tipologia.equals("Tutti") && comune.equals("Tutti") && nome.equals("")) {
	    query = query+" WHERE tipo_location='"+tipologia+"'";
	}else if(tipologia.equals("Tutti") && !comune.equals("Tutti") && nome.equals("")) {
	    query = query+" JOIN residenza on residenza.comune='"+comune+"' AND location.cod_res=residenza.cod_residenza";
	}else if(tipologia.equals("Tutti") && comune.equals("Tutti") && !nome.equals("")) {
	    query = query+" WHERE nome='"+nome+"'";
	}else if(!tipologia.equals("Tutti") && !comune.equals("Tutti") && nome.equals("")) {
	    query = query+" JOIN residenza on residenza.comune='"+comune+"' AND location.cod_res=residenza.cod_residenza WHERE tipo_location='"+tipologia+"'";
	}else if(!tipologia.equals("Tutti") && comune.equals("Tutti") && !nome.equals("")) {
	    query = query+" WHERE tipo_location='"+tipologia+"'"+" AND nome='"+nome+"'";
	}else if(tipologia.equals("Tutti") && !comune.equals("Tutti") && !nome.equals("")) {
	    query = query+" JOIN residenza on residenza.comune='"+comune+"'  AND location.cod_res=residenza.cod_residenza WHERE nome='"+nome+"'";
	}else if(!tipologia.equals("Tutti") && !comune.equals("Tutti") && !nome.equals("")) {
	    query = query+" JOIN residenza on residenza.comune='"+comune+"' WHERE nome='"+nome+"' AND tipo_location='"+tipologia+"'";
	}
	ArrayList<Location> locations = new ArrayList<Location>();

	try {

	    PreparedStatement getLoc = controller.getConnection().prepareStatement(query);
	    ResultSet rs = getLoc.executeQuery();

	    if(rs!=null) {
		while(rs.next()) {
		    Location loc = new Location(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
		    locations.add(loc);
		}
	    }

	} catch (SQLException e) {
	    e.printStackTrace();
	}

	return locations;
    }
}
