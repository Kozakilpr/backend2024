package com.kozak_burger.KozakBurgerShop.repository;

import com.kozak_burger.KozakBurgerShop.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}