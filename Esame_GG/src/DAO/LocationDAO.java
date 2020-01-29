package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Controller.Controller;
import Entità.Location;
import Entità.Utente;

public class LocationDAO {
    Controller controller;

    public LocationDAO(Controller ctrl) {
	controller = ctrl;
    }

    public ArrayList<Location> getLocations(String tipologia, String comune, String nome) {

	boolean SqlInjectionRisk=false;
	String query = "SELECT * FROM location";
	ArrayList<Location> locations = new ArrayList<Location>();

	if(!tipologia.equals("Tutti") && comune.equals("Tutti") && nome.equals("")) {
	    query = query+" WHERE tipo_location='"+tipologia+"'";

	}else if(tipologia.equals("Tutti") && !comune.equals("Tutti") && nome.equals("")) {
	    query = query+" JOIN residenza on residenza.comune='"+comune+"' AND location.cod_res=residenza.cod_residenza";

	}else if(tipologia.equals("Tutti") && comune.equals("Tutti") && !nome.equals("")) {
	    SqlInjectionRisk=true;
	    query = query+" WHERE nome= ?";

	}else if(!tipologia.equals("Tutti") && !comune.equals("Tutti") && nome.equals("")) {
	    query = query+" JOIN residenza on residenza.comune='"+comune+"' AND location.cod_res=residenza.cod_residenza WHERE tipo_location='"+tipologia+"'";

	}else if(!tipologia.equals("Tutti") && comune.equals("Tutti") && !nome.equals("")) {
	    SqlInjectionRisk=true;
	    query = query+" WHERE tipo_location='"+tipologia+"'"+" AND nome= ?";

	}else if(tipologia.equals("Tutti") && !comune.equals("Tutti") && !nome.equals("")) {
	    SqlInjectionRisk=true;
	    query = query+" JOIN residenza on residenza.comune='"+comune+"'  AND location.cod_res=residenza.cod_residenza WHERE nome= ?";

	}else if(!tipologia.equals("Tutti") && !comune.equals("Tutti") && !nome.equals("")) {
	    SqlInjectionRisk=true;
	    query = query+" JOIN residenza on residenza.comune='"+comune+"' WHERE nome= ? AND tipo_location='"+tipologia+"'";

	}


	try {

	    PreparedStatement getLoc = controller.getConnection().prepareStatement(query);

	    if(SqlInjectionRisk) {
		getLoc.setString(1, nome);
	    }

	    ResultSet rs = getLoc.executeQuery();

	    while(rs.next()) {
		Location loc = new Location(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
		locations.add(loc);
	    }

	    rs.close();
	    getLoc.close();

	} catch (SQLException e) {
	    e.printStackTrace();
	}

	return locations;
    }

    public Location getLocationFromID(String ID) {

	Location location=null;
	String query="SELECT * FROM location WHERE cod="+ID;

	try {
	    PreparedStatement getLoc = controller.getConnection().prepareStatement(query);
	    ResultSet rs = getLoc.executeQuery();

	    while(rs.next()) {
		location = new Location(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}

	return location;
    }
}

