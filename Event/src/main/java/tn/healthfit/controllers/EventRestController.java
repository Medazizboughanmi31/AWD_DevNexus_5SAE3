package tn.healthfit.controllers;

import com.netflix.discovery.converters.Auto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.healthfit.entities.Event;
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
