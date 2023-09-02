package ma.fstm.ilisi2.springproject;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Table(name="livres")
public class livres {
	
	@Id
	private String isbn;
	@Column(name="Titre")
    private String titre;
	@Column(name="category")
    private String category;
    

   public livres() {
	   super();
   }

	
   public livres(String isbn) {
       this.isbn = isbn;
   }
   
   public livres(String isbn, String titre, String category) {
	   
      this.isbn = isbn;
      this.titre = titre;
      this.category = category;
      
   }
  
   @Id
   public String getIsbn() {
       return this.isbn;
   }
   
   public void setIsbn(String isbn) {
       this.isbn = isbn;
   }
   public String getTitre() {
       return this.titre;
   }
   
   public void setTitre(String titre) {
       this.titre = titre;
   }
   public String getCategory() {
       return this.category;
   }
   
   public void setCategory(String category) {
       this.category = category;
   }
  
}
