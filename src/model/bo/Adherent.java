package model.bo;
// Generated 25 mars 2023 10:31:06 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Adherent generated by hbm2java
 */
public class Adherent  implements java.io.Serializable {


     private String cin;
     private String nom;
     private String prenom;
     private String mdp;
     private String tele;
     private Set emprunters = new HashSet(0);

    public Adherent() {
    }

	
    public Adherent(String cin) {
        this.cin = cin;
    }
    public Adherent(String cin, String nom, String prenom, String mdp, String tele, Set emprunters) {
       this.cin = cin;
       this.nom = nom;
       this.prenom = prenom;
       this.mdp = mdp;
       this.tele = tele;
       this.emprunters = emprunters;
    }
   
    public String getCin() {
        return this.cin;
    }
    
    public void setCin(String cin) {
        this.cin = cin;
    }
    public String getNom() {
        return this.nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return this.prenom;
    }
    
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getMdp() {
        return this.mdp;
    }
    
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    public String getTele() {
        return this.tele;
    }
    
    public void setTele(String tele) {
        this.tele = tele;
    }
    public Set getEmprunters() {
        return this.emprunters;
    }
    
    public void setEmprunters(Set emprunters) {
        this.emprunters = emprunters;
    }




}


