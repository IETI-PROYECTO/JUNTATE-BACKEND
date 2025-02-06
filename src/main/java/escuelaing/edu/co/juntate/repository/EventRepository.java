package escuelaing.edu.co.juntate.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import escuelaing.edu.co.juntate.model.Event;

public interface EventRepository  extends MongoRepository<Event, String> {
    
}
