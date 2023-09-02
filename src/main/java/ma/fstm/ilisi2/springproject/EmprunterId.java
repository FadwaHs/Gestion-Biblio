package ma.fstm.ilisi2.springproject;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EmprunterId  implements java.io.Serializable {


	@Column(name = "Noexp")
    private Integer noexp;

    @Column(name = "cin")
    private String cin;

    @Column(name = "datedebut")
    private String datedebut;


 public EmprunterId() {
 }

 public EmprunterId(Integer noexp, String cin, String datedebut) {
    this.noexp = noexp;
    this.cin = cin;
    this.datedebut = datedebut;
 }

 public Integer getNoexp() {
     return this.noexp;
 }
 
 public void setNoexp(Integer noexp) {
     this.noexp = noexp;
 }
 public String getCin() {
     return this.cin;
 }
 
 public void setCin(String cin) {
     this.cin = cin;
 }
 public String getDatedebut() {
     return this.datedebut;
 }
 
 public void setDatedebut(String datedebut) {
     this.datedebut = datedebut;
 }

  


}


