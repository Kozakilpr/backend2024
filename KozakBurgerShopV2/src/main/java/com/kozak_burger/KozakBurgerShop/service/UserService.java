package com.kozak_burger.KozakBurgerShop.service;

import com.kozak_burger.KozakBurgerShop.domain.entity.User;
import com.kozak_burger.KozakBurgerShop.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

//        return repository.findByUsername(username).orElseThrow(
//                () -> new UsernameNotFoundException(
//                        String.format("User %s not found", username)));
//    }

        User user = repository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("User %s not found", username));
        }
        return user;
    }

}
