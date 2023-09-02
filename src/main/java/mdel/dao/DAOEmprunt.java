package mdel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Vector;

import javax.swing.JOptionPane;

import model.bo.Adherent;
import model.bo.Emprunter;
import model.bo.EmprunterId;
import model.bo.Exemplaire;
import model.bo.Livre;

public class DAOEmprunt implements IDAOEmprunt{

	@Override
	public boolean create(Emprunter E) {
		
     int etat = 1;
     try
      {
		/// Check exmplaire

		PreparedStatement stmt = Connexion.getCon().prepareStatement("SELECT Etat FROM Exemplaire WHERE Noexp = ?");
	    stmt.setInt(1, E.getExemplaire().getNoexp());
	    ResultSet rs = stmt.executeQuery();
	    if (rs.next()) {
	    	
	       etat = rs.getInt("Etat");
	    }	
			
		if(etat == 0)
		{
			 //// Save :	
	          PreparedStatement st = Connexion.getCon().prepareStatement("insert into emprunter values(?,?,?,?)");
	          st.setInt(1,E.getId().getNoexp());
	          st.setString(2, E.getId().getCin());
	          st.setString(3,E.getId().getDatedebut() );
	          st.setString(4,E.getDatefin());
	          st.execute();
	          
	          //update Etat Exemplaire:
	          PreparedStatement stm =  Connexion.getCon().prepareStatement( "UPDATE Exemplaire SET Etat = ? WHERE Noexp = ?");
	          stm.setInt(1,1);
	          stm.setInt(2, E.getExemplaire().getNoexp());
	          stm.execute();
	          
	        
	          return true;	
		}
		else
		{
			
			return false;
		}
		
		 
          
        }
        catch(SQLException e)

        {
             System.err.println(e.getMessage());
             
              return false;
        }
	}

	@Override
	public Collection<Emprunter> retreive() {
		
     Vector<Emprunter> em = new  Vector<Emprunter>();
		 
         try
         { 
              
              PreparedStatement st = Connexion.getCon().prepareStatement("select * from  emprunter ");
              //cursor ResultSet
              ResultSet rs = st.executeQuery();
              while(rs.next())
              {
            	    EmprunterId id = new EmprunterId(rs.getInt("NOEXP"),rs.getString("cin"),rs.getString("DATEDEBUT"));
					
					Exemplaire Expl = new Exemplaire();
			        Expl.setNoexp(rs.getInt("NOEXP"));
			        
			        Adherent A = new Adherent();
			        A.setCin(rs.getString("cin"));
			        
			        Emprunter E = new Emprunter(id,Expl,A,rs.getString("DateFin"));
			        
			        em.add(E);
              }
         }
         catch(SQLException e)
         {
             return null;
         }
        
         return em; 
	}

	@Override
	public Collection<Emprunter> retreive(Adherent A) {
		// TODO Auto-generated method stub
		return null;
	}

}
