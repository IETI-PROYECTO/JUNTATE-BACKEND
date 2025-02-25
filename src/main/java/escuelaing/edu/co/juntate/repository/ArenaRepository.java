package escuelaing.edu.co.juntate.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import escuelaing.edu.co.juntate.model.Arena;

@Repository
public interface  ArenaRepository extends MongoRepository<Arena, String> {
    
}
