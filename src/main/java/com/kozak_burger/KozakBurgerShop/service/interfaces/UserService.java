package com.kozak_burger.KozakBurgerShop.service.interfaces;

import com.kozak_burger.KozakBurgerShop.domain.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.kozak_burger.KozakBurgerShop.domain.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.management.relation.RoleNotFoundException;

public interface UserService extends UserDetailsService {
    @Override
    UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;

    void register(User user) throws RoleNotFoundException;
}