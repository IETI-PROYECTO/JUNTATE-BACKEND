package escuelaing.edu.co.juntate.service.event;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import escuelaing.edu.co.juntate.exception.EventException;
import escuelaing.edu.co.juntate.model.Event;
import escuelaing.edu.co.juntate.repository.EventRepository;

@Service
@Qualifier("eventService")
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Event createEvent(Event event) throws EventException {
        if(event.getName() == null || event.getGameType() == null) {
            throw new EventException(EventException.MISSING_PARAMETERS);
        }
        if(event.getNumberOfPlayers() <= 0) {
            throw new EventException(EventException.INVALID_NUMBER_OF_PLAYERS);
        }
        return eventRepository.save(event);
    }

    @Override
    public void deleteEvent(String id) throws EventException {
        if(!eventRepository.existsById(id)) {
            throw new EventException(EventException.EVENT_NOT_FOUND);
        }
        eventRepository.deleteById(id);
    }

    @Override
    public List<Event> getAllEvents() throws EventException{
        return eventRepository.findAll();
    }

    @Override
    public Event getEventById(String id) throws EventException{
        Event event = eventRepository.findById(id).orElse(null);
        if(event == null) {
            throw new EventException(EventException.EVENT_NOT_FOUND);
        }
        return event;
    }
        
    @Override
    public Event updateEvent(String id, Event event)throws EventException {
        Event eventInDB = getEventById(id);
        eventInDB.setName(event.getName());
        eventInDB.setGameType(event.getGameType());
        eventInDB.setNumberOfPlayers(event.getNumberOfPlayers());
        eventInDB.setLocation(event.getLocation());
        eventInDB.setExpirationDate(event.getExpirationDate());
        return eventRepository.save(eventInDB); 
    }
    
}
