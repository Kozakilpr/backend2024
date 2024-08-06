package com.kozak_burger.KozakBurgerShop.controller;

import com.kozak_burger.KozakBurgerShop.domain.dto.CustomerDto;
import com.kozak_burger.KozakBurgerShop.domain.entity.Customer;
import com.kozak_burger.KozakBurgerShop.service.interfaces.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping
    public CustomerDto save(@RequestBody CustomerDto customer) {
        return service.save(customer);
    }

    @GetMapping
    public List<CustomerDto> get(@RequestParam(required = false) Long id) {
        if (id == null) {
            return service.getAllActiveCustomers();
        } else {
        CustomerDto customerDto = service.getById(id);
            return customerDto == null ? List.of() : List.of(customerDto);
        }
    }

    @PutMapping
    public CustomerDto update(@RequestBody CustomerDto customer) {
        return service.update(customer);
    }

    @DeleteMapping
    public void delete(@RequestParam (required = false) Long id, @RequestParam(required = false) String name)
	{
        if (id != null) {
            service.deleteById(id);
        } else if (name != null) {
            service.deleteByTitle(name);
        }
    }

    @GetMapping("/totalSpent")
    public BigDecimal getTotalSpent(@RequestParam Long customerId) {
        return service.getTotalSpent(customerId);
    }
	
	    @PutMapping("/restore")
    public void restore(@RequestParam Long id) {
        service.restoreById(id);
    }

//    @GetMapping("/number")
//    public long getCustomersNumber() {
//        return service.getActiveCustomersNumber();
//    }
	
//	@GetMapping("/cart-cost")
//    public BigDecimal getCartTotalCost(@RequestParam Long customerId) {
//        return service.getCartTotalCost(customerId);
//    }
//
//	@GetMapping("/avg-product-cost")
//    public BigDecimal getAverageProductCost(@RequestParam Long customerId) {
//        return service.getAverageProductCost(customerId);
//    }
	

    @GetMapping("/{id}/cart-total-cost")
    public BigDecimal getTotalCostOfCustomersProducts(@PathVariable Long id) {
        return service.getTotalCostOfCustomersProducts(id);
    }

    @GetMapping("/{id}/cart-average-cost")
    public BigDecimal getAverageCostOfCustomersProducts(@PathVariable Long id) {
        return service.getAverageCostOfCustomersProducts(id);
    }

    @PutMapping("/{customerId}/add-product/{productId}")
    public void addProductToCustomersCart(
            @PathVariable Long customerId,
            @PathVariable Long productId
    ) {
        service.addProductToCustomersCart(customerId, productId);
    }

    @DeleteMapping("/{customerId}/remove-product/{productId}")
    public void removeProductFromCustomersCart(
            @PathVariable Long customerId,
            @PathVariable Long productId
    ) {
        service.removeProductFromCustomersCart(customerId, productId);
    }

    @DeleteMapping("/{id}/clear-cart")
    public void clearCustomersCart(@PathVariable Long id) {
        service.clearCustomersCart(id);
    }
	
}
