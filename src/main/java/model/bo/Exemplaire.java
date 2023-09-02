package model.bo;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;


public class Exemplaire  implements java.io.Serializable {


     private Integer noexp;
     private Livre livres;
     private Boolean etat;
    

    public Exemplaire() {
    }

	
    public Exemplaire(Integer noexp) {
    	
        this.noexp = noexp;
    }
    
    
    public Exemplaire(Integer noexp, Livre livres, Boolean etat) {
       this.noexp = noexp;
       this.livres = livres;
       this.etat = etat;
     
    }
   
    public Integer getNoexp() {
        return this.noexp;
    }
    
    public void setNoexp(Integer noexp) {
        this.noexp = noexp;
    }
    
    public Livre getLivres() {
        return this.livres;
    }
    
    
    public void setLivres(Livre livres) {
        this.livres = livres;
    }
    
    public Boolean getEtat() {
        return this.etat;
    }
    
    public void setEtat(Boolean etat) {
        this.etat = etat;
    }
 




}