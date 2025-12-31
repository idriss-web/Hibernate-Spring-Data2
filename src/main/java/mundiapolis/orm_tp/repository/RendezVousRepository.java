package mundiapolis.orm_tp.repository;

import mundiapolis.orm_tp.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface RendezVousRepository extends JpaRepository<RendezVous, String> {
}
