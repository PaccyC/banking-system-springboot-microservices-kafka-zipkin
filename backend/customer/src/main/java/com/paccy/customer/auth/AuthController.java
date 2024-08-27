package com.paccy.customer.auth;


import com.paccy.customer.auth.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;


    @PostMapping("/register")
    private ResponseEntity<AuthResponse> registerCustomer(
            @RequestBody RegistrationRequest registrationRequest
    ) {

        return ResponseEntity.ok(authService.register(registrationRequest));
    }
}
