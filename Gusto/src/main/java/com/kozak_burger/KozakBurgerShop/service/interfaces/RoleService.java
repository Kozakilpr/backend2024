package com.kozak_burger.KozakBurgerShop.service.interfaces;

import com.kozak_burger.KozakBurgerShop.domain.entity.Role;

import javax.management.relation.RoleNotFoundException;

public interface RoleService {

    Role getRoleUser() throws RoleNotFoundException;
}