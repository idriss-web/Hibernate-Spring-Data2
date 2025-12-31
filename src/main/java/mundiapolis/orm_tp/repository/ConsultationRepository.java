package mundiapolis.orm_tp.repository;

import mundiapolis.orm_tp.entities.Consultation;
import mundiapolis.orm_tp.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
}
