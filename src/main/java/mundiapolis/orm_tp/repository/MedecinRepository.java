package mundiapolis.orm_tp.repository;

import mundiapolis.orm_tp.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {
Medecin findByNom(String nom);
}
