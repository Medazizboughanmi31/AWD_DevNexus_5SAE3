package tn.healthfit.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Programme implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    int idProgramme ;
    String nameProgramme;
    String descriptionProgramme ;
    String objective ;
    int durationProgramme ;
    @ElementCollection
    private Set<Integer> exercices = new HashSet<>();

    public String getNameProgramme() {
        return nameProgramme;
    }

    public void setNameProgramme(String nameProgramme) {
        this.nameProgramme = nameProgramme;
    }

    public String getDescriptionProgramme() {
        return descriptionProgramme;
    }

    public void setDescriptionProgramme(String descriptionProgramme) {
        this.descriptionProgramme = descriptionProgramme;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public int getDurationProgramme() {
        return durationProgramme;
    }

    public void setDurationProgramme(int durationProgramme) {
        this.durationProgramme = durationProgramme;
    }

    public Set<Integer> getExercices() {
        return exercices;
    }

    public void setExercices(Set<Integer> exercices) {
        this.exercices = exercices;
    }

}
