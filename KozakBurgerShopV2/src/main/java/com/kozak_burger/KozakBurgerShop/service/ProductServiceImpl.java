
package com.kozak_burger.KozakBurgerShop.service;
import com.kozak_burger.KozakBurgerShop.domain.entity.Product;
import com.kozak_burger.KozakBurgerShop.repository.ProductRepository;
import com.kozak_burger.KozakBurgerShop.service.interfaces.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {


    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }


    @Override
    public Product save(Product product) {
        product.setId(null); //невозможно ид поменять
        product.setActive(true);
        return repository.save(product);
    }

    @Override
    public List<Product> getAllActiveProducts() {
        return repository.findAll().stream().filter(Product::isActive).toList();
        }

        // List<Product> products = repository.findAll();
        // Iterator<Product> iterator = products.iterator();
        // while (iterator.hasNext()) { if (!iterator.next().isActive()) { iterator.remove(); }}

    @Override
    public Product getById(Long id) {
        Product product = repository.findById(id).orElse(null);

        if (product == null || !product.isActive()) {
            return null;

        }

        return product;
    }

    @Override
    public Product update(Product product) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void deleteByTitle(String title) {

    }

    @Override
    public void restoreById(Long id) {

    }

    @Override
    public long getActiveProductsQuantity() {
        return 0;
    }

    @Override
    public BigDecimal getActiveProductsTotalPrice() {
        return null;
    }

    @Override
    public BigDecimal getActiveProductsAveragePrice() {
        return null;
    }
}
