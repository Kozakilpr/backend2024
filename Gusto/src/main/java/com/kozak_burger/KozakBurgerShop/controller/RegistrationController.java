package com.kozak_burger.KozakBurgerShop.controller;

import com.kozak_burger.KozakBurgerShop.service.interfaces.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
public class RegistrationController {

    private final UserService service;

    public RegistrationController(UserService service) {
        this.service = service;
    }
}