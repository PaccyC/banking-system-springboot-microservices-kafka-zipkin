package com.paccy.banking_system.customer.auth;


import com.paccy.banking_system.customer.auth.services.AuthService;
import jakarta.servlet.http.HttpServletRequest;
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

        return ResponseEntity.ok(authService.register(registrationRequest).getBody());
    }

    @PostMapping("/login")
    private ResponseEntity<AuthResponse> authenticateCustomer(
            @RequestBody LoginRequest loginRequest
    ){
        return ResponseEntity.ok(authService.signin(loginRequest).getBody());
    }

    @PostMapping("/logout")
    private ResponseEntity<?> logoutUser(HttpServletRequest request){

   return ResponseEntity.ok().body(authService.logoutUser(request));
    }
}
