package escuelaing.edu.co.juntate.service;

import org.springframework.beans.factory.annotation.Autowired;

import escuelaing.edu.co.juntate.repository.UserRepository;

public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

}
