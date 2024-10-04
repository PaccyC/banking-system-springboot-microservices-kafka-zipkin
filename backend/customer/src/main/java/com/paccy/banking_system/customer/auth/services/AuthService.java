package com.paccy.banking_system.customer.auth.services;

import com.paccy.banking_system.customer.auth.AuthResponse;
import com.paccy.banking_system.customer.auth.LoginRequest;
import com.paccy.banking_system.customer.auth.RegistrationRequest;
import com.paccy.banking_system.customer.entities.Address;
import com.paccy.banking_system.customer.entities.Customer;
import com.paccy.banking_system.customer.repositories.CustomerRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthService {

    private static final Logger log = LoggerFactory.getLogger(AuthService.class);
    private final CustomerRepository customerRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsServiceImpl userDetailsService;

    public ResponseEntity<AuthResponse> register(RegistrationRequest registrationRequest) {


//        Creation of customer
            var customer = Customer
                    .builder()
                    .id(registrationRequest.id())
                    .firstName(registrationRequest.firstName())
                    .lastName(registrationRequest.lastName())
                    .email(registrationRequest.email())
                    .phoneNumber(registrationRequest.phoneNumber())
                    .password(passwordEncoder.encode(registrationRequest.password()))
                    .address(Address
                            .builder()
                            .street(registrationRequest.address().getStreet())
                            .houseNumber(registrationRequest.address().getHouseNumber())
                            .zipCode(registrationRequest.address().getZipCode())
                            .build())
                    .role(registrationRequest.role())
                    .build();

            customerRepository.save(customer);
        UserDetails userDetails = userDetailsService.loadUserByUsername(registrationRequest.email());



        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, registrationRequest.password(),
                userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        Map<String, Object> claims = new HashMap<>();
        claims.put("email",customer.getEmail());
            String token = jwtService.generateToken(claims,userDetails);
            //        Setting  up auth cookies
            ResponseCookie authCookie = ResponseCookie.from("token", token).maxAge(6000).build();
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.SET_COOKIE, authCookie.toString());
            AuthResponse authResponse = new AuthResponse(token);

            return ResponseEntity.ok().headers(headers).body(authResponse);


        }

    public ResponseEntity<AuthResponse> signin(LoginRequest loginRequest) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.email());



        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, loginRequest.password(),
                userDetails.getAuthorities());
//        Current Authentication status
            System.out.println(authentication);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.email(),loginRequest.password())
        );

       Customer customer= customerRepository.findByEmail(loginRequest.email())
                .orElseThrow(()-> new UsernameNotFoundException("Customer not found,please try again"));
        Map<String, Object> claims = new HashMap<>();
        claims.put("email",customer.getEmail());

        String token= jwtService.generateToken(claims,userDetails);

//        Setting  up auth cookies
        ResponseCookie authCookie=ResponseCookie.from("token",token).maxAge(6000).build();
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.SET_COOKIE,authCookie.toString());

        AuthResponse authResponse= new AuthResponse(token);

        return ResponseEntity.ok().headers(headers).body(authResponse);
    }

    public ResponseEntity<?> logoutUser(HttpServletRequest request) {
        try {


            SecurityContextHolder.clearContext();
            String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
            if (authHeader != null && authHeader.startsWith("Bearer ")) {
                String token = authHeader.substring(7);
                jwtService.invalidateToken(token);
            }

        }
        catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        return ResponseEntity.ok().body("Logged out successfully");
    }
}

