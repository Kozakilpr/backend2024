package com.kozak_burger.KozakBurgerShop.service;

import com.kozak_burger.KozakBurgerShop.domain.entity.Role;
import com.kozak_burger.KozakBurgerShop.repository.RoleRepository;
import com.kozak_burger.KozakBurgerShop.service.interfaces.RoleService;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleNotFoundException;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository repository;

    public RoleServiceImpl(RoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public Role getRoleUser() throws RoleNotFoundException {
       Role role = repository.findByTitle("ROLE_USER").orElseThrow(null);

       if (role == null) {
           throw new RoleNotFoundException(String.format("Role %s not found", "ROLE_USER"));
       }
       return role;
    }
}