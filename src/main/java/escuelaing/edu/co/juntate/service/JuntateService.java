package escuelaing.edu.co.juntate.service;

import escuelaing.edu.co.juntate.model.Event;
import escuelaing.edu.co.juntate.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JuntateService {

    private final EventRepository eventRepository;

    @Autowired
    public JuntateService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }
}