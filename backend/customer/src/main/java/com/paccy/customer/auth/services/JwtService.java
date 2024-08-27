package com.paccy.customer.auth.services;

import com.paccy.customer.entities.Customer;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService {
    private final String SECRET_KEY="bbb2JvLuOKbhGcbf3iw3RP3Y1leWUouWU6mxAMZk0hmQ=wiwwjewj3e82u812q281wdpqu23usg";
  private boolean isTokenExpired(String token) {
      return extractExpiration(token).before(new Date());

  }

  public Date extractExpiration(String token) {
      return extractClaim(token,Claims::getExpiration);
  }

  public boolean isValid(String token,UserDetails user) {
      String username= extractUsername(token);
      return (username.equals(user.getUsername())) && isTokenExpired(token);
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


    public String generateToken(Customer customer){
      String token=Jwts
              .builder()
              .subject(customer.getEmail())
              .issuedAt(new Date(System.currentTimeMillis()))
              .expiration(new Date(System.currentTimeMillis()+ 24*60*60*1000))
              .signWith(getSignInKey(), SignatureAlgorithm.HS256)
              .compact();

      return token;
    }


}
