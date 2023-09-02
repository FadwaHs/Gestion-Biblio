/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.bo.Adherent;
import model.bo.Exemplaire;
import model.bo.Livres;

/**
 *
 * @author Fadwa
 */
public interface IDAOExemplaire {
    
     boolean create(Exemplaire Exmpl);
     Integer getnumberExemplaire(Livres L);
     Integer getnumberExemplaireA(Adherent A);
     Exemplaire getexpl( Exemplaire Exmpl);
    
}
