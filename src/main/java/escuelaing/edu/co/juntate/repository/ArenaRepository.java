package escuelaing.edu.co.juntate.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import escuelaing.edu.co.juntate.model.Arena;

public interface  ArenaRepository extends MongoRepository<Arena, String> {
    
}
