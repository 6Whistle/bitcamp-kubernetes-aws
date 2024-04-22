package com.erichgamma.api.common.component.security;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.erichgamma.api.user.model.UserDto;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class JwtProvider {
    @Value("${jwt.iss}")
    private String issuer;

    private final SecretKey secretKey;

    Instant expiredDate = Instant.now().plus(1, ChronoUnit.DAYS);

    public JwtProvider(@Value("${jwt.secret}") String secretKey){
        this.secretKey = Keys.hmacShaKeyFor(Decoders.BASE64URL.decode((secretKey)));
    }

    public String createToken(UserDto user){
        return Jwts.builder()
        .signWith(secretKey)
        .issuer(issuer)
        .expiration(Date.from(expiredDate))
        .subject("bitcamp")
        .claim("username", user.getUsername())
        .claim("job", user.getJob())
        .claim("userid", user.getId())
        .compact();
    }

    public String extractTokenFromHeader(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        return bearerToken != null && bearerToken.startsWith("Bearer ") ? bearerToken.substring(7) : "";
    }

    public String getPayload(String token){
        String[] chunks = token.split("\\.");
        Base64.Decoder decoder = Base64.getDecoder();
        String payload = new String(decoder.decode(chunks[1]));

        return payload;
    }
}
