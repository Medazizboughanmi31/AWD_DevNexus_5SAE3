package tn.healthfit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.healthfit.entities.Actualities;

public interface ActualityRepo extends JpaRepository<Actualities,Long> {
}
