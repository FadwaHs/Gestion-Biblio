package ma.fstm.ilisi2.springproject;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmprunteService {
	
	
	@Autowired
	private EmprunttRepository empruntRepository;
	@Autowired
	private exemplaireRepository exemplaireRepository;
	
	
	public boolean save(Emprunter emprunter) {
		
		int etat = 1;

	    // Check exmplaire:
		
		Optional<Exemplaire> exemplaire = exemplaireRepository.findById(emprunter.getId().getNoexp());
	    if (exemplaire.isPresent()) {
	    	
	        etat = exemplaire.get().getEtat();
	    }
	    if (etat == 0) {
	    	
	        // Save:
	        empruntRepository.save(emprunter);

	        // Update Etat Exemplaire:
	        
	        exemplaire.ifPresent(e -> {
	            e.setEtat(1);
	            exemplaireRepository.save(e);
	        });
	        
	        return true; 
     	}
	    else
	    {
            
	        return false;
	    }
	 }
	
	
	 public List<Emprunter> listAll(){
		   
		   return empruntRepository.findAll();
		}
	

}
