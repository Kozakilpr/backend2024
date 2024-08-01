
package com.kozak_burger.KozakBurgerShop.service;
import com.kozak_burger.KozakBurgerShop.domain.dto.ProductDto;
import com.kozak_burger.KozakBurgerShop.domain.entity.Product;
import com.kozak_burger.KozakBurgerShop.repository.ProductRepository;
import com.kozak_burger.KozakBurgerShop.service.interfaces.ProductService;
import com.kozak_burger.KozakBurgerShop.service.mapping.ProductMappingService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {


    private final ProductRepository repository;
    private final ProductMappingService mappingService;

    public ProductServiceImpl(ProductRepository repository, ProductMappingService mappingService) {
        this.repository = repository;
        this.mappingService = mappingService;
    }


    @Override
    public ProductDto save(ProductDto dto) {
        Product entity = mappingService.mapDtoToEntity(dto);
        repository.save(entity);
        return  mappingService.mapEntityToDto(entity);
    }

    @Override
    public List<ProductDto> getAllActiveProducts() {
        return repository.findAll().stream().filter(Product::isActive).map(mappingService::mapEntityToDto).toList();
        }

        // List<Product> products = repository.findAll();
        // Iterator<Product> iterator = products.iterator();
        // while (iterator.hasNext()) { if (!iterator.next().isActive()) { iterator.remove(); }}

    @Override
    public ProductDto getById(Long id) {
        Product product = repository.findById(id).orElse(null);

        if (product == null || !product.isActive()) {
            return null;

        }

        return mappingService.mapEntityToDto(product);
    }

    @Override
    public ProductDto update(ProductDto product) {
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
