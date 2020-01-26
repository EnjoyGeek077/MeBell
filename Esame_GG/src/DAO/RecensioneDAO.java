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

}
