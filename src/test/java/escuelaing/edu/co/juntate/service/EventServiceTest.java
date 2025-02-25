package escuelaing.edu.co.juntate.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import escuelaing.edu.co.juntate.exception.EventException;
import escuelaing.edu.co.juntate.model.Event;
import escuelaing.edu.co.juntate.repository.EventRepository;
import escuelaing.edu.co.juntate.service.event.EventServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)

class EventServiceTest {

    @Mock
    private EventRepository eventRepository;

    @InjectMocks
    private EventServiceImpl eventService;

    private Event sampleEvent;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); 
        eventRepository = mock(EventRepository.class); 
        eventService = new EventServiceImpl(eventRepository); 
        sampleEvent = new Event();
        sampleEvent.setId("1");
        sampleEvent.setName("FIFA Tournament");
        sampleEvent.setGameType("Sports");
        sampleEvent.setNumberOfPlayers(4);
    }

    @Test
    void testCreateEvent_Success() throws EventException {
        when(eventRepository.save(any(Event.class))).thenReturn(sampleEvent);

        Event result = eventService.createEvent(sampleEvent);

        assertNotNull(result);
        assertEquals("FIFA Tournament", result.getName());
        verify(eventRepository, times(1)).save(sampleEvent);
    }

    @Test
    void testCreateEvent_MissingParameters() {
        sampleEvent.setName(null);

        EventException exception = assertThrows(EventException.class, () -> eventService.createEvent(sampleEvent));

        assertEquals(EventException.MISSING_PARAMETERS, exception.getMessage());
        verify(eventRepository, never()).save(any(Event.class));
    }

    @Test
    void testCreateEvent_InvalidNumberOfPlayers() {
        sampleEvent.setNumberOfPlayers(0);

        EventException exception = assertThrows(EventException.class, () -> eventService.createEvent(sampleEvent));

        assertEquals(EventException.INVALID_NUMBER_OF_PLAYERS, exception.getMessage());
        verify(eventRepository, never()).save(any(Event.class));
    }

    @Test
    void testDeleteEvent_Success() throws EventException {
        when(eventRepository.existsById("1")).thenReturn(true);
        doNothing().when(eventRepository).deleteById("1");

        eventService.deleteEvent("1");

        verify(eventRepository, times(1)).deleteById("1");
    }

    @Test
    void testDeleteEvent_NotFound() {
        when(eventRepository.existsById("1")).thenReturn(false);

        EventException exception = assertThrows(EventException.class, () -> eventService.deleteEvent("1"));

        assertEquals(EventException.EVENT_NOT_FOUND, exception.getMessage());
        verify(eventRepository, never()).deleteById(anyString());
    }

    @Test
    void testGetAllEvents_Success() throws EventException {
        List<Event> events = Arrays.asList(sampleEvent, new Event());
        when(eventRepository.findAll()).thenReturn(events);

        List<Event> result = eventService.getAllEvents();

        assertEquals(2, result.size());
        verify(eventRepository, times(1)).findAll();
    }

    @Test
    void testGetEventById_Success() throws EventException {
        when(eventRepository.findById("1")).thenReturn(Optional.of(sampleEvent));

        Event result = eventService.getEventById("1");

        assertNotNull(result);
        assertEquals("FIFA Tournament", result.getName());
        verify(eventRepository, times(1)).findById("1");
    }

    @Test
    void testGetEventById_NotFound() {
        when(eventRepository.findById("1")).thenReturn(Optional.empty());

        EventException exception = assertThrows(EventException.class, () -> eventService.getEventById("1"));

        assertEquals(EventException.EVENT_NOT_FOUND, exception.getMessage());
        verify(eventRepository, times(1)).findById("1");
    }

    @Test
    void testUpdateEvent_Success() throws EventException {
        when(eventRepository.existsById("1")).thenReturn(true);
        when(eventRepository.save(sampleEvent)).thenReturn(sampleEvent);

        Event result = eventService.updateEvent("1", sampleEvent);

        assertNotNull(result);
        assertEquals("FIFA Tournament", result.getName());
        verify(eventRepository, times(1)).save(sampleEvent);
    }

    @Test
    void testUpdateEvent_NotFound() {
        when(eventRepository.existsById("1")).thenReturn(false);

        EventException exception = assertThrows(EventException.class, () -> eventService.updateEvent("1", sampleEvent));

        assertEquals(EventException.EVENT_NOT_FOUND, exception.getMessage());
        verify(eventRepository, never()).save(any(Event.class));
    }
}
