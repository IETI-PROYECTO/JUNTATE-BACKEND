package escuelaing.edu.co.juntate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import escuelaing.edu.co.juntate.exception.JuntateException;
import escuelaing.edu.co.juntate.model.Arena;
import escuelaing.edu.co.juntate.repository.ArenaRepository;

@Service
public class ArenaService {
    private final ArenaRepository arenaRepository;

    @Autowired
    public ArenaService(ArenaRepository arenaRepository) {
        this.arenaRepository = arenaRepository;
    }

    public Arena createArena(Arena arena) throws JuntateException {
        if (arena == null || arena.getNeighborhood() == null || arena.getAddress() == null) {
            throw new JuntateException(JuntateException.INVALID_REQUEST);
        }
        if (arenaRepository.existsById(arena.getId())) {
            throw new JuntateException(JuntateException.ARENA_ALREADY_EXISTS);
        }
        return arenaRepository.save(arena);
    }

    public List<Arena> getAllArenas() {
        return arenaRepository.findAll();
    }

    public Arena getArenaById(String id) throws JuntateException {
    try {
        return arenaRepository.findById(id)
                .orElseThrow(() -> new JuntateException(JuntateException.ARENA_NOT_FOUND));
    } catch (Exception e) {
        throw new JuntateException("Error al obtener la arena: " + e.getMessage());
    }
}

    public boolean deleteArena(String id) throws JuntateException {
        if (arenaRepository.existsById(id)) {
            try {
                arenaRepository.deleteById(id);
                return true;
            } catch (Exception e) {
                throw new JuntateException(JuntateException.ARENA_DELETE_EXCEPTION);
            }
        }
        throw new JuntateException(JuntateException.ARENA_NOT_FOUND);
    }

    public Arena updateArena(String id, Arena updatedArena) throws JuntateException {
        if (updatedArena == null || updatedArena.getNeighborhood() == null || updatedArena.getAddress() == null) {
            throw new JuntateException(JuntateException.INCORRECT_DATA);
        }
        return arenaRepository.findById(id)
                .map(existingArena -> {
                    existingArena.setNeighborhood(updatedArena.getNeighborhood());
                    existingArena.setAddress(updatedArena.getAddress());
                    existingArena.setImage(updatedArena.getImage());
                    existingArena.setSportsTypes(updatedArena.getSportsTypes());
                    existingArena.setImages(updatedArena.getImages());
                    return arenaRepository.save(existingArena);
                })
                .orElseThrow(() -> new JuntateException(JuntateException.ARENA_NOT_FOUND));
    }
}
