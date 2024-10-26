package tn.healthfit.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.healthfit.entities.Ticket;
import tn.healthfit.services.ITicketService;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
//@CrossOrigin(origins = "http://localhost:4200/**")
@RequestMapping("/ticket")
public class TicketRestController {

    @Autowired
    ITicketService ticketService ;

    @GetMapping("/retrieve-all-Tickets")
    public List<Ticket> getTickets() {
        return ticketService.retrieveAllTickets() ;
    }

    @GetMapping("/retrieve-Ticket/{idTicket}")
    public Ticket retrieveTicket(@PathVariable("idTicket") int idTicket) {
        return ticketService.retrieveTicket(idTicket) ;
    }

    @PostMapping("/add-Ticket")
    public Ticket addTicket(@RequestBody Ticket t) {
        return ticketService.addTicket(t) ;
    }

    @DeleteMapping("/remove-Ticket/{idTicket}")
    public void removeTicket(@PathVariable("idTicket") int idTicket) {
        ticketService.removeTicket(idTicket);
    }

    @PutMapping("/modify-Ticket")
    public Ticket modifyTicket(@RequestBody Ticket t) {
        return ticketService.modifyTicket(t) ;

    }
}
