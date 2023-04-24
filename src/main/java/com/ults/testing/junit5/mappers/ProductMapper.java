package com.ults.testing.junit5.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.ults.testing.junit5.entities.Product;
import com.ults.testing.junit5.model.ProductDto;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDto productToProductDto(Product product);
    
    Product productDtoToProduct(ProductDto productDto);
    
}
