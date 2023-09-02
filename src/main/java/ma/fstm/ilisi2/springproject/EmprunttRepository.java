package ma.fstm.ilisi2.springproject;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprunttRepository extends JpaRepository<Emprunter, EmprunterId>  {

}
