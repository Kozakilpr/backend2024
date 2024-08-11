package com.kozak_burger.KozakBurgerShop.service.mapping;

import com.kozak_burger.KozakBurgerShop.domain.dto.CartDto;
import com.kozak_burger.KozakBurgerShop.domain.dto.ProductDto;
import com.kozak_burger.KozakBurgerShop.domain.entity.Cart;
import com.kozak_burger.KozakBurgerShop.domain.entity.Product;
import com.kozak_burger.KozakBurgerShop.service.mapping.ProductMappingService;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ProductMappingService.class)
public interface CartMappingService

{
	
	Cart mapDtoToEntity(CartDto dto);

    CartDto mapEntityToDto(Cart entity);

}
/*        @Mapping(target = "id", ignore = true)
        @Mapping(target = "active", constant = "true")
        Product mapDtoToEntity(CartDto dto);

        ProductDto mapEntityToDto(Product entity);
		
*/ 
