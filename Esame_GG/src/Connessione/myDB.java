package Connessione;

import java.util.*;
import java.sql.*;

public class myDB {
    
    private static Connection connect;
    
    private myDB() {}
    
    
    public static Connection Connessione() throws SQLException {
	
	if(connect==null) {
	    
	    try {
		
		System.out.println("Connessione al DB...");
		Class.forName("oracle.jdbc.driver.OracleDriver");
	    
	    }catch(ClassNotFoundException e){
	    
		System.err.println("Errore, driver non trovato.");
	    	System.out.println(e.getMessage());
	    
	    }
	    	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	    	String user = "Utente";
	    	String Password = "OracleADMIN";
	    		
	    	connect = DriverManager.getConnection(url,user,Password);
	    	System.out.println("Connessione al database riuscita.");
	}
	
	   
	return connect;
    }
    
    
    public static Connection Disconnessione() throws SQLException{
	
	System.out.println("Chiusura connessione...");
	connect.close();
	System.out.println("Chiusura riuschita.");
	
	return connect;
    }
    
}
