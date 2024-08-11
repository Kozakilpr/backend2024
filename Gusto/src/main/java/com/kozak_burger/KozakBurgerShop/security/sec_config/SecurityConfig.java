package com.kozak_burger.KozakBurgerShop.security.sec_config;

import com.kozak_burger.KozakBurgerShop.security.sec_filter.TokenFilter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	
	    private TokenFilter filter;

    public SecurityConfig(TokenFilter filter) {
        this.filter = filter;
    }

	@Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
	
    //запрос проверяетсья
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(x -> x
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .httpBasic(AbstractHttpConfigurer::disable)
              .httpBasic(Customizer.withDefaults())
                .authorizeHttpRequests(x -> x
                       .requestMatchers(HttpMethod.GET, "/product/all").permitAll()
//                       .requestMatchers(HttpMethod.GET, "/product/all").hasAnyRole("ADMIN", "USER")
                       .requestMatchers(HttpMethod.POST, "/product").hasRole("ADMIN")
                       .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()

//                       .requestMatchers(HttpMethod.POST, "/register").permitAll()
//                       .requestMatchers(HttpMethod.GET, "/register").permitAll()
//					   .anyRequest().permitAll()
               )
                .addFilterAfter(filter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}