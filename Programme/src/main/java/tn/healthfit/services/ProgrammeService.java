package tn.healthfit.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.healthfit.Exercice;
import tn.healthfit.ExerciceClient;
import tn.healthfit.ProgrammeWithExercicesDTO;
import tn.healthfit.repositories.ProgrammeRepository;
import tn.healthfit.entities.Programme;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class ProgrammeService implements IProgrammeService{
    @Autowired
    ProgrammeRepository programmeRepository;
    @Autowired
    private ExerciceClient exerciceClient;

    public List<Programme> retrieveAllProgrammes() {
        return  programmeRepository.findAll();
    }


    public Programme retrieveProgramme(int idProgramme) {
        return programmeRepository.findById(idProgramme).get();
    }


    public Programme addProgramme(Programme p) {
        return programmeRepository.save(p);
    }


    public void removeProgramme(int idProgramme) {
        programmeRepository.deleteById(idProgramme);

    }

    public List<Exercice> getExercices() {
      return exerciceClient.getExercices();
    }

    public ProgrammeWithExercicesDTO getProgrammeWithExercices(Long programmeId) {
        log.info("Fetching programme with ID: " + programmeId);

        // Fetch the Programme from the database
        Programme programme = programmeRepository.findById(Math.toIntExact(programmeId))
                .orElseThrow(() -> {
                    log.error("Programme not found with ID: " + programmeId);
                    return new RuntimeException("Programme not found with id: " + programmeId);
                });

        // Fetch the Exercices for the Programme using the exercice repository
        List<Exercice> exercices = new ArrayList<>();
        for (Integer exerciceId : programme.getExercices()) {
            Exercice exercice = exerciceClient.retrieveExercice(exerciceId);
            if (exercice != null) {
                exercices.add(exercice);
            } else {
                System.out.println("Exercice not found for ID: " + exerciceId);
            }
        }

        // Return the DTO containing the Programme and its Exercices
        return new ProgrammeWithExercicesDTO(programme, exercices);
    }
    public Programme modifyProgramme(Programme programme) {
        return programmeRepository.save(programme);
    }
}
