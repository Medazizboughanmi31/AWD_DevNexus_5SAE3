package tn.healthfit.services;

import tn.healthfit.entities.Event;

import java.util.List;

public interface IEventService {
    public List<Event> retrieveAllEvents() ;
    public Event retrieveEvent(int idEvent) ;
    public Event addEvent(Event event) ;
    public void removeEvent(int idEvent) ;
    public Event modifyEvent(Event event) ;
}
