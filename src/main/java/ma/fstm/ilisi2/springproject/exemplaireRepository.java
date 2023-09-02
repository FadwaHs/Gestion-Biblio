package ma.fstm.ilisi2.springproject;

import org.springframework.data.jpa.repository.JpaRepository;

public interface exemplaireRepository extends JpaRepository<Exemplaire, Integer> {
	
    // add any custom methods here if needed
}