/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.Collection;
import java.util.List;
import model.bo.Livres;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Fadwa
 */
public class DAOLivre implements IDAOLivre
{

    @Override
    public boolean create(Livres L) {
        
          Transaction tx = null; 
            try
            {
                
            Session session;
            session = NewHibernateUtil.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            session.save(L);
            tx.commit();
            
            return true;
     
            }catch(Exception e )
            {
               return false;
            }
    }

    @Override
    public Collection<Livres> retreive() {
        
        Transaction tx = null; 
         try
         { 
            Session session;
            session = NewHibernateUtil.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            
            List livre = session.createQuery("from Livres").list();
            
            tx.commit();
            return livre;
         }
         catch(HibernateException e)
         {
             return null;
             
         } 
    }

    @Override
    public Collection<Livres> retreive(String cat) {
      
         Transaction tx = null; 
         try
         { 
            Session session;
            session = NewHibernateUtil.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
      
            
           Query query = session.createQuery("from Livres where CATEGORY = :cat ");
           query.setParameter("cat",cat);
           List<Livres> results = query.list();
            
            tx.commit();
            return results;
         }
         catch(HibernateException e)
         {
             return null;
             
         } 
    }

    @Override
    public boolean update(Livres L) {
        
         Transaction tx = null; 
        
         try
         { 
            Session session;
            session = NewHibernateUtil.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
             session.update(L);
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
    public boolean delete(Livres L) {
      
        
         Transaction tx = null; 
        
         try
         { 
            Session session;
            session = NewHibernateUtil.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            
             Livres lv =(Livres) session.get(Livres.class, L.getIsbn());
            
             if (lv != null)
             {
                  session.delete(lv); 
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
