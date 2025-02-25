package escuelaing.edu.co.juntate.service;

import org.springframework.beans.factory.annotation.Autowired;


public class ArenaRepository {
    private final ArenaRepository repository;

    @Autowired
    public ArenaRepository(ArenaRepository repository) {
        this.repository = repository;
    }    
}
