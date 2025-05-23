package escuelaing.edu.co.juntate.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import escuelaing.edu.co.juntate.model.AuthenticationRequest;
import escuelaing.edu.co.juntate.model.AuthenticationResponse;
import escuelaing.edu.co.juntate.model.RegisterRequest;
import escuelaing.edu.co.juntate.service.AuthenticationService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}