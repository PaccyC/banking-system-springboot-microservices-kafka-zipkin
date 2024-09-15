package com.paccy.customer.auth.services;

import com.paccy.customer.entities.Customer;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class JwtService {
    private static final Logger log = LoggerFactory.getLogger(JwtService.class);
    private final String SECRET_KEY="bbb2JvLuOKbhGcbf3iw3RP3Y1leWUouWU6mxAMZk0hmQ=wiwwjewj3e82u812q281wdpqu23usg";
    private final Set<String> invalidatedTokens = new HashSet<>();
  private boolean isTokenExpired(String token) {
      return extractExpiration(token).before(new Date());

  }

  public Date extractExpiration(String token) {
      return extractClaim(token,Claims::getExpiration);
  }

    public boolean isValid(String token, UserDetails user) {
        String username = extractUsername(token);
        return (username.equals(user.getUsername())) && !isTokenExpired(token);
    }

  public String extractUsername(String token) {
    return extractClaim(token,Claims::getSubject);
  }

  public  <T> T extractClaim(String token, Function<Claims,T> claimsResolver) {
      Claims claims= extractAllClaims(token);
      return claimsResolver.apply(claims);
  }

  public Claims extractAllClaims(String token){
      return Jwts
              .parser()
              .verifyWith(getSignInKey())
              .build()
              .parseSignedClaims(token)
              .getPayload();
  }

    public SecretKey getSignInKey() {
      byte[] keyBytes = Decoders.BASE64URL.decode(SECRET_KEY);
      return Keys.hmacShaKeyFor(keyBytes);
    }
    public String generateToken(Authentication authentication) {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        String roles = populateAuthorities(authorities);

        System.out.println(roles);
        // Include roles in the token claims
        String token = Jwts.builder()
                .claim("user", authentication.getPrincipal())
                .claim("username",authentication.getName())
                .claim("authorities", roles)  // Make sure "authorities" is added
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000))  // 1 day expiration
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();

        return token;
    }

    private static String populateAuthorities(Collection<? extends GrantedAuthority> authorities) {
        Set<String> auths = new HashSet<>();
        for (GrantedAuthority authority : authorities) {
            auths.add(authority.getAuthority());
        }
        return String.join(",", auths);
    }

    private void invalidateToken(String token) {
      invalidatedTokens.add(token);
    }

    private boolean isTokenInvalidated(String token) {
      return invalidatedTokens.contains(token);
    }


}
