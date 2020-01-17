package sql_robbe;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ArticoloDAO {
	Driver controller;
	
	public ArticoloDAO(Driver ctrl) {
		controller = ctrl;
	}
	public Articolo getArticoloByCod(Connection conn, String cod) {
		
			Statement st;
			ResultSet rs = null;
			try {
				PreparedStatement pst = conn.prepareStatement("SELECT * FROM Articolo where codice = ?;");
				pst.setString(1, cod);
				rs = pst.executeQuery();
				if(rs.next()) {
					if(rs.getString(2)==null) {
						Articolo s = new Articolo(rs.getString(1));
						return s;
					}else {
						Videogame s = new Videogame(rs.getString(1),rs.getString(2)); 
						return s;
					}
					
					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
		
	
	public boolean saveArticolo(Connection conn,Videogame a) {
		Statement st;
		try {
			PreparedStatement pst = conn.prepareStatement("Insert into Articolo values (?,?);");
			pst.setString(1,a.getCodice());
			pst.setString(2,a.getTitolo());
			pst.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
		}
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
