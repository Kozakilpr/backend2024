package com.kozak_burger.KozakBurgerShop.security.sec_filter;

import com.kozak_burger.KozakBurgerShop.security.sec_service.TokenService;
import com.kozak_burger.KozakBurgerShop.security.AuthInfo;
import com.kozak_burger.KozakBurgerShop.security.*;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;


@Component
public class TokenFilter extends GenericFilterBean {

    private TokenService service;

    public TokenFilter(TokenService service) {
        this.service = service;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException
    {

        String token = getTokenFromRequest((HttpServletRequest) request);

        if (token != null && service.validateAccessToken(token))
        {
            Claims claims = service.getAccessClaims(token);
            AuthInfo authInfo = service.mapClaimsToAuthInfo(claims);
            authInfo.setAuthenticated(true);
            SecurityContextHolder.getContext().setAuthentication(authInfo);
        }

        filterChain.doFilter(request,response);

    }





    private String getTokenFromRequest(HttpServletRequest request)
    {
        String token = request.getHeader("Authorization");
        // получим содержимое хеда: Bearer fsfd8s7fsudfhjsafkjdshfysf78s9f7sdfadf

        if (token != null && token.startsWith("Bearer")) {
            return token.substring(7);
        }
        return null;
    }

}