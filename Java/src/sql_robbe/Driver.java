package sql_robbe;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;;

public class Driver {
static InterfacciaSql intSql;
static Driver controller;
ArticoloDAO ADAO;
VideogameDAO VDAO;
FrameRicercaOgetto frameR;
	public static void main(String[] args) {
		controller = new Driver();
		intSql = new InterfacciaSql(controller);
		
		try {
			intSql.getConnection();
			
			ResultSet rs = intSql.selectStatment();
			while(rs.next()) {
				System.out.println(rs.getString("codice")+" "+rs.getString("titolo"));
			}
			//Articolo a= intSql.selectStatmentPrepared("mela");
			//System.out.println(a.getCodice());
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	public Driver() {
		ADAO = new ArticoloDAO(this);
		VDAO = new VideogameDAO(this);
		frameR = new FrameRicercaOgetto(this);
		frameR.setVisible(true);
	}
	public Articolo ricercaOgetto(String cod) {
		return ADAO.getArticoloByCod(intSql.conn,cod );
		
	}
	public Articolo ricercaVideogame(String cod) {
		return ADAO.getArticoloByCod(intSql.conn,cod );
		
	}
	public void AggiungiNuovo(String string, String string2) {
		Videogame a = new Videogame();
		a.setCodice(string);
		a.setTitolo(string2);
		ADAO.saveArticolo(intSql.conn, a);
		
	}
}
