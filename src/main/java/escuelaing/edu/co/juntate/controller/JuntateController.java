package escuelaing.edu.co.juntate.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import escuelaing.edu.co.juntate.model.Event;
import escuelaing.edu.co.juntate.service.JuntateService;
import escuelaing.edu.co.juntate.service.Exception.JuntateException;

@RestController
@RequestMapping("/api/events")
public class JuntateController {

private static final Logger logger = LoggerFactory.getLogger(JuntateController.class);
private final JuntateService juntateService;

    @Autowired
    public JuntateController(JuntateService juntateService) {
        this.juntateService = juntateService;
    }

    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        Event createdEvent;
        try {
            createdEvent = juntateService.createEvent(event);
            return new ResponseEntity<>(createdEvent, HttpStatus.CREATED);
        } catch (JuntateException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        
    }

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        logger.info("Received health check request");
        return ResponseEntity.ok("Service is running");
    }

    /**
     * Global exception handler for unexpected errors.
     * Logs the error and returns a generic error message.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        logger.error("An unexpected error occurred: {}", ex.getMessage(), ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred. Please try again later.");
    }
}
