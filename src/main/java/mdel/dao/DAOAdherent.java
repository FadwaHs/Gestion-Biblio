package mdel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Vector;

import model.bo.Adherent;
import model.bo.Livre;

public class DAOAdherent implements IDAOAdherent
{

	@Override
	public boolean create(Adherent A) {
		try
        {
          PreparedStatement st = Connexion.getCon().prepareStatement("insert into Adherent values(?,?,?,?,?)");
          st.setString(1,A.getCin());
          st.setString(2, A.getNom());
          st.setString(3, A.getPrenom());
          st.setString(4, A.getMdp());
          st.setString(5, A.getTele() );
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
	public Collection<Adherent> retreive() {
		
     Vector<Adherent> AD = new  Vector<Adherent>();
		 
         try
         { 
              
              PreparedStatement st = Connexion.getCon().prepareStatement("select * from  Adherent ");
              //cursor ResultSet
              ResultSet rs = st.executeQuery();
              while(rs.next())
              {
                 AD.add( new Adherent(rs.getString("CIN"),rs.getString("nom"),rs.getString("prenom"),rs.getString("Mdp"),rs.getString("tele") )); 
              }
         }
         catch(SQLException e)
         {
             return null;
         }
        
         return AD; 
	}

	@Override
	public Collection<Adherent> retreive(String CIN) {
		
		 Vector<Adherent> AD = new  Vector<Adherent>();
		 
		 try
         { 
              
              PreparedStatement st = Connexion.getCon().prepareStatement("select * from  Adherent where CIN = ? ");
              st.setString(1, CIN);
              //cursor ResultSet
              ResultSet rs = st.executeQuery();
              while(rs.next())
              {
                 AD.add( new Adherent(rs.getString("CIN"),rs.getString("nom"),rs.getString("prenom"),rs.getString("Mdp"),rs.getString("tele") )); 
              }
         }
         catch(SQLException e)
         {
             return null;
         }
        
         return AD; 
	}

	@Override
	public boolean update(Adherent A) {
		
		return false;
	}

	@Override
	public boolean delete(String CIN) {
		
		 try {
	            
	           String delete = "delete from Adherent where Adherent.CIN = ?";
	           PreparedStatement st = Connexion.getCon().prepareStatement(delete);
	           st.setString(1,CIN);
	           st.execute();
	           
	         return true;
	         
	        } catch (SQLException ex) {
	           
	            return false;
	        }
	        
		
	}

}
