package com.open.chatapp.util;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtProvider {

	private final String SECRET_KEY = "SecretSecretSecretSecretSecretSecretSecretKeySecretSecretSecretSecretSecretKSecretSecretSecretSecret";
	private final long EXPIRATION = 1000 * 60 * 60 * 24;
	
	public String generateToken(String username) {
		Date now = new Date();
		Date expDate = new Date(now.getTime() + EXPIRATION);
		return Jwts.builder()
					.setSubject(username)
					.setIssuedAt(now)
					.setExpiration(expDate)
					.signWith(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()), SignatureAlgorithm.HS256)
					.compact();
	}
	
	public String getUsernameFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()))
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()))
                .build()
                .parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }
}
