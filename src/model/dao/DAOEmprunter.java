/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.Collection;
import java.util.List;
import javax.swing.JOptionPane;
import model.bo.Emprunter;
import model.bo.Exemplaire;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Fadwa
 */
public class DAOEmprunter  implements IDAOEmprunter
{

    @Override
    public boolean create(Emprunter E) {
      
        /// Check exmplaire :
        Integer etat = 0;
        
         Transaction tx = null; 
         try
         { 
            Session session;
            session = NewHibernateUtil.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            Query query = session.createQuery("SELECT CAST(e.etat AS integer) FROM Exemplaire e WHERE e.noexp = :noexp");
            query.setParameter("noexp", E.getExemplaire().getNoexp());
            etat = (Integer) query.uniqueResult();
             
             // disponible
            if (etat == 0) {
              // Save:
                session.save(E);
              //update Etat Exemplaire:      
               Exemplaire exemplaire = (Exemplaire) session.get(Exemplaire.class, E.getExemplaire().getNoexp());
               exemplaire.setEtat(true);
               session.saveOrUpdate(exemplaire);
               
               tx.commit();
               return true;

            }
            else
            {
               JOptionPane.showMessageDialog(null, "L'exemplaire n'est pas disponible");
                return false; 
            }
            
         }
         catch(HibernateException e)
         {
            
             return false;  
         } 
  
    }

    @Override
    public Collection<Emprunter> retreive() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
