package mdel.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
	
	
	    private static Connection con;
	    private Connexion(){}
	     
	     public static Connection getCon(){
	     
	    try{
	        
	     if(con == null)
	     {
	             Class.forName("oracle.jdbc.driver.OracleDriver");
	             con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","HR");
	     }
	     
	     return con;   
	    }
	     catch(ClassNotFoundException e){
	       System.err.println(e.getMessage());
	       return null;
	       }
	       catch(SQLException e){
	       System.err.println(e.getMessage());
	       return null;
	       }
	       
	    }

}
