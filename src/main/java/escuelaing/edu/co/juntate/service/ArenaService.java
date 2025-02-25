package escuelaing.edu.co.juntate.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import escuelaing.edu.co.juntate.model.Arena;
import escuelaing.edu.co.juntate.repository.ArenaRepository;

@Service
public class ArenaService {
    private final ArenaRepository arenaRepository;

    @Autowired
    public ArenaService(ArenaRepository arenaRepository) {
        this.arenaRepository = arenaRepository;
    }

    public Arena createArena(Arena arena) {
        return arenaRepository.save(arena);
    }

    public List<Arena> getAllArenas() {
        return arenaRepository.findAll();
    }

    public Optional<Arena> getArenaById(String id) {
        return arenaRepository.findById(id);
    }

    public boolean deleteArena(String id) {
    if (arenaRepository.existsById(id)) {
        arenaRepository.deleteById(id);
        return true;
    }
    return false;
}


    public Arena updateArena(String id, Arena updatedArena) {
        return arenaRepository.findById(id)
                .map(existingArena -> {
                    existingArena.setNeighborhood(updatedArena.getNeighborhood());
                    existingArena.setAddress(updatedArena.getAddress());
                    existingArena.setImage(updatedArena.getImage());
                    existingArena.setSportsTypes(updatedArena.getSportsTypes());
                    existingArena.setImages(updatedArena.getImages());
                    return arenaRepository.save(existingArena);
                })
                .orElseThrow(() -> new RuntimeException("Arena not found with id: " + id));
    }

}
