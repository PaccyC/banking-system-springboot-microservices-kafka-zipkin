package com.paccy.banking_system.customer.auth.services;

import com.paccy.banking_system.customer.entities.Customer;
import com.paccy.banking_system.customer.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Customer customer= customerRepository.findByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException("Customer not found"));


        List<SimpleGrantedAuthority> authorities = customer.getRole().getAuthorities();
        System.out.println(authorities);

        return new org.springframework.security.core.userdetails.User(
                customer.getEmail(),
                customer.getPassword(),
                authorities);
    }
}
