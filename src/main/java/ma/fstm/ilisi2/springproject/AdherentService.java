package ma.fstm.ilisi2.springproject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdherentService {

	
	@Autowired
	private AdherentRepository repo;
	
	
	   public List<Adherent> listAll(){
		   
		   return repo.findAll();
		}
	   
		public void save(Adherent ad) {
		   repo.save(ad);
		}
		
		public void delete(String cin) {
			
		   repo.deleteById(cin);
		}
		
		public Adherent get(String cin) {
			
			return repo.findById(cin)
					.orElseThrow(() -> new RuntimeException("Adherent with cin " + cin + " not found"));
		}
	
	
}
