package mundiapolis.orm_tp.service;

import mundiapolis.orm_tp.entities.Consultation;
import mundiapolis.orm_tp.entities.Medecin;
import mundiapolis.orm_tp.entities.Patient;
import mundiapolis.orm_tp.entities.RendezVous;

public interface IHospitalService {

    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRDV(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);

    Patient findById(Long id);
}