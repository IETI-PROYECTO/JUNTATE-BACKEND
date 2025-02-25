package escuelaing.edu.co.juntate.service;

import escuelaing.edu.co.juntate.exception.UserException;
import escuelaing.edu.co.juntate.model.User;
import escuelaing.edu.co.juntate.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private User testUser;

    @BeforeEach
    void setUp() {
        testUser = new User("123", "Juan Pérez", "juan@example.com", "securePass", 123456789, "Bogotá", "photo-url");
    }

    @Test
    void testGetAllUsers() {
        List<User> users = Arrays.asList(testUser);
        when(userRepository.findAll()).thenReturn(users);

        List<User> result = userService.getAllUsers();

        assertEquals(1, result.size());
        assertEquals("Juan Pérez", result.get(0).getName());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void testGetUserById_Found() {
        when(userRepository.findById("123")).thenReturn(Optional.of(testUser));

        User result = userService.getUserById("123");

        assertNotNull(result);
        assertEquals("Juan Pérez", result.getName());
        verify(userRepository, times(1)).findById("123");
    }

    @Test
    void testGetUserById_NotFound() {
        when(userRepository.findById("999")).thenReturn(Optional.empty());

        UserException exception = assertThrows(UserException.class, () -> userService.getUserById("999"));

        assertEquals("Usuario no encontrado con ID: 999", exception.getMessage());
        verify(userRepository, times(1)).findById("999");
    }

    @Test
    void testCreateUser_Success() {
        when(userRepository.findByEmail("juan@example.com")).thenReturn(Optional.empty());
        when(userRepository.save(any(User.class))).thenReturn(testUser);

        User result = userService.createUser(testUser);

        assertNotNull(result);
        assertEquals("Juan Pérez", result.getName());
        verify(userRepository, times(1)).findByEmail("juan@example.com");
        verify(userRepository, times(1)).save(testUser);
    }

    @Test
    void testCreateUser_EmailAlreadyExists() {
        when(userRepository.findByEmail("juan@example.com")).thenReturn(Optional.of(testUser));

        UserException exception = assertThrows(UserException.class, () -> userService.createUser(testUser));

        assertEquals("El email ya está registrado.", exception.getMessage());
        verify(userRepository, times(1)).findByEmail("juan@example.com");
        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    void testUpdateUser_Success() {
        User updatedUser = new User("123", "Juan Actualizado", "juan@example.com", "securePass", 987654321, "Medellín", "photo-url");

        when(userRepository.findById("123")).thenReturn(Optional.of(testUser));
        when(userRepository.save(any(User.class))).thenReturn(updatedUser);

        User result = userService.updateUser("123", updatedUser);

        assertEquals("Juan Actualizado", result.getName());
        assertEquals(987654321, result.getPhone());
        verify(userRepository, times(1)).findById("123");
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    void testUpdateUser_NotFound() {
        User updatedUser = new User("999", "Nuevo Nombre", "nuevo@example.com", "securePass", 987654321, "Cali", "photo-url");

        when(userRepository.findById("999")).thenReturn(Optional.empty());

        UserException exception = assertThrows(UserException.class, () -> userService.updateUser("999", updatedUser));

        assertEquals("Usuario no encontrado con ID: 999", exception.getMessage());
        verify(userRepository, times(1)).findById("999");
        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    void testDeleteUser_Success() {
        when(userRepository.findById("123")).thenReturn(Optional.of(testUser));
        doNothing().when(userRepository).delete(testUser);

        assertDoesNotThrow(() -> userService.deleteUser("123"));

        verify(userRepository, times(1)).findById("123");
        verify(userRepository, times(1)).delete(testUser);
    }

    @Test
    void testDeleteUser_NotFound() {
        when(userRepository.findById("999")).thenReturn(Optional.empty());

        UserException exception = assertThrows(UserException.class, () -> userService.deleteUser("999"));

        assertEquals("Usuario no encontrado con ID: 999", exception.getMessage());
        verify(userRepository, times(1)).findById("999");
        verify(userRepository, never()).delete(any(User.class));
    }
}
