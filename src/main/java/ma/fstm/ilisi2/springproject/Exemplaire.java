package ma.fstm.ilisi2.springproject;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Exemplaire")
public class Exemplaire  implements java.io.Serializable {

	 @Id
     @Column(name = "Noexp")
     private Integer noexp;
	
	 @ManyToOne
	 @JoinColumn(name = "ISBN")
     private livres livres;
	 
	 @Column(name = "Etat")
     private Integer etat;
    

    public Exemplaire() {
    }

	
    public Exemplaire(Integer noexp) {
    	
        this.noexp = noexp;
    }
    
    
    public Exemplaire(Integer noexp, livres livres, Integer etat) {
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
    
    public livres getLivres() {
        return this.livres;
    }
    
    
    public void setLivres(livres livres) {
        this.livres = livres;
    }
    
    public Integer getEtat() {
        return this.etat;
    }
    
    public void setEtat(Integer etat) {
        this.etat = etat;
    }
 




}
