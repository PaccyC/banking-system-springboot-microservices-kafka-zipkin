package com.paccy.customer.auth;

import com.paccy.customer.auth.services.JwtService;
import com.paccy.customer.auth.services.UserDetailsServiceImpl;
import io.jsonwebtoken.Claims;
import io.micrometer.common.lang.NonNull;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    private final UserDetailsServiceImpl userDetailsService;

    @Override
    protected void doFilterInternal(
          @NonNull HttpServletRequest request,
          @NonNull HttpServletResponse response,
         @NonNull   FilterChain filterChain)
            throws ServletException, IOException {

        String authHeader= request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            response.setStatus(401);
            filterChain.doFilter(request,response);
            return;
        }
        String token=authHeader.substring(7);
        String username=jwtService.extractUsername(token);
        // Extract claims from the token
        Claims claims = jwtService.extractAllClaims(token);

        // Get authorities from the claims
        String email = String.valueOf(claims.getSubject());
        String authoritiesClaim = (String) claims.get("authorities");
        List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList(authoritiesClaim);
        System.out.println(authorities);
        System.out.println(email);
//        Here in my case, username is the email

        if (username != null && SecurityContextHolder.getContext().getAuthentication() ==null){
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            if (jwtService.isValid(token,userDetails)){
                UsernamePasswordAuthenticationToken authToken=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                authToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request) );
                SecurityContextHolder.getContext().setAuthentication(authToken);

            }
        }
        filterChain.doFilter(request,response);
    }

    @Override
    protected boolean shouldNotFilter(@NonNull  HttpServletRequest request) throws ServletException {
        return request.getServletPath().contains("/api/v1/auth");
    }
}
