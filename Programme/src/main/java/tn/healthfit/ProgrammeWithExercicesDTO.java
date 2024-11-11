package tn.healthfit;

import tn.healthfit.entities.Programme;

import java.util.List;

public class ProgrammeWithExercicesDTO {
    private Programme programme;
    private List<Exercice> exercices;
    public ProgrammeWithExercicesDTO(Programme programme, List<Exercice> exercices) {
        this.programme = programme;
        this.exercices = exercices;

    }

    public Programme getProgramme() {
        return programme;
    }

    public void setProgramme(Programme programme) {
        this.programme = programme;
    }

    public List<Exercice> getExercices() {
        return exercices;
    }

    public void setExercices(List<Exercice> exercices) {
        this.exercices = exercices;
    }

}
