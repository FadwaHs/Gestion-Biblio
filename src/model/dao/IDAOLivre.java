/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.Collection;
import model.bo.Livres;


/**
 *
 * @author Fadwa
 */
public interface IDAOLivre {
    
      
    boolean create(Livres L);
    Collection<Livres> retreive();
    Collection<Livres> retreive(String cat);
    boolean update (Livres L);
    boolean delete(Livres L);
    
    
}
