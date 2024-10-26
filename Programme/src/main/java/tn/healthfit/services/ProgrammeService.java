package tn.healthfit.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.healthfit.repositories.ProgrammeRepository;
import tn.healthfit.entities.Programme;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class ProgrammeService implements IProgrammeService{
    @Autowired
    ProgrammeRepository programmeRepository;

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


    public Programme modifyProgramme(Programme programme) {
        return programmeRepository.save(programme);
    }
}
