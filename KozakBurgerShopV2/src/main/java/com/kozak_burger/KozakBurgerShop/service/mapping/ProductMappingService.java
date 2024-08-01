
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
	
//    public Product mapDtoToEntity(ProductDto dto) {
 //       Product entity = new Product();
//   //     entity.setId(dto.getId());
//        entity.setTitle(dto.getTitle());
//        entity.setDescription(dto.getDescription());
 //       entity.setPrice(dto.getPrice());
//        entity.setActive(true);
 //       entity.setCategory(dto.getCategory());
//        entity.setImage(dto.getImage());

//        return entity;
////    }

 //   public ProductDto mapEntityToDto(Product entity) {
  //      ProductDto dto = new ProductDto();
  //      dto.setTitle(entity.getTitle());
 //       dto.setDescription(entity.getDescription());
 //       dto.setPrice(entity.getPrice());
//        dto.setCategory(entity.getCategory());
//        dto.setImage(entity.getImage());
 //       return dto;
//    }
}
