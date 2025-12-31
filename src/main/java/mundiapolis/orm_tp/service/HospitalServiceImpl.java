package mundiapolis.orm_tp.service;

import jakarta.transaction.Transactional;
import mundiapolis.orm_tp.entities.Consultation;
import mundiapolis.orm_tp.entities.Medecin;
import mundiapolis.orm_tp.entities.Patient;
import mundiapolis.orm_tp.entities.RendezVous;
import mundiapolis.orm_tp.repository.ConsultationRepository;
import mundiapolis.orm_tp.repository.MedecinRepository;
import mundiapolis.orm_tp.repository.PatientRepository;
import mundiapolis.orm_tp.repository.RendezVousRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Transactional
@Service
public class HospitalServiceImpl implements IHospitalService {

    private final PatientRepository patientRepository;
    private final MedecinRepository medecinRepository;
    private final RendezVousRepository rendezVousRepository;
    private final ConsultationRepository consultationRepository;

    public HospitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository,
                               RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRDV(RendezVous rendezVous) {
        rendezVous.setId(UUID.randomUUID().toString());
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }

    @Override
    public Patient findById(Long id) { // Correction ici : Long (Wrapper) au lieu de long (primitif)
        return patientRepository.findById(id).orElse(null);
    }
}