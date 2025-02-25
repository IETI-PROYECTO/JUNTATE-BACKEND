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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteEvent'");
    }

    @Override
    public List<Event> getAllEvents() throws EventException{
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllEvents'");
    }

    @Override
    public Event getEventById(String id) throws EventException{
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEventById'");
    }

    @Override
    public Event updateEvent(String id, Event event)throws EventException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateEvent'");
    }
    
}
