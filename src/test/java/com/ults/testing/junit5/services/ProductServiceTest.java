package com.ults.testing.junit5.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.ults.testing.junit5.model.ProductDto;
import com.ults.testing.junit5.repositories.ProductRepo;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    ProductRepo productRepo;

    @InjectMocks
    ProductService productService;

    @Test
    void testGetProducts() {
      when(productRepo.findAll(any(Pageable.class))).thenReturn(Page.empty());

      Page<ProductDto> products = productService.getProducts(PageRequest.of(0, 1));

      assertEquals(products.getSize(), 0);
      
      verify(productRepo).findAll(any(Pageable.class));        
      verify(productRepo, times(1)).findAll(any(Pageable.class));  
    }
}
