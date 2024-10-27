package tn.healthfit.services;

import tn.healthfit.entities.Exercice;

import java.util.List;

public interface IExerciceService {
    public List<Exercice> retrieveAllExercices() ;
    public Exercice retrieveExercice(int idExercice) ;
    public Exercice addExercice(Exercice e) ;
    public void removeExercice(int idExercice) ;
    public Exercice modifyExercice(Exercice exercice) ;
}
