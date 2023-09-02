/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.Collection;
import java.util.List;
import model.bo.Adherent;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Fadwa
 */
public class DAOAdherent implements IDAOAdherent 
{

    @Override
    public boolean create(Adherent A) {
         Transaction tx = null; 
            try
            {
                
            Session session;
            session = NewHibernateUtil.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            session.save(A);
            tx.commit();
            
            return true;
     
            }catch(Exception e )
            {
               return false;
            }
    }

    @Override
    public Collection<Adherent> retreive() {
       Transaction tx = null; 
         try
         { 
            Session session;
            session = NewHibernateUtil.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            
            List AD = session.createQuery("from Adherent").list();
            
            tx.commit();
            return AD;
         }
         catch(HibernateException e)
         {
             return null;
             
         } 
    }

    @Override
    public boolean update(Adherent A) {
         Transaction tx = null; 
        
         try
         { 
            Session session;
            session = NewHibernateUtil.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
             session.update(A);
             tx.commit();
             return true;
         }
         catch(HibernateException e)
         {    
             tx.rollback();
             return false;             
         } 
    }

    @Override
    public boolean delete(Adherent A) {
         
         Transaction tx = null; 
        
         try
         { 
            Session session;
            session = NewHibernateUtil.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            
             Adherent Ad =(Adherent) session.get(Adherent.class, A.getCin());
            
             if (Ad != null)
             {
                  session.delete(Ad); 
             }
            

             tx.commit();
         }
         catch(HibernateException e)
         {
             return false;
             
         } 
      
       return true;
    }
    
    
    
    
    }
    

