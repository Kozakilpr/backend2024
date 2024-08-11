package com.kozak_burger.KozakBurgerShop.repository;

import com.kozak_burger.KozakBurgerShop.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

       //Optional<User> findByUsername(String username);
       User findByUsername(String username);
}
