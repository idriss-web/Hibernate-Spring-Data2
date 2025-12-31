package mundiapolis.orm_tp.repository;

import mundiapolis.orm_tp.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, Long>, JpaRepository<Patient, Long> {
Patient findByNom(String name);
Patient setNom(String name);
}
