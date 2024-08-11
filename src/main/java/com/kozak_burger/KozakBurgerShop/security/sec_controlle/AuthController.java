package com.kozak_burger.KozakBurgerShop.security.sec_controlle;

import com.kozak_burger.KozakBurgerShop.domain.entity.User;
import com.kozak_burger.KozakBurgerShop.security.sec_dto.RefreshRequestDto;
import com.kozak_burger.KozakBurgerShop.security.sec_dto.TokenResponseDto;
import com.kozak_burger.KozakBurgerShop.security.sec_service.AuthService;
import jakarta.security.auth.message.AuthException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public TokenResponseDto login(@RequestBody User email) {
        try {
            return service.login(email);
        } catch (AuthException e) {
            return new TokenResponseDto(null, null);
        }

    }

    @PostMapping("/refresh")
    public TokenResponseDto getNewAccessToken(@RequestBody RefreshRequestDto request) {
    return service.validateToken(request.getRefreshToken());
    }
}