/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MamoiTube.MamoiTube.Security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import org.springframework.stereotype.Component;

/**
 *
 * @author mr587
 */
@Component
public class JwtProvider {
    
    private static final String SECRET_KEY = "MySecretKeyForJWTTokenGenerationMySecretKey"; 
    private static final long EXPIRATION_TIME = 86400000; // 1 día en milisegundos

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
    }

    public String generateToken(String correo) {
        return Jwts.builder()
                .setSubject(correo)
                .setIssuedAt(new Date()) 
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256) 
                .compact();
    }

    public String getUsernameFromToken(String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(getSigningKey())
                    .build()
                    .parseClaimsJws(token.trim())
                    .getBody()
                    .getSubject();
        } catch (ExpiredJwtException e) {
            throw new RuntimeException("Token expirado. Iniciá sesión otra vez.");
        } catch (JwtException e) {
            throw new RuntimeException("Token inválido. Autenticación fallida.");
        }
    }

    public boolean validateToken(String token) {
        try {
            Jws<Claims> claimsJws = Jwts.parserBuilder()
                    .setSigningKey(getSigningKey())
                    .build()
                    .parseClaimsJws(token.trim());

            return !claimsJws.getBody().getExpiration().before(new Date());
        } catch (ExpiredJwtException e) {
            System.err.println("Token expirado: " + e.getMessage());
        } catch (JwtException e) {
            System.err.println("Token inválido: " + e.getMessage());
        }
        return false;
    }
}
