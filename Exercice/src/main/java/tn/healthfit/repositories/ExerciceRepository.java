package tn.healthfit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.healthfit.entities.Exercice;
@Repository
public interface ExerciceRepository extends JpaRepository<Exercice,Integer> {
}
