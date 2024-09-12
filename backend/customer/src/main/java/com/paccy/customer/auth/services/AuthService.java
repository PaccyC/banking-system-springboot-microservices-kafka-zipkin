package com.paccy.customer.auth.services;

import com.paccy.customer.auth.AuthResponse;
import com.paccy.customer.auth.LoginRequest;
import com.paccy.customer.auth.RegistrationRequest;
import com.paccy.customer.entities.Address;
import com.paccy.customer.entities.Customer;
import com.paccy.customer.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final CustomerRepository customerRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsServiceImpl userDetailsService;

    public AuthResponse register(RegistrationRequest registrationRequest) {

        UserDetails userDetails = userDetailsService.loadUserByUsername(registrationRequest.email());



        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, registrationRequest.password(),
                userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
//        Creation of customer
        var customer= Customer
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
                .build() ;


        customer= customerRepository.save(customer);
        String token= jwtService.generateToken(authentication);

        return new AuthResponse(token);


    }

    public AuthResponse signin(LoginRequest loginRequest) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.email());



        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, loginRequest.password(),
                userDetails.getAuthorities());
        System.out.println(authentication);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.email(),loginRequest.password())
        );
        Customer customer= customerRepository.findByEmail(loginRequest.email())
                .orElseThrow(()-> new UsernameNotFoundException("Customer not found,please try again"));

        String token= jwtService.generateToken(authentication);
        return new AuthResponse(token);
    }
}
