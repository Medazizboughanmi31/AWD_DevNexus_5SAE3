package tn.healthfit.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import tn.healthfit.entities.Ticket;

import java.util.List;

@FeignClient(name = "ticket-s", url = "http://localhost:8098")
public interface TicketClient {
    @RequestMapping("Ticket/ticket/retrieve-all-Tickets")
    public List<Ticket> getTickets();
    @RequestMapping("Ticket/ticket/retrieve-Ticket/{idTicket}")
    public Ticket retrieveTicket(@PathVariable("idTicket") int idTicket);

}
