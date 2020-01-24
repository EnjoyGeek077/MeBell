package DAO;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import Controller.Controller;

public class RecensioneDAO {
    Controller controller;
    
    public RecensioneDAO(Controller ctrl) {
  	controller = ctrl;
      }
    
    public float getMediaVotoLocale(String codLocale) {
	
	String query="Select AVG(voto) from recensione where cod_locale='"+codLocale+"'";
	float mediaLocale=0.0f;
	
	try {
	    
	    PreparedStatement getRes= controller.getConnection().prepareStatement(query);
	    ResultSet rs = getRes.executeQuery();
	   
	    while(rs.next()) {
		mediaLocale=rs.getFloat(1);
	    }
	    
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	
	return mediaLocale;
    }

}
