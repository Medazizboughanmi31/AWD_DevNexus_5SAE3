package tn.healthfit;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "Exercice", url = "http://localhost:8088/exercice")
public interface ExerciceClient {
    @GetMapping("/retrieve-all-exercices")
    public List<Exercice> getExercices() ;
    @GetMapping("/retrieve-exercice/{idExercice}")
    public Exercice retrieveExercice(@PathVariable("idExercice") int idExercice);
}
