package tn.healthfit.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.healthfit.Exercice;
import tn.healthfit.ProgrammeWithExercicesDTO;
import tn.healthfit.services.IProgrammeService;
import tn.healthfit.entities.Programme;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@AllArgsConstructor

@RequestMapping("/programme")
public class ProgrammeRestController {
    @Autowired
    IProgrammeService programmeService ;

    @GetMapping("/retrieve-all-programmes")
    public List<Programme> getProgrammes() {
        List<Programme> listProgrammes = programmeService.retrieveAllProgrammes() ;
        return listProgrammes ;
    }

    @GetMapping("/retrieve-programmes/{idProgrammes}")
    public Programme retrieveProgramme(@PathVariable("idProgramme") int idProgramme) {
        Programme  programme=programmeService.retrieveProgramme(idProgramme
        ) ;
        return programme ;
    }


    @PostMapping("/add-programme")
    public Programme addProgramme(@RequestBody Programme p) {
        Programme programme=programmeService.addProgramme(p) ;
        return programme ;
    }

    @DeleteMapping("/remove-programme/{idProgramme}")
    public void removeProgramme (@PathVariable("idProgramme") int idProgramme) {
        programmeService.removeProgramme(idProgramme);
    }

    @PutMapping("/modify-programme")
    public Programme modifyProgramme(@RequestBody Programme p) {
        Programme programme=programmeService.modifyProgramme(p) ;
        return programme  ;
    }

    @GetMapping("/retrieve-all-exercices")
    public List<Exercice> getAllExercices() {
        return programmeService.getExercices();
    }
    @GetMapping("/{id}/with-exercices")
    public ResponseEntity<ProgrammeWithExercicesDTO> getProgrammeWithExercices(@PathVariable Long id) {
        try {
            log.info("Fetching programme with ID: " + id);
            ProgrammeWithExercicesDTO programmeWithExercicesDTO = programmeService.getProgrammeWithExercices(id);
            log.info("Returning programme with exercices: " + programmeWithExercicesDTO);
            return ResponseEntity.ok(programmeWithExercicesDTO);
        } catch (RuntimeException e) {
            log.error("Error fetching programme with ID: " + id, e);
            return ResponseEntity.status(404).body(null);  // Not Found
        }
    }


}
