package tn.healthfit.services;

import tn.healthfit.entities.Event;
import tn.healthfit.entities.Ticket;

import java.util.List;

public interface IEventService {
    public List<Event> retrieveAllEvents() ;
    public Event retrieveEvent(int idEvent) ;
    public Event addEvent(Event event) ;
    public void removeEvent(int idEvent) ;
    public Event modifyEvent(Event event) ;

    public List<Ticket> retrieveAllTickets();
    public Ticket retrieveTicket(int id);
    public List<Ticket> getEventTickets(int eventId);
    public void saveEventTicket(int eventId, int ticketId);
    public List<Ticket> affectTicketToEvent(int eventId);
}
