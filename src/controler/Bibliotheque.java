/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.math.BigDecimal;
import java.util.List;
import java.util.Vector;
import javax.swing.JTable;
import model.bo.Adherent;
import model.bo.Emprunter;
import model.bo.EmprunterId;
import model.bo.Exemplaire;
import model.bo.Livres;
import model.dao.DAOAdherent;
import model.dao.DAOEmprunter;
import model.dao.DAOExemplaire;
import model.dao.DAOLivre;
import model.dao.IDAOAdherent;
import model.dao.IDAOEmprunter;
import model.dao.IDAOExemplaire;
import model.dao.IDAOLivre;

/**
 *
 * @author Fadwa
 */
public class Bibliotheque {
    
     public static IDAOLivre dao; // link to interface not Class ! 
     public static  IDAOEmprunter daoEmp;
     public static IDAOExemplaire daoexmpl;
     public static IDAOAdherent daoa;
     
     
     ///// Crud Livres   ////////////////////////////
     public static void ajouterLivre(String is, String tit,String category)
    {  
         Livres L = new Livres(is,tit,category,null);
         dao = new DAOLivre(); // injection static 
         dao.create(L);
        
    }
    
    public static void getlivres(JTable tab)
    {
           dao = new DAOLivre();
           daoexmpl = new DAOExemplaire();
           
           List<Livres> listlivre    =( List<Livres>)dao.retreive();
           Vector < Vector<Livres> > matrice = new  Vector < Vector<Livres> >();
           
           Vector<String>  header = new  Vector<String>();
           header.add("ISBN");
           header.add("Titre");
           header.add("Categoty");
           header.add("Dispo Exempl");
           
           for(Livres l :listlivre )
           {
                Vector v = new Vector();
                v.add(l.getIsbn());
                v.add(l.getTitre());
                v.add(l.getCategory());
               if(daoexmpl.getnumberExemplaire(l)>0)
               {
                  v.add(daoexmpl.getnumberExemplaire(l)+" Dispo");
               }
               else if( daoexmpl.getnumberExemplaire(l) == 0)
               {
                  v.add(" Aucun ");
               }
                matrice.add(v);
           
           }
        
           tab.setModel(new javax.swing.table.DefaultTableModel(matrice,header));
    }
    
    
    public static void getlivrescat(JTable tab , String cat)
    {
           dao = new DAOLivre();
           
           List<Livres> listlivre    =( List<Livres>)dao.retreive(cat);
           Vector < Vector<Livres> > matrice = new  Vector < Vector<Livres> >();
           
           Vector<String>  header = new  Vector<String>();
           header.add("ISBN");
           header.add("Titre");
           header.add("Categoty");
           
           for(Livres l :listlivre )
           {
                Vector v = new Vector();
                v.add(l.getIsbn());
                v.add(l.getTitre());
                v.add(l.getCategory());
                
                matrice.add(v);
           
           }
        
           tab.setModel(new javax.swing.table.DefaultTableModel(matrice,header));
   
    }
          
     public static void updateLivre(String is, String tit,String cat)
    {
            Livres tmpL = new Livres(is,tit,cat,null);
            dao = new DAOLivre();
            dao.update(tmpL);
  
    }
    
     public static void deleteLivre(String is, String tit,String cat)
    {
            Livres tmpL = new Livres(is,tit,cat,null);
            dao = new DAOLivre();
            dao.delete(tmpL);
  
    }
     
     //Exemplaire:
     
     
     public static void ajouterexemplaire(BigDecimal noexp , String ISBN)
     {
         Livres l = new Livres();
         l.setIsbn(ISBN);
         Exemplaire Exmpl = new Exemplaire(noexp,l,false,null); 
     
          daoexmpl = new DAOExemplaire(); // class biblio est ouvert a la modification
          daoexmpl.create(Exmpl);
     
     }
     
     public static Exemplaire getExmplaire( BigDecimal noexp )
     {
          Exemplaire Exmpl = new Exemplaire();
          Exmpl.setNoexp(noexp);
          
         daoexmpl = new DAOExemplaire();
        
         
         return daoexmpl.getexpl(Exmpl);
     }
     
     public static Integer getnumberOfExemplaire( String cin)
     {
          Adherent a = new   Adherent();
          a.setCin(cin);
          
          daoexmpl = new DAOExemplaire();
 
         return daoexmpl.getnumberExemplaireA(a);
        
     }
     
     
     
     
     
     
     
     
     ///// Emprunter //////////////
     
    public static void ajouterEmprunt(BigDecimal noexp,String CIN,String db, String df )
    {
         EmprunterId id = new EmprunterId( noexp,CIN,db);
   
         Exemplaire Expl = new Exemplaire();
	 Expl.setNoexp(noexp);
         
         Adherent A = new Adherent();
         A.setCin(CIN);
        
        Emprunter E = new Emprunter(id,Expl,A,df);
        daoEmp = new  DAOEmprunter();
           
        daoEmp.create(E);
    
    } 
    
    
    
    
    
    
    
    ///gestion ADherent

    public static void ajouterAdh(String cin, String nom, String prenom, String mdp, String tele)
    {  
         Adherent A = new Adherent(cin, nom, prenom, mdp,tele,null);
         daoa = new DAOAdherent();
         daoa.create(A);
        
    }
    
     public static void getAdhr(JTable tab)
    {
           daoa = new DAOAdherent();
           
           List<Adherent> list    =(List<Adherent>)daoa.retreive();
           Vector < Vector<Adherent> > matrice = new  Vector < Vector<Adherent> >();
           
           Vector<String>  header = new  Vector<String>();
           header.add("CIn");
           header.add("NOM");
           header.add("Prenom");
            header.add("Tele");
           
           for(Adherent l :list )
           {
                Vector v = new Vector();
                v.add(l.getCin());
                v.add(l.getNom());
                v.add(l.getPrenom());
                v.add(l.getTele());
                
                matrice.add(v);
           
           }
        
           tab.setModel(new javax.swing.table.DefaultTableModel(matrice,header));
    }
     
     
   public static void deleteAdh(String cin, String nom, String prenom, String mdp, String tele)
    {
            Adherent adhr = new Adherent(cin,nom,prenom,mdp,tele,null);
            daoa = new DAOAdherent();
            daoa.delete(adhr);
    }
    
}
