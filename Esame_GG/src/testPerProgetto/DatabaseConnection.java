package testPerProgetto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
private static Connection connect;

    private DatabaseConnection() {}


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
        String user = "C##Utente";
        String Password = "OracleADMIN";

        connect = DriverManager.getConnection(url,user,Password);
        System.out.println("Connessione al database riuscita.");
  }


  return connect;
    }


    public static Connection Disconnessione () throws SQLException{

  System.out.println("Chiusura connessione...");
  connect.close();
  System.out.println("Chiusura riuschita.");

  return connect;
    }

}