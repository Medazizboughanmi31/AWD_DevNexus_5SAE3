package tn.healthfit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.healthfit.entities.Programme;
@Repository
public interface ProgrammeRepository extends JpaRepository <Programme,Integer> {
}
