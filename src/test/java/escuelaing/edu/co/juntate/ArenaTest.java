package escuelaing.edu.co.juntate;

import escuelaing.edu.co.juntate.controller.ArenaController;
import escuelaing.edu.co.juntate.exception.JuntateException;
import escuelaing.edu.co.juntate.model.Arena;
import escuelaing.edu.co.juntate.service.ArenaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.http.HttpStatus.*;

@ExtendWith(MockitoExtension.class)
class ArenaTest {

    @Mock
    private ArenaService arenaService;

    @InjectMocks
    private ArenaController arenaController;

    private Arena arena;

    @BeforeEach
    void setUp() {
        arena = new Arena();
        arena.setId("1");
        arena.setNeighborhood("Centro");
        arena.setAddress("Calle 10 #5-30");
    }

    @Test
    void testGetArenaById_Success() throws JuntateException {
        when(arenaService.getArenaById("1")).thenReturn(arena);

        ResponseEntity<Arena> response = arenaController.getArenaById("1");

        assertEquals(OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("1", response.getBody().getId());
    }

    @Test
    void testGetArenaById_NotFound() throws JuntateException {
        when(arenaService.getArenaById("99")).thenThrow(new JuntateException(JuntateException.ARENA_NOT_FOUND));

        JuntateException exception = assertThrows(JuntateException.class, () -> {
            arenaController.getArenaById("99");
        });

        assertEquals(JuntateException.ARENA_NOT_FOUND, exception.getMessage());
    }

    @Test
    void testGetAllArenas() {
        List<Arena> arenas = Arrays.asList(arena, new Arena("Norte", "Calle 50 #20-10", "", null, null));
        when(arenaService.getAllArenas()).thenReturn(arenas);

        ResponseEntity<List<Arena>> response = arenaController.getAllArenas();

        assertEquals(OK, response.getStatusCode());
        assertEquals(2, response.getBody().size());
    }

    @Test
    void testCreateArena_Success() throws JuntateException {
        when(arenaService.createArena(any(Arena.class))).thenReturn(arena);

        ResponseEntity<Arena> response = arenaController.createArena(arena);

        assertEquals(CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Centro", response.getBody().getNeighborhood());
    }

    @Test
    void testCreateArena_Failure() throws JuntateException {
        when(arenaService.createArena(any(Arena.class)))
                .thenThrow(new JuntateException(JuntateException.ARENA_ALREADY_EXISTS));

        JuntateException exception = assertThrows(JuntateException.class, () -> {
            arenaController.createArena(arena);
        });

        assertEquals(JuntateException.ARENA_ALREADY_EXISTS, exception.getMessage());
    }

    @Test
void testUpdateArena_Success() throws JuntateException {
    Arena originalArena = new Arena();
    originalArena.setId("1");
    originalArena.setNeighborhood("Centro");
    originalArena.setAddress("Calle 10 #5-30");
    Arena updatedArena = new Arena();
    updatedArena.setId("1");
    updatedArena.setNeighborhood("Norte");
    updatedArena.setAddress("Avenida 100 #20-15");
    when(arenaService.updateArena(eq("1"), any(Arena.class))).thenReturn(updatedArena);
    ResponseEntity<Arena> response = arenaController.updateArena("1", updatedArena);
    assertEquals(OK, response.getStatusCode());
    assertNotNull(response.getBody());
    assertEquals("Norte", response.getBody().getNeighborhood());
    assertEquals("Avenida 100 #20-15", response.getBody().getAddress());
}

@Test
void testUpdateArena_NotFound() throws JuntateException {
    Arena updatedArena = new Arena();
    updatedArena.setId("99");
    updatedArena.setNeighborhood("Sur");
    updatedArena.setAddress("Carrera 50 #30-20");
    when(arenaService.updateArena(eq("99"), any(Arena.class)))
            .thenThrow(new JuntateException(JuntateException.ARENA_NOT_FOUND));
    JuntateException exception = assertThrows(JuntateException.class, () -> {
        arenaController.updateArena("99", updatedArena);
    });
    assertEquals(JuntateException.ARENA_NOT_FOUND, exception.getMessage());
}


    @Test
    void testDeleteArena_Success() throws JuntateException {
        when(arenaService.deleteArena("1")).thenReturn(true);

        ResponseEntity<Void> response = arenaController.deleteArena("1");

        assertEquals(NO_CONTENT, response.getStatusCode());
    }

    @Test
    void testDeleteArena_NotFound() throws JuntateException {
        when(arenaService.deleteArena("99"))
                .thenThrow(new JuntateException(JuntateException.ARENA_NOT_FOUND));

        JuntateException exception = assertThrows(JuntateException.class, () -> {
            arenaController.deleteArena("99");
        });

        assertEquals(JuntateException.ARENA_NOT_FOUND, exception.getMessage());
    }
}
