package mundiapolis.orm_tp;

import mundiapolis.orm_tp.entities.*;
import mundiapolis.orm_tp.repository.MedecinRepository;
import mundiapolis.orm_tp.repository.PatientRepository;
import mundiapolis.orm_tp.repository.RendezVousRepository;
import mundiapolis.orm_tp.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }

    @Bean
    CommandLineRunner start(
            IHospitalService hospitalService,
            PatientRepository patientRepository,
            MedecinRepository medecinRepository,
            RendezVousRepository rendezVousRepository
    ) {
        return args -> {
            Stream.of("Mohamed", "Hassan", "Najat").forEach(name -> {
                Patient patient = new Patient();
                patient.setNom(name);
                patient.setDateNaissance(new Date());
                patient.setMalade(false);
                hospitalService.savePatient(patient);
            });

            Stream.of("Aymane", "Hanane", "Yasmine").forEach(name -> {
                Medecin medecin = new Medecin();
                medecin.setNom(name);
                medecin.setEmail(name.toLowerCase() + "@gmail.com");
                medecin.setSpecialite(Math.random() > 0.5 ? "Cardio" : "Dentiste");
                hospitalService.saveMedecin(medecin);
            });

            Patient patient = hospitalService.findById(1L);
            Patient patient1 = patientRepository.findByNom("Mohamed");
            Medecin medecin = medecinRepository.findByNom("Yasmine");

            if (patient != null && medecin != null) {
                RendezVous rendezVous = new RendezVous();
                rendezVous.setDate(new Date());
                rendezVous.setStatus(StatusRDV.PENDING);
                rendezVous.setMedecin(medecin);
                rendezVous.setPatient(patient);

                RendezVous saveDRDV = hospitalService.saveRDV(rendezVous);
                System.out.println("RDV ID: " + saveDRDV.getId());

                if (!rendezVousRepository.findAll().isEmpty()) {
                    RendezVous rendezVous1 = rendezVousRepository.findAll().get(0);
                    Consultation consultation = new Consultation();
                    consultation.setDateConsultation(new Date());
                    consultation.setRendezVous(rendezVous1);
                    consultation.setRapport("Rapport de la consultation .....");
                    hospitalService.saveConsultation(consultation);
                }
            }
        };
    }
}