package escuelaing.edu.co.juntate.repository;

import escuelaing.edu.co.juntate.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);
}
