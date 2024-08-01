
package com.kozak_burger.KozakBurgerShop.service.interfaces;
import com.kozak_burger.KozakBurgerShop.domain.dto.ProductDto;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
//    public void addProduct(Product product);
//    public void updateProduct(Product product);
//    public void deleteProduct(Product product);
//    public Product getProduct(int id);
//    public List<Product> getAllProducts();

    ProductDto save(ProductDto product);
    List<ProductDto> getAllActiveProducts();
    ProductDto getById(Long id);
    ProductDto update(ProductDto product);
    void deleteById(Long id);
    void deleteByTitle(String title);
    void restoreById(Long id);
    long getActiveProductsQuantity();
    BigDecimal getActiveProductsTotalPrice();
    BigDecimal getActiveProductsAveragePrice();



}
