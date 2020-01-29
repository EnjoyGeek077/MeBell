package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Attrazione.Attrazione;
import Controller.Controller;
import Entità.Location;

public class AttrazioneDAO {
	
	Controller controller;
	
	public AttrazioneDAO(Controller ctrl) {
		controller=ctrl;
	}
	
	public Attrazione getAttrazione(String cod,Location mainLoc) {
		String query = "SELECT * FROM attrazione WHERE cod=?";
		Attrazione att=null;
		
		try {
			PreparedStatement getAttrazion = controller.getConnection().prepareStatement(query);
			getAttrazion.setString(1, cod);
			ResultSet rs = getAttrazion.executeQuery();
			
			while(rs.next()) {
				att = new Attrazione(mainLoc,rs.getString(2),rs.getString(3));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return att;
	}
	

}
