package com.example.homeassignmentapi.mapping;

import com.example.homeassignmentapi.dto.ProductDTO;
import com.example.homeassignmentapi.entity.Product;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)
public interface ProductEntityDTOMapper {
    Product sourceToDestination(ProductDTO source);
    @Mapping(target = "imageUrl", ignore = true)
    ProductDTO destinationToSource(Product destination);
    List<ProductDTO> map(List<Product> products);

    void update(@MappingTarget Product entity, ProductDTO updateDTO);

}
