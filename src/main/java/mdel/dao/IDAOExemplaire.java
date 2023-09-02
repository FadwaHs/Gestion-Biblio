package mdel.dao;

import java.util.Collection;

import model.bo.Adherent;
import model.bo.Exemplaire;
import model.bo.Livre;

public interface IDAOExemplaire {
	
	
	Integer getnumberExemplaire(Livre L);
	Integer getnumberExemplaireA(Adherent L);
	boolean create(Exemplaire E);
    Collection<Exemplaire> retreive();
    Collection<Exemplaire> retreive(String ISBN);
    boolean delete(Integer noexp);

    
}
