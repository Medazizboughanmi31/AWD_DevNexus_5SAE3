package tn.healthfit.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.healthfit.entities.Exercice;
import tn.healthfit.services.IExerciceService;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor

@RequestMapping("/exercice")
public class ExerciceRestController {
    @Autowired
    IExerciceService exerciceService ;

    @GetMapping("/retrieve-all-exercices")
    public List<Exercice> getExercices() {
        List<Exercice> listExercices = exerciceService.retrieveAllExercices() ;
        return listExercices ;
    }

    @GetMapping("/retrieve-exercice/{idExercice}")
    public Exercice retrieveExercice(@PathVariable("idExercice") int idExercice) {
        Exercice  exercice=exerciceService.retrieveExercice(idExercice) ;
        return exercice ;
    }


    @PostMapping("/add-exercice")
    public Exercice addExercic(@RequestBody Exercice e) {
        Exercice exercice=exerciceService.addExercice(e) ;
        return exercice ;
    }

    @DeleteMapping("/remove-exercice/{idExercice}")
    public void removeExercice(@PathVariable("idExercice") int idExercice) {
        exerciceService.removeExercice(idExercice);
    }

    @PutMapping("/modify-exercice")
    public Exercice modifyExercice(@RequestBody Exercice e) {
        Exercice exercice=exerciceService.modifyExercice(e) ;
        return exercice ;
    }

}
