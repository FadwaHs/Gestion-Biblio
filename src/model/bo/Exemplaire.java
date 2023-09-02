package model.bo;
// Generated 25 mars 2023 10:31:06 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Exemplaire generated by hbm2java
 */
public class Exemplaire  implements java.io.Serializable {
    
     private BigDecimal noexp;
     private Livres livres;
     private Boolean etat;
     private Set emprunters = new HashSet(0);

    public Exemplaire() {
    }

	
    public Exemplaire(BigDecimal noexp) {
        this.noexp = noexp;
    }
    public Exemplaire(BigDecimal noexp, Livres livres, Boolean etat, Set emprunters) {
       this.noexp = noexp;
       this.livres = livres;
       this.etat = etat;
       this.emprunters = emprunters;
    }
   
    public BigDecimal getNoexp() {
        return this.noexp;
    }
    
    public void setNoexp(BigDecimal noexp) {
        this.noexp = noexp;
    }
    public Livres getLivres() {
        return this.livres;
    }
    
    public void setLivres(Livres livres) {
        this.livres = livres;
    }
    public Boolean getEtat() {
        return this.etat;
    }
    
    public void setEtat(Boolean etat) {
        this.etat = etat;
    }
    public Set getEmprunters() {
        return this.emprunters;
    }
    
    public void setEmprunters(Set emprunters) {
        this.emprunters = emprunters;
    }




}


