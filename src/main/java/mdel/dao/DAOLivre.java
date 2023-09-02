package mdel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Vector;

import model.bo.Livre;

public class DAOLivre  implements IDAOLivre
{

	@Override
	public boolean create(Livre L) {
		
		try
        {
          PreparedStatement st = Connexion.getCon().prepareStatement("insert into Livres values(?,?,?)");
          st.setString(1,L.getIsbn());
          st.setString(2, L.getTitre());
          st.setString(3, L.getCategory());
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
	public Collection<Livre> retreive() {
		
		 Vector<Livre> livre = new  Vector<Livre>();
		 
         try
         { 
              
              PreparedStatement st = Connexion.getCon().prepareStatement("select * from  Livres ");
              //cursor ResultSet
              ResultSet rs = st.executeQuery();
              while(rs.next())
              {
                 livre.add( new Livre(rs.getString("ISBN"),rs.getString("TITRE"),rs.getString("CATEGORY") )); 
              }
         }
         catch(SQLException e)
         {
             return null;
         }
        
         return livre; 
	}

	@Override
	public boolean update(Livre L) {
		
		 try {
	            
	           String updt = "update Livres set TITRE = ?,CATEGORY=? where ISBN = ?";
	           PreparedStatement st = Connexion.getCon().prepareStatement(updt);
	           st.setString(1,L.getTitre());
	           st.setString(2,L.getCategory());
	           st.setString(3, L.getIsbn());
	           st.execute();
	           
	         return true;
	         
	        } catch (SQLException ex) {
	           
	            return false;
	        }
	}

	@Override
	public boolean delete(String ISBN) {
		 try {
	            
	           String delete = "delete from Livres where Livres.ISBN = ?";
	           PreparedStatement st = Connexion.getCon().prepareStatement(delete);
	           st.setString(1,ISBN);
	           st.execute();
	           
	         return true;
	         
	        } catch (SQLException ex) {
	           
	            return false;
	        }
	        
	}

	@Override
	public Collection<Livre> retreive(String cat) {
    Vector<Livre> livre = new  Vector<Livre>();
		 
         try
         { 
              
              PreparedStatement st = Connexion.getCon().prepareStatement("select * from  Livres where CATEGORY=?");
              st.setString(1,cat);
              //cursor ResultSet
              ResultSet rs = st.executeQuery();
              while(rs.next())
              {
                 livre.add( new Livre(rs.getString("ISBN"),rs.getString("TITRE"),rs.getString("CATEGORY") )); 
              }
         }
         catch(SQLException e)
         {
             return null;
         }
        
         return livre; 
	}

	@Override
	public Livre getlivre(String ISBN) {
     
		Livre lv = null;
         try
         { 
  
              PreparedStatement st = Connexion.getCon().prepareStatement("select * from  Livres where ISBN=?");
              st.setString(1,ISBN);
              //cursor ResultSet
              ResultSet rs = st.executeQuery();
              if(rs.next())
              {
                lv = new Livre(rs.getString("ISBN"),rs.getString("TITRE"),rs.getString("CATEGORY") ); 
              }
         }
         catch(SQLException e)
         {
             return null;
         }
        
         return lv; 
	}

}
