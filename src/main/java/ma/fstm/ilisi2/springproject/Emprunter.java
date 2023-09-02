package ma.fstm.ilisi2.springproject;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "emprunter")
public class Emprunter  implements java.io.Serializable {

  @EmbeddedId
  private EmprunterId id;
  
  @ManyToOne
  @JoinColumn(name = "Noexp", insertable = false, updatable = false)
  private Exemplaire exemplaire;
  
  @ManyToOne
  @JoinColumn(name = "cin", insertable = false, updatable = false)
  private Adherent adherent;
  
  @Column(name = "datefin")
  private String datefin;

 public Emprunter() {
 }

	
 public Emprunter(EmprunterId id, Exemplaire exemplaire, Adherent adherent) {
     this.id = id;
     this.exemplaire = exemplaire;
     this.adherent = adherent;
 }
 
 public Emprunter(EmprunterId id, Exemplaire exemplaire, Adherent adherent, String datefin) {
    this.id = id;
    this.exemplaire = exemplaire;
    this.adherent = adherent;
    this.datefin = datefin;
 }

 public EmprunterId getId() {
     return this.id;
 }
 
 public void setId(EmprunterId id) {
     this.id = id;
 }
 public Exemplaire getExemplaire() {
     return this.exemplaire;
 }
 
 public void setExemplaire(Exemplaire exemplaire) {
     this.exemplaire = exemplaire;
 }
 public Adherent getAdherent() {
     return this.adherent;
 }
 
 public void setAdherent(Adherent adherent) {
     this.adherent = adherent;
 }
 public String getDatefin() {
     return this.datefin;
 }
 
 public void setDatefin(String datefin) {
     this.datefin = datefin;
 }




}


