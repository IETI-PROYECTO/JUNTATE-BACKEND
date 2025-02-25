package escuelaing.edu.co.juntate.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import escuelaing.edu.co.juntate.model.User;

public interface  UserRepository extends MongoRepository<User, String> {
    
}
