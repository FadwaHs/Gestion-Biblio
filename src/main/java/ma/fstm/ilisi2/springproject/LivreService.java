package ma.fstm.ilisi2.springproject;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LivreService {
	
	@Autowired
	private LivreRepository repo;
	
	    public List<livres> listAll(){
		   
		   return repo.findAll();
		}
	   
		public void save(livres livre) {
		   repo.save(livre);
		}
		
		public void delete(String isbn) {
			
		   repo.deleteById(isbn);
		}
		
		public livres get(String isbn) {
			
			return repo.findById(isbn)
					.orElseThrow(() -> new RuntimeException("livres with isbn " + isbn + " not found"));
		}
		
		
}
