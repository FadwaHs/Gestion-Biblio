package mdel.dao;

import java.util.Collection;

import model.bo.Adherent;



public interface IDAOAdherent {
	
	
	
	boolean create(Adherent A);
    Collection<Adherent> retreive();
    Collection<Adherent> retreive(String CIN);
    boolean update (Adherent A);
    boolean delete(String CIN);
   

}
