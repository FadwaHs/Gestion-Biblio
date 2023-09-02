package mdel.dao;

import java.util.Collection;

import model.bo.Adherent;
import model.bo.Emprunter;

public interface IDAOEmprunt {
	
	    boolean create(Emprunter E);
	    Collection<Emprunter> retreive();
	    Collection<Emprunter> retreive(Adherent A);

}
