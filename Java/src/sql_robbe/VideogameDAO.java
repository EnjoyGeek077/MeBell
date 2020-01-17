package sql_robbe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class VideogameDAO extends ArticoloDAO{
	public VideogameDAO(Driver ctrl) {
		super(ctrl);
		// TODO Auto-generated constructor stub
	}

	Driver controller;
	
	

	
	public Articolo getArticoloByCod(Connection conn, String cod) {
		
			Statement st;
			ResultSet rs = null;
			try {
				PreparedStatement pst = conn.prepareStatement("SELECT * FROM Articolo where codice = ?;");
				pst.setString(1, cod);
				rs = pst.executeQuery();
				if(rs.next()) {
					Videogame s = new Videogame(rs.getString(1), rs.getString(2));
					return s;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
		
	
	public boolean saveArticolo(Articolo a) {
		//salva s in maniera persist
		return false;
	}
	
	public boolean updateArticolo(Articolo a) {
		//aggiorna a su disco
		return false;
	}
	
	public boolean deleteArticolo(Articolo a) {
		//rimuovi a da disco
		return false;
	}
	
	public ArrayList<Articolo> getArticoli(){
		
		return null;
	}
}
