package com.kozak_burger.KozakBurgerShop.service.interfaces;

import com.kozak_burger.KozakBurgerShop.domain.dto.CustomerDto;

import java.math.BigDecimal;
import java.util.List;

public interface CustomerService {
	
        CustomerDto save(CustomerDto customerDto);
        List<CustomerDto> getAllActiveCustomers();
        CustomerDto getById(Long id);
        CustomerDto update(CustomerDto customerDto);
        void deleteById(Long id);
        void deleteByTitle(String name);
        void restoreById(Long id);
        long getActiveCustomersQuantity();
		BigDecimal getTotalCostOfCustomersProducts(Long customerId);
		BigDecimal getAverageCostOfCustomersProducts(Long customerId);
        BigDecimal getTotalSpent(Long customerId);
		void addProductToCustomersCart(Long customerId, Long productId);
		void removeProductFromCustomersCart(Long customerId, Long productId);
		void clearCustomersCart(Long customerId);
}
