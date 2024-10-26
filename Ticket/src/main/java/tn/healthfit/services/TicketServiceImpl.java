package tn.healthfit.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.healthfit.entities.Ticket;
import tn.healthfit.repositories.TicketRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class TicketServiceImpl implements ITicketService{

    @Autowired
    TicketRepository ticketRepository;

    @Override
    public List<Ticket> retrieveAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket retrieveTicket(int idTicket) {
        return ticketRepository.findById(idTicket).get();
    }

    @Override
    public Ticket addTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public void removeTicket(int idTicket) {
        ticketRepository.deleteById(idTicket);
    }

    @Override
    public Ticket modifyTicket(Ticket ticket) {
        return ticketRepository.save(ticket);    }
}
