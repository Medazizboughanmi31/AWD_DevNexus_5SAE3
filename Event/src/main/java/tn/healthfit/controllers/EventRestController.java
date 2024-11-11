package tn.healthfit.controllers;

import com.netflix.discovery.converters.Auto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.healthfit.entities.Event;
import tn.healthfit.entities.Ticket;
import tn.healthfit.services.IEventService;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
//@CrossOrigin(origins = "http://localhost:4200/**")
@RequestMapping("/event")
public class EventRestController {

    @Autowired
    IEventService eventService;

    //Start Feign

    @RequestMapping("/tickets")
    public  List<Ticket> retrieveAllTickets() {
        return eventService.retrieveAllTickets();
    }

    @RequestMapping("/tickets/{id}")
    public  Ticket retrieveTicket(@PathVariable int id) {
        return eventService.retrieveTicket(id);
    }
    @GetMapping("/{id}/event-tickets")
    public List<Ticket> getEventTickets(@PathVariable int id) {
        return eventService.getEventTickets(id);
    }
    @PostMapping("/{id}/event-tickets/{ticketId}")
    public ResponseEntity<String> saveEventTickets(@PathVariable int id, @PathVariable int ticketId) {
        Ticket ticket = eventService.retrieveTicket(ticketId);
        if (ticket != null) {
            eventService.saveEventTicket(id, ticketId);
            return ResponseEntity.status(HttpStatus.OK).body("Ticket added to event successfully.");
        } else {
            // Gérer le cas où le job n'existe pas
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ticket not found with ID: " + ticketId);
        }
    }


    //End Feign

    @GetMapping("/retrieve-all-Events")
    public List<Event> getEvents() {
        return eventService.retrieveAllEvents() ;
    }

    @GetMapping("/retrieve-Event/{idEvent}")
    public Event retrieveEvent(@PathVariable("idEvent") int idEvent) {
       return eventService.retrieveEvent(idEvent) ;
    }

    @PostMapping("/add-Event")
    public Event addEvent(@RequestBody Event e) {
        return eventService.addEvent(e) ;
    }

    @DeleteMapping("/remove-Event/{idEvent}")
    public void removeEvent(@PathVariable("idEvent") int idEvent) {
        eventService.removeEvent(idEvent);
    }

    @PutMapping("/modify-Event")
    public Event modifyEvent(@RequestBody Event e) {
       return eventService.modifyEvent(e) ;

    }
}
