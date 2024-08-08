package com.kozak_burger.KozakBurgerShop.controller;


import com.kozak_burger.KozakBurgerShop.service.interfaces.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/system")
public class SystemController {

    private final ProductService productService;

    public SystemController(ProductService productService) {
        this.productService = productService;
    }

}