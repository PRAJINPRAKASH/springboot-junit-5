package com.ults.testing.junit5.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ults.testing.junit5.mappers.ProductMapper;
import com.ults.testing.junit5.model.ProductDto;
import com.ults.testing.junit5.model.ProductNameDto;
import com.ults.testing.junit5.repositories.ProductRepo;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;




    public ProductDto saveProduct(ProductDto product) {
        return ProductMapper
        .INSTANCE
        .productToProductDto(productRepo.save(ProductMapper.INSTANCE.productDtoToProduct(product)));
    }

    public void deleteProduct(Long id) {
        productRepo.deleteById(id);
    }

    public Page<ProductDto> getProducts(Pageable page){
        Page<ProductDto> response = productRepo
        .findAll(page)
        .map(ProductMapper.INSTANCE::productToProductDto);

        response.forEach(product -> product.setTotalPrice(product.getPrice() * product.getQuantity()));

        return response;
    }

    public Page<ProductNameDto> getProductNames(Pageable page){

        return productRepo.findBy(page);
    }
    
    
}
