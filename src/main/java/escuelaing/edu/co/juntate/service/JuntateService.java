package escuelaing.edu.co.juntate.service;

import escuelaing.edu.co.juntate.model.Event;
import escuelaing.edu.co.juntate.repository.EventRepository;
import escuelaing.edu.co.juntate.service.Exception.JuntateException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import escuelaing.edu.co.juntate.model.Event;
import escuelaing.edu.co.juntate.repository.EventRepository;

@Service
public class JuntateService {

    private final EventRepository eventRepository;

    @Autowired
    public JuntateService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event createEvent(Event event) throws JuntateException {
        if(event.getName() == null || event.getGameType() == null || event.getNumberOfPlayers() <= 0) {
            throw new JuntateException(JuntateException.MISSING_PARAMETERS);
        }
        return eventRepository.save(event);
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }
}