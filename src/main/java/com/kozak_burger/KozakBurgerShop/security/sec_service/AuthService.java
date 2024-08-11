package com.kozak_burger.KozakBurgerShop.security.sec_service;

import com.kozak_burger.KozakBurgerShop.domain.entity.User;
import com.kozak_burger.KozakBurgerShop.security.sec_dto.TokenResponseDto;
import com.kozak_burger.KozakBurgerShop.service.interfaces.UserService;


import io.jsonwebtoken.Claims;
import jakarta.security.auth.message.AuthException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {

    private UserService userService;
    private TokenService tokenService;
    private Map<String, String> refreshStorage;
    private BCryptPasswordEncoder passwordEncoder;

    public AuthService(UserService userService, TokenService tokenService, BCryptPasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.tokenService = tokenService;
        this.passwordEncoder = passwordEncoder;
        this.refreshStorage = new HashMap<>();
    }

    public TokenResponseDto login(User wantedUser) throws AuthException {
        String email = wantedUser.getEmail();
        User foundUser = (User) userService.loadUserByUsername(email);


        if (passwordEncoder.matches(wantedUser.getPassword(), foundUser.getPassword())) {
            String accessToken = tokenService.generateAccessToken(foundUser);
            String refreshToken = tokenService.generateRefreshToken(foundUser);
            refreshStorage.put(email, refreshToken);
            return new TokenResponseDto(accessToken, refreshToken);
        } else {
            throw new AuthException("Invalid username or password");
        }
    }

	//validateToken
    public TokenResponseDto validateToken(String incomingRefreshToken) {
        Claims refreshClaims = tokenService.getRefreshClaims(incomingRefreshToken);
        String email = refreshClaims.getSubject();
        String savedRefreshToken = refreshStorage.get(email);

        if (savedRefreshToken != null && savedRefreshToken.equals(incomingRefreshToken)) {
            User emailUser = (User) userService.loadUserByUsername(email);
            String accessToken = tokenService.generateAccessToken(emailUser);
            return new TokenResponseDto(accessToken, null);
        } else {
            return new TokenResponseDto(null, null);
        }
    }
}