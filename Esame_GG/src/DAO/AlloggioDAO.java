package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Alloggio.Alloggio;
import Controller.Controller;
import Entità.Location;

public class AlloggioDAO {
	
	Controller controller;
	
	public AlloggioDAO(Controller ctrl) {
		controller=ctrl;
	}
	public Alloggio getAlloggio(String cod, Location mainLoc) {
		String query = "SELECT * FROM attrazione WHERE cod=?";
		Alloggio att=null;

		try {
		    PreparedStatement getAttrazione = controller.getConnection().prepareStatement(query);
		    getAttrazione.setString(1, cod);
		    ResultSet rs = getAttrazione.executeQuery();

		    while(rs.next()) {
			att = new Alloggio(mainLoc,null, rs.getInt(2), rs.getString(3));
		    }

		} catch (SQLException e) {
		    e.printStackTrace();
		}


		return att;
	    }
	
}
