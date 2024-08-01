
package com.kozak_burger.KozakBurgerShop.controller;
import com.kozak_burger.KozakBurgerShop.domain.entity.Product;
import com.kozak_burger.KozakBurgerShop.service.interfaces.ProductService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    // POST localhost:8080/product/example ("/request")

    @PostMapping
    public Product save(@RequestBody Product product) {
    return service.save(product);
    }

    @GetMapping
    public List<Product> get(@RequestParam(required = false) Long id) {
        if (id == null) {
           return service.getAllActiveProducts();
        } else {
            Product product = service.getById(id);
            return product == null ? null : List.of(product);
        }

    }

    @PutMapping
    public Product update(@RequestBody Product product) {
        return service.update(product);
    }

    @DeleteMapping
    public void delete(@RequestParam(required = false) Long id, @RequestParam(required = false) String title)
    {
        if (id != null) {
            service.deleteById(id);
        } else if (title != null) {
            service.deleteByTitle(title);
        }
    }

    @PutMapping("/restore")
    public void restore(@RequestParam Long id) {
        service.restoreById(id);
    }

    @GetMapping("/quantity")
    public long getQuantity() {
        return service.getActiveProductsQuantity();
    }

    @GetMapping("/totalPrice")
    public BigDecimal getTotalPrice() {
        return service.getActiveProductsTotalPrice();
    }

    @GetMapping("/averagePrice")
    public BigDecimal getAveragePrice() {
        return service.getActiveProductsAveragePrice();
    }

}