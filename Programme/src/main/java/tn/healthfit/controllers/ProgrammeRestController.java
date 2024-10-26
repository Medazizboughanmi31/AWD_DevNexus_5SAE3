package tn.healthfit.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.healthfit.services.IProgrammeService;
import tn.healthfit.entities.Programme;

import java.util.List;
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
}
