package com.kozak_burger.KozakBurgerShop.service;

import com.kozak_burger.KozakBurgerShop.domain.dto.CustomerDto;
import com.kozak_burger.KozakBurgerShop.domain.entity.Customer;
import com.kozak_burger.KozakBurgerShop.domain.entity.Cart;
import com.kozak_burger.KozakBurgerShop.repository.CustomerRepository;
import com.kozak_burger.KozakBurgerShop.service.interfaces.CustomerService;
import com.kozak_burger.KozakBurgerShop.service.mapping.CustomerMappingService;

import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;
import jakarta.transaction.Transactional;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;
//    private final CustomerMappingService mappingService;

    public CustomerServiceImpl(CustomerRepository repository, CustomerMappingService mappingService) 
	{
        this.repository = repository;
//		this.mappingService = mappingService;
    }

    @Override
//	@Transactional
    public CustomerDto save(CustomerDto dto) {

        Customer customer = convertToEntity(dto);
        customer.setId(null); // Ensure new entity creation
        customer.setActive(true);
        return convertToDto(repository.save(customer));
    }

	/*

 Customer entity = mappingService.mapDtoToEntity(dto);

        Cart cart = new Cart();
        cart.setCustomer(entity);
        entity.setCart(cart);

        repository.save(entity);
        return mappingService.mapEntityToDto(entity);

*/

    @Override
    public List<CustomerDto> getAllActiveCustomers() {
        return repository.findAll().stream()
                .filter(Customer::isActive)
                .map(this::convertToDto)
                .collect(Collectors.toList());
				
				//.map(mappingService::mapEntityToDto)
                //.toList();
    }

    @Override
    public CustomerDto getById(Long id) {
        return repository.findById(id)
                .filter(Customer::isActive)
                .map(this::convertToDto)
                .orElse(null);
				
    }
	
	/*  Customer customer = repository.findById(id).orElse(null);

        if (customer != null && customer.isActive()) {
            return mappingService.mapEntityToDto(customer);
        }

        return null;*/
		

    @Override
	//@Transactional
    public CustomerDto update(CustomerDto dto) {
        Customer customer = convertToEntity(dto);
        return convertToDto(repository.save(customer));
    }
	
	/* Long id = dto.getId();
        Customer customer = repository.findById(id).orElseThrow(
                () -> new CustomerNotFoundException(id)
        );

        customer.setName(dto.getName());
        return mappingService.mapEntityToDto(customer);
	*/

    @Override
    public void deleteById(Long id) {
        repository.findById(id).ifPresent(customer -> {
            customer.setActive(false);
            repository.save(customer);
        });
    }

    @Override
    public void deleteByName(String name) {
        List<Customer> customers = repository.findByName(name);
        for (Customer customer : customers) {
            customer.setActive(false);
            repository.save(customer);
        }
    }

    @Override
    public void restoreById(Long id) {
        repository.findById(id).ifPresent(customer -> {
            customer.setActive(true);
            repository.save(customer);
        });
    }

    @Override
    public long getActiveCustomersQuantity() {
        return 0;
    }

    @Override
    public BigDecimal getTotalCostOfCustomersProducts(Long customerId) {
        return null;
    }

    @Override
    public BigDecimal getAverageCostOfCustomersProducts(Long customerId) {
        return null;
    }

    @Override
    public BigDecimal getTotalSpent(Long customerId) {
        return null;
    }

    @Override
    public void addProductToCustomersCart(Long customerId, Long productId) {

    }

    @Override
    public void removeProductFromCustomersCart(Long customerId, Long productId) {

    }

    @Override
    public void clearCustomersCart(Long customerId) {

    }

//    @Override
//    public long getActiveCustomersQuantity() {
//        return repository.countByActive(true);
//    }
//
//    @Override
//    public BigDecimal getActiveCustomersTotalPrice() {
//        return repository.findAll().stream()
//                .filter(Customer::isActive)
//                .map(Customer::getTotalPrice)
//                .reduce(BigDecimal.ZERO, BigDecimal::add);
//    }

//    @Override
//    public BigDecimal getActiveCustomersAveragePrice() {
//        List<Customer> activeCustomers = repository.findAll().stream()
//                .filter(Customer::isActive)
//                .collect(Collectors.toList());
//
//        if (activeCustomers.isEmpty()) {
//            return BigDecimal.ZERO;
//        }
//
//        BigDecimal totalPrice = activeCustomers.stream()
//                .map(Customer::getTotalPrice)
//                .reduce(BigDecimal.ZERO, BigDecimal::add);
//
//        return totalPrice.divide(new BigDecimal(activeCustomers.size()), RoundingMode.HALF_UP);
//    }

//    @Override
//    public BigDecimal getTotalSpent(Long customerId) {
//
//        return BigDecimal.ZERO;
//    }

    private Customer convertToEntity(CustomerDto dto) {
        if (dto == null) {
            return null;
        }
        Customer customer = new Customer();
        customer.setId(dto.getId());
        customer.setName(dto.getName());
        customer.setSurname(dto.getSurname());
        customer.setStreet(dto.getStreet());
        customer.setCity(dto.getCity());
        customer.setPostalAddress(dto.getPostalAddress());
        customer.setEmail(dto.getEmail());
        return customer;
    }

    private CustomerDto convertToDto(Customer customer) {
        if (customer == null) {
            return null;
        }
        CustomerDto dto = new CustomerDto();
        dto.setId(customer.getId());
        dto.setName(customer.getName());
        dto.setSurname(customer.getSurname());
        dto.setStreet(customer.getStreet());
        dto.setCity(customer.getCity());
        dto.setPostalAddress(customer.getPostalAddress());
        dto.setEmail(customer.getEmail());
        return dto;
		

//		 @Override
//		public CustomerDto getActiveCustomerById(Long id) {
//        Customer customer = repository.findById(id).orElseThrow(
//                () -> new CustomerNotFoundException(id)
//        );
//
//        if (!customer.isActive()) {
//            throw new CustomerInactiveException(id);
//        }
//
//        return mappingService.mapEntityToDto(customer);

//            }

    }
}
