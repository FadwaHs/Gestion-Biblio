package model.bo;

public class Livre {
	
	private String isbn;
    private String titre;
    private String category;
    

   public Livre() {
   }

	
   public Livre(String isbn) {
       this.isbn = isbn;
   }
   
   public Livre(String isbn, String titre, String category) {
	   
      this.isbn = isbn;
      this.titre = titre;
      this.category = category;
      
   }
  
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
