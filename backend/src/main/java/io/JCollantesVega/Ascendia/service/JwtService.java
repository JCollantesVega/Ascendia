package io.JCollantesVega.Ascendia.service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
    //clave secreta para firmar el token
    private static final String SECRET_KEY = "DwE2+3HcrMsV61eOy+jffOBItISxhFCD557bIHVJpdc=";


    //generar token
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();

        return createToken(claims, userDetails);
    }

    //crear token para el usuario
    public String createToken(Map<String, Object> claims, UserDetails userDetails) {
        return Jwts.builder()
        .setClaims(claims)
        .setSubject(userDetails.getUsername())
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60* 60 *24)) // 1 dia
        .signWith(getSignInKey(), SignatureAlgorithm.HS256)
        .compact();
    }

    //extraer usuario del token
    public String extractUsername(String token){
        return extractClaim(token, Claims::getSubject);
    }

    //extraer cualquier informacion del token
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    //extraer informacion del token
    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
        .setSigningKey(getSignInKey())
        .build()
        .parseClaimsJws(token)
        .getBody();
    }

    //obtener key para firmar el token
    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    //validar token
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    //validar si el token ha expirado
    public boolean isTokenExpired(String token) {
        return extractClaim(token, Claims::getExpiration).before(new Date());
    }
}
