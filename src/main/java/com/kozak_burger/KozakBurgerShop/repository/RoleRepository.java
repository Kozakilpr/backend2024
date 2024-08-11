package com.kozak_burger.KozakBurgerShop.repository;

import com.kozak_burger.KozakBurgerShop.domain.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

//    Optional<Role> findByName(String title);
    Role findByTitle(String name);
}