package escuelaing.edu.co.juntate.service.event;

import java.util.List;

import escuelaing.edu.co.juntate.exception.EventException;
import escuelaing.edu.co.juntate.exception.JuntateException;
import escuelaing.edu.co.juntate.model.Event;

public interface EventService {

    Event createEvent(Event event) throws EventException;

    void deleteEvent(String id) throws EventException;

    List<Event> getAllEvents() throws EventException ;

    Event getEventById(String id)throws EventException;

    Event updateEvent(String id, Event event)throws EventException;

    
    
}
