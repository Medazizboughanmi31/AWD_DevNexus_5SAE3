package tn.healthfit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.healthfit.entities.Event;
@Repository
public interface EventRepository extends JpaRepository<Event , Integer> {

}
