
package com.kozak_burger.KozakBurgerShop.service.mapping;

import com.kozak_burger.KozakBurgerShop.domain.dto.ProductDto;
import com.kozak_burger.KozakBurgerShop.domain.entity.Product;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;



@Mapper(componentModel = "spring")
//public class ProductMappingService {
public interface ProductMappingService {
	
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "active", constant = "true")
	Product mapDtoToEntity(ProductDto dto);

	ProductDto mapEntityToDto(Product entity);

}
