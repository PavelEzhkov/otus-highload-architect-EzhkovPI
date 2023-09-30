package com.example.otushighloadarchitectezhkovpi.security;

import com.example.otushighloadarchitectezhkovpi.entity.User;
import com.example.otushighloadarchitectezhkovpi.exception.UnauthorizedException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.util.Date;

@Component
public class JwtTokenProvider {

    private static final long JWT_TOKEN_VALIDITY_TIME = 60 * 60 * 1000;
    private static final SecretKey SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String generateToken(User user) {
        return Jwts.builder()
                .setSubject(user.getId().toString())
                .setExpiration(Date.from(Instant.now().plusSeconds(JWT_TOKEN_VALIDITY_TIME)))
                .signWith(SECRET_KEY)
                .claim("firstName", user.getFirstName())
                .claim("secondName", user.getSecondName())
                .compact();
    }

    public Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token).getBody();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(SECRET_KEY)
                    .build()
                    .parse(token);
            return true;
        } catch (RuntimeException e) {
            throw new UnauthorizedException();
        }
    }
}
