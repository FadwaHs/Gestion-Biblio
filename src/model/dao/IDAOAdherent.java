/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.Collection;
import model.bo.Adherent;
import model.bo.Livres;

/**
 *
 * @author Fadwa
 */
public interface IDAOAdherent {
    
    
    boolean create(Adherent A);
    Collection<Adherent> retreive();
    boolean update (Adherent A);
    boolean delete(Adherent A);
    
}
