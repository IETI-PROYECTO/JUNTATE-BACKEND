package escuelaing.edu.co.juntate.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;


import escuelaing.edu.co.juntate.service.ArenaService;
import escuelaing.edu.co.juntate.exception.ArenaException;
import escuelaing.edu.co.juntate.model.Arena;

@RestController
@RequestMapping("/api/arenas")
@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
public class ArenaController {
    
    private final ArenaService arenaService;

    @Autowired
    public ArenaController(ArenaService arenaService) {
        this.arenaService = arenaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Arena> getArenaById(@PathVariable String id) throws ArenaException {
        Arena arena = arenaService.getArenaById(id);
        return ResponseEntity.ok(arena);
    }

    @GetMapping
    public ResponseEntity<List<Arena>> getAllArenas() {
        List<Arena> arenas = arenaService.getAllArenas();
        return ResponseEntity.ok(arenas);
    }

    @PostMapping("/create")
    public ResponseEntity<Arena> createArena(@RequestBody Arena arena) throws ArenaException {
        Arena arenaCreated = arenaService.createArena(arena);
        return ResponseEntity.status(201).body(arenaCreated);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Arena> updateArena(@PathVariable String id, @RequestBody Arena arena) throws ArenaException {
        try {
            Arena updatedArena = arenaService.updateArena(id, arena);
            return ResponseEntity.ok(updatedArena);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArena(@PathVariable String id) throws ArenaException {
        boolean deleted = arenaService.deleteArena(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

}