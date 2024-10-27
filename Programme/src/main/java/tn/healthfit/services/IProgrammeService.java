package tn.healthfit.services;

import tn.healthfit.entities.Programme;

import java.util.List;

public interface IProgrammeService {
    public List<Programme> retrieveAllProgrammes() ;
    public Programme retrieveProgramme(int idProgramme) ;
    public Programme addProgramme(Programme p) ;
    public void removeProgramme(int idProgramme) ;
    public Programme modifyProgramme(Programme programme) ;
}
