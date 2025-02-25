package escuelaing.edu.co.juntate.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import escuelaing.edu.co.juntate.service.ArenaService;
import escuelaing.edu.co.juntate.model.Arena;
import escuelaing.edu.co.juntate.model.Event;

@RestController
@RequestMapping("/api/arenas")
public class ArenaController {
    
    private final ArenaService arenaService;

    @Autowired
    public ArenaController(ArenaService arenaService) {
        this.arenaService = arenaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Arena>> getArenaById(@PathVariable String id) {
        Optional<Arena> arena = arenaService.getArenaById(id);
        return ResponseEntity.ok(arena);
    }

    @GetMapping
    public ResponseEntity<List<Arena>> getAllArenas() {
        List<Arena> arenas = arenaService.getAllArenas();
        return ResponseEntity.ok(arenas);
    }

    @PostMapping("/create")
    public ResponseEntity<Arena> createArena(@RequestBody Arena arena){
        Arena arenaCreated = arenaService.createArena(arena);
        return ResponseEntity.status(201).body(arenaCreated);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Arena> updateArena(@PathVariable String id, @RequestBody Arena arena) {
        try {
            Arena updatedArena = arenaService.updateArena(id, arena);
            return ResponseEntity.ok(updatedArena);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArena(@PathVariable String id) {
        boolean deleted = arenaService.deleteArena(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    


}
