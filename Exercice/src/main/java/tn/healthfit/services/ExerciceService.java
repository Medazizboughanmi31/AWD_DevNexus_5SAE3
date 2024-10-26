package tn.healthfit.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.healthfit.entities.Exercice;
import tn.healthfit.repositories.ExerciceRepository;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class ExerciceService implements IExerciceService {
    @Autowired
    ExerciceRepository exerciceRepository ;


    public List<Exercice> retrieveAllExercices() {
        return exerciceRepository.findAll();
    }


    public Exercice retrieveExercice(int idExercice) {
        return exerciceRepository.findById(idExercice).get();
    }


    public Exercice addExercice(Exercice e) {
        return exerciceRepository.save(e);
    }


    public void removeExercice(int idExercice) {
        exerciceRepository.deleteById(idExercice);

    }


    public Exercice modifyExercice(Exercice exercice) {
        return exerciceRepository.save(exercice);
    }
}
