package ma.fstm.ilisi2.springproject;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;


@Entity
@Table(name="Adherent")
public class Adherent {

  @Id
  private String cin;
  @Column(name="nom")
  private String nom;
  @Column(name="prenom")
  private String prenom;
  @Column(name="Mdp")
  private String mdp;
  @Column(name="tele")
  private String tele;

 public Adherent() {
 }

	
 public Adherent(String cin) {
     this.cin = cin;
 }
 public Adherent(String cin, String nom, String prenom, String mdp, String tele) {
	 
    this.cin = cin;
    this.nom = nom;
    this.prenom = prenom;
    this.mdp = mdp;
    this.tele = tele;
    
 }

 @Id
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


}


