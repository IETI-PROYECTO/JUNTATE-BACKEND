package escuelaing.edu.co.juntate.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import escuelaing.edu.co.juntate.model.Event;

@Repository
public interface EventRepository  extends MongoRepository<Event, String> {
    
}
