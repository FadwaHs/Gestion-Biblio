/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.Collection;
import model.bo.Emprunter;

/**
 *
 * @author Fadwa
 */
public interface IDAOEmprunter {
    
    
      boolean create(Emprunter E);
      Collection<Emprunter> retreive();
    
}
