/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.bo.Adherent;
import model.bo.Exemplaire;
import model.bo.Livres;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Fadwa
 */
public class DAOExemplaire implements IDAOExemplaire {

    public boolean create(Exemplaire Exmpl) {

        Transaction tx = null;
        try {

            Session session;
            session = NewHibernateUtil.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            session.save(Exmpl);
            tx.commit();

            return true;

        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Integer getnumberExemplaire(Livres L) {

        Transaction tx = null;
        try {

            Session session;
            session = NewHibernateUtil.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();

            Query query = session.createQuery("select count(*) from Exemplaire where ISBN=:isbn and ETAT=false");
            query.setParameter("isbn", L.getIsbn());
            Long count = (Long) query.uniqueResult();
            tx.commit();

            return count.intValue();
   

        } catch (HibernateException e) {
            return null;
        }

    }
    
     @Override
    public Integer getnumberExemplaireA(Adherent A) {
       
         Transaction tx = null;
        try {

            Session session;
            session = NewHibernateUtil.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();

            Query query = session.createQuery("select count(*) from Emprunter where CIN=:cin");
            query.setParameter("cin", A.getCin());
            Long count = (Long) query.uniqueResult();
            tx.commit();

            return count.intValue();
   

        } catch (HibernateException e) {
            return null;
        }
    }
    

    
    
    
    @Override
    public Exemplaire getexpl(Exemplaire Exmpl) {
 
          Transaction tx = null; 
        
         try
         { 
            Session session;
            session = NewHibernateUtil.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            
             Exemplaire exp =(Exemplaire) session.get(Exemplaire.class, Exmpl.getNoexp());
            
             if (exp != null)
             {
                  tx.commit();
                  return exp;
             }
 
         }
         catch(HibernateException e)
         {
            return null;
         } 
      
       return null;
    }

   

    
     

}
