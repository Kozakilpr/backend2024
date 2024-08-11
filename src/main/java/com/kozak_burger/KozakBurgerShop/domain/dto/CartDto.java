package com.kozak_burger.KozakBurgerShop.domain.dto;

import com.kozak_burger.KozakBurgerShop.domain.dto.ProductDto;

import java.util.List;
import java.util.Objects;

public class CartDto {
	
    private Long id;
    private List<ProductDto> products;
	
	//    private CustomerDto customer;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
	
    public List<ProductDto> getProducts() {
        return products;
    }


    public void setProducts(List<ProductDto> products) {
        this.products = products;
    }
	
//	    public void setCustomer(CustomerDto customer) {
//        this.customer = customer;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartDto cartDto = (CartDto) o;
        return Objects.equals(id, cartDto.id) && Objects.equals(products, cartDto.products);
    }

//&& Objects.equals(customer, cartDto.customer)  customer,

    @Override
    public int hashCode() {
        return Objects.hash(id, products);
    }
	
	@Override
    public String toString() {
        return String.format("Cart: id - %d, contains %d products",
                id, products == null ? 0 : products.size());
    }
}
