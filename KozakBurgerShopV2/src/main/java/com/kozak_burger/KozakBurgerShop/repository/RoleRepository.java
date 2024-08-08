package com.kozak_burger.KozakBurgerShop.repository;

import com.kozak_burger.KozakBurgerShop.domain.entity.Role;
import com.kozak_burger.KozakBurgerShop.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

//    Optional<Role> findByTitle(String title);
    Role findByTitle(String title);
}