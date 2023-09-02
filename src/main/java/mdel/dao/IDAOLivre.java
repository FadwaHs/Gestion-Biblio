package mdel.dao;

import java.util.Collection;

import model.bo.Livre;

public interface IDAOLivre {
	
	
	boolean create(Livre L);
    Collection<Livre> retreive();
    Collection<Livre> retreive(String cat);
    boolean update (Livre L);
    boolean delete(String ISBN);
    Livre  getlivre(String ISBN);


}
