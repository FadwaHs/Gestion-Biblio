package mdel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Vector;

import model.bo.Adherent;
import model.bo.Exemplaire;
import model.bo.Livre;

public class DAOExemplaire implements IDAOExemplaire
{

	@Override
	public Integer getnumberExemplaire(Livre L) {
		try
        {
	      int count=0;
          PreparedStatement st = Connexion.getCon().prepareStatement("select count(*) from exemplaire where ISBN= ? and ETAT=0");
          st.setString(1,L.getIsbn());
          ResultSet rs = st.executeQuery();
          while(rs.next())
          {
        	   count = rs.getInt(1);    
          }
  
          return count;
          
        }
        catch(SQLException e)
        {
             System.err.println(e.getMessage());
             
              return 1;
        }

	}
	
	@Override
	public Integer getnumberExemplaireA(Adherent A) {
		try
        {
	      int count=0;
          PreparedStatement st = Connexion.getCon().prepareStatement("select count(*) from emprunter where CIN= ?");
          st.setString(1, A.getCin());
          ResultSet rs = st.executeQuery();
          while(rs.next())
          {
        	   count = rs.getInt(1);    
          }
  
          return count;
          
        }
        catch(SQLException e)
        {
             System.err.println(e.getMessage());
             
              return 1;
        }
	}
	

	@Override
	public boolean create(Exemplaire E) {
		
		try
        {
          PreparedStatement st = Connexion.getCon().prepareStatement("insert into Exemplaire values(?,?,?)");
          st.setInt(1,E.getNoexp());
          st.setInt(2,0);
          st.setString(3,E.getLivres().getIsbn());
        
          st.execute();
          return true;
          
        }
        catch(SQLException e)

        {
             System.err.println(e.getMessage());
             
              return false;
        }
		
	}

	@Override
	public Collection<Exemplaire> retreive() {
		

	  Vector<Exemplaire> exmp = new  Vector<Exemplaire>();
		 
        try
        { 
             
             PreparedStatement st = Connexion.getCon().prepareStatement("select * from  Exemplaire ");
             //cursor ResultSet
             ResultSet rs = st.executeQuery();
             while(rs.next())
             {
            	Livre l = new Livre();
            	l.setIsbn( rs.getString("ISBN"));
            	 
                exmp.add(   new Exemplaire(rs.getInt("Noexp"),l,rs.getBoolean("Etat") )  );

             }
        }
        catch(SQLException e)
        {
            return null;
        }
       
        return exmp; 
		
		
		
	}

	@Override
	public Collection<Exemplaire> retreive(String ISBN) {
		
	  Vector<Exemplaire> exmp = new  Vector<Exemplaire>();
			 
	        try
	        { 
	             
	             PreparedStatement st = Connexion.getCon().prepareStatement("select * from  Exemplaire  where ISBN=?");
	             st.setString(1,ISBN);
	             //cursor ResultSet
	             ResultSet rs = st.executeQuery();
	             while(rs.next())
	             {
	            	Livre l = new Livre();
	            	l.setIsbn( rs.getString("ISBN"));
	            	 
	                exmp.add(   new Exemplaire(rs.getInt("Noexp"),l,rs.getBoolean("Etat") )  );

	             }
	        }
	        catch(SQLException e)
	        {
	            return null;
	        }
	       
	        return exmp; 
		
	}

	@Override
	public boolean delete(Integer noexp) {
		
		 try {
	            
	           String delete = "delete from Exemplaire where Exemplaire.Noexp = ? and Exemplaire.Etat=0";
	           PreparedStatement st = Connexion.getCon().prepareStatement(delete);
	           st.setInt(1,noexp);
	           st.execute();
	           
	         return true;
	         
	        } catch (SQLException ex) {
	           
	            return false;
	        }
	}



}
