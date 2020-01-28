package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Controller.Controller;
import Entità.Location;
import Entità.Residenza;


public class ResidenzaDAO {
    Controller controller;

    public ResidenzaDAO(Controller ctrl) {
	controller = ctrl;
    }

    public ArrayList<Residenza> getResidenze(String comune){

	String query ="";
	ArrayList<Residenza> residenze_trovate = new ArrayList<Residenza>();

	if(comune.equals("Tutti")) {
	    query="SELECT * FROM residenza";  
	}else {
	    query="SELECT * FROM residenza WHERE comune='"+comune+"'";
	}

	try {

	    PreparedStatement getRes= controller.getConnection().prepareStatement(query);
	    ResultSet rs = getRes.executeQuery();

	    while(rs.next()) {
		Residenza res = new Residenza(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
		residenze_trovate.add(res);
	    }

	    rs.close();
	    getRes.close();

	} catch (SQLException e) {
	    e.printStackTrace();
	}

	return residenze_trovate;
    }

    public ArrayList<String> getAllComuni(){

	String query = "SELECT DISTINCT comune from residenza";
	ArrayList<String> Comuni = new ArrayList<String>();
	
	try {
	    PreparedStatement getCom;
	    getCom = controller.getConnection().prepareStatement(query);
	    ResultSet rs= getCom.executeQuery();

	    while(rs.next()) {

	    	String comuneDaAggiungere= rs.getString(1);
	    	Comuni.add(comuneDaAggiungere);

	    }
	    
	    rs.close();
	    getCom.close();

	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	return Comuni;

    }


}
