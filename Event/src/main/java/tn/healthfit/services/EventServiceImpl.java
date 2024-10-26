package tn.healthfit.services;

import com.netflix.discovery.converters.Auto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.healthfit.entities.Event;
import tn.healthfit.repositories.EventRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class EventServiceImpl implements IEventService{
    
    @Autowired
    EventRepository eventRepository ;
    
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
