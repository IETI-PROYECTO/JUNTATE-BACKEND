package escuelaing.edu.co.juntate.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class JuntateController {

private static final Logger logger = LoggerFactory.getLogger(JuntateController.class);

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        logger.info("Received health check request");
        return ResponseEntity.ok("Service is running");
    }

}
