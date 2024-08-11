package com.kozak_burger.KozakBurgerShop.security.sec_service;

import com.kozak_burger.KozakBurgerShop.domain.entity.Role;
import com.kozak_burger.KozakBurgerShop.domain.entity.User;
import com.kozak_burger.KozakBurgerShop.repository.RoleRepository;
import com.kozak_burger.KozakBurgerShop.security.AuthInfo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;


@Service
public class TokenService {

    private SecretKey accessKey;
    private SecretKey refreshKey;
    private RoleRepository roleRepository;

    public TokenService(
                        @Value("${key.access}") String accessSecretPhrase,
                        @Value("${key.refresh}") String refreshSecretPhrase,
                        RoleRepository roleRepository
                       )
    {
        this.accessKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(accessSecretPhrase));
        this.refreshKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(refreshSecretPhrase));
        this.roleRepository = roleRepository;
    }

    public String generateAccessToken(User user) {
        LocalDateTime actualDate = LocalDateTime.now();
        Instant tokenExpiration = actualDate.plusHours(2).atZone(ZoneId.systemDefault()).toInstant();
        Date expirationDate = Date.from(tokenExpiration);

        //LocalDateTime expiresAt = now.plusHours(2);
        return Jwts.builder()
            .subject(user.getUsername())
            .expiration(expirationDate)
            .signWith(accessKey)
            .claim("roles", user.getAuthorities())
            .claim("name", user.getUsername())
            .compact();
    }

    public String generateRefreshToken(User user) {
        LocalDateTime actualDate = LocalDateTime.now();
        Instant tokenExpiration = actualDate.plusHours(24).atZone(ZoneId.systemDefault()).toInstant();
        Date expirationDate = Date.from(tokenExpiration);

        //LocalDateTime expiresAt = now.plusHours(2);
        return Jwts.builder()
                .subject(user.getUsername())
                .expiration(expirationDate)
                .signWith(refreshKey)
                .compact();
    }

    public boolean validateAccessToken(String accessToken) {
    return validateToken(accessToken, accessKey);
    }

    public boolean validateRefreshToken(String refreshToken) {
        return validateToken(refreshToken, refreshKey);
    }

    private boolean validateToken(String token, SecretKey key) {
        try {
            Jwts.parser().verifyWith(key).build().parseSignedClaims(token);

            return true;
        } catch (Exception e) {
            return false;

        }
    }

    public Claims getAccessClaims(String accessToken) {
        return getClaims(accessToken, accessKey);
    }

    public Claims getRefreshClaims(String refreshToken) {
        return getClaims(refreshToken, refreshKey);
    }
    
//getClaimsFromToken
    private Claims getClaims(String token, SecretKey key) {
         return Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload();

    }

    public AuthInfo mapClaimsToAuthInfo(Claims claims) {
        String username = claims.getSubject();


        List<LinkedHashMap<String, String>> rolesList = (List<LinkedHashMap<String, String>>) claims.get("roles");

        Set<Role> roles = new HashSet<>();

        for (LinkedHashMap<String, String> roleEntry : rolesList) {
            String roleTitle = roleEntry.get("authority");
            Role role = roleRepository.findByTitle(roleTitle).orElse(null);
            if (role != null) {
                roles.add(role);
            }

        }
            return new AuthInfo(username, roles);
    }

}
