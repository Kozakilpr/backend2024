package com.kozak_burger.KozakBurgerShop.repository;

import com.kozak_burger.KozakBurgerShop.domain.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {


    List<Customer> findByName(String name);


    long countByActive(boolean active);


}
