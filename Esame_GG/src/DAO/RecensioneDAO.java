package DAO;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import Attrazione.Attrazione;
import Controller.Controller;
import Entità.Recensione;

public class RecensioneDAO {
    Controller controller;
    
    public RecensioneDAO(Controller ctrl) {
  	controller = ctrl;
      }
    
    public float getMediaVotoLocale(String codLocale) {
	
	
	float mediaLocale=0.0f;
	
	try {
	    
	    CallableStatement cst = controller.getConnection().prepareCall("{CALL getMediaVoto(?,?)}");
	    cst.registerOutParameter(2, Types.FLOAT);
	    cst.setString(1, codLocale);
	    cst.execute();
	    
	    mediaLocale = cst.getFloat(2);
	    cst.close();
	    
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	
	return mediaLocale;
    }
    
    public ArrayList<Recensione> getAllRecensioniDiLocatio(String ID){
	
	String query = "SELECT * FROM recensione WHERE cod=?";
	ArrayList<Recensione> recensioniLocation = new ArrayList<Recensione>();

	try {
	    PreparedStatement getRecensioni = controller.getConnection().prepareStatement(query);
	    getRecensioni.setString(1, ID);
	    ResultSet rs = getRecensioni.executeQuery();

	    while(rs.next()) {
		Recensione recensioneGet = new Recensione(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
		recensioniLocation.add(recensioneGet);
	    }

	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return null;
	
    }

}
