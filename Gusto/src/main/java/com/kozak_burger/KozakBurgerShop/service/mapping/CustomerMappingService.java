package com.kozak_burger.KozakBurgerShop.service.mapping;

import com.kozak_burger.KozakBurgerShop.service.mapping.CartMappingService;
import com.kozak_burger.KozakBurgerShop.domain.dto.CustomerDto;
import com.kozak_burger.KozakBurgerShop.domain.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;



@Mapper(componentModel = "spring", uses = CartMappingService.class)
public interface CustomerMappingService {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", constant = "true")
	@Mapping(target = "cart", ignore = true)
    Customer mapDtoToEntity(CustomerDto dto);

    CustomerDto mapEntityToDto(Customer entity);
}