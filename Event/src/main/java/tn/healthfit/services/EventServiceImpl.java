package tn.healthfit.services;

import com.netflix.discovery.converters.Auto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.healthfit.entities.Event;
import tn.healthfit.entities.Ticket;
import tn.healthfit.repositories.EventRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EventServiceImpl implements IEventService{
    
    @Autowired
    EventRepository eventRepository ;

    @Autowired
    private TicketClient ticketService;
    


    public List<Ticket> retrieveAllTickets(){
        return ticketService.getTickets();
    }

    public Ticket retrieveTicket(int id){
        return ticketService.retrieveTicket(id);
    }

    public List<Ticket> getEventTickets(int eventId) {
        Event event = eventRepository.findById(eventId).get();
        return event.getEventTickets().stream()
                .map(ticketService::retrieveTicket)
                .collect(Collectors.toList());
    }

    // Method to save product in the event
    public void saveEventTicket(int eventId, int ticketId) {
        Event event = eventRepository.findById(eventId).get();
        event.getEventTickets().add(ticketId);
        eventRepository.save(event);
    }

    public List<Ticket> affectTicketToEvent(int eventId) {
        // Fetch the food from the database
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found with id: " + eventId));  // Generic exception

        // Fetch the ingredients using the ingredient client
        List<Ticket> tickets = new ArrayList<>();
        for (Integer ticketId : event.getEventTickets()) {
            Ticket ticket = ticketService.retrieveTicket(ticketId);
            if (ticket != null) {
                tickets.add(ticket);
            } else {
                System.out.println("Ingredient not found for ID: " + ticketId);
            }
        }
        eventRepository.save(event);
        // Return the DTO containing the food and its ingredients
        return tickets ;
    }


    @Override
    public List<Event> retrieveAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Event retrieveEvent(int idEvent) {
        return eventRepository.findById(idEvent).get();
    }

    @Override
    public Event addEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public void removeEvent(int idEvent) {
        eventRepository.deleteById(idEvent);
    }

    @Override
    public Event modifyEvent(Event event) {
        return eventRepository.save(event);
    }
}
