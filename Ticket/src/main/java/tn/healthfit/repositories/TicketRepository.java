package tn.healthfit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.healthfit.entities.Ticket;
@Repository
public interface TicketRepository extends JpaRepository<Ticket , Integer> {
}
