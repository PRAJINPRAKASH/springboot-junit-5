package com.ults.testing.junit5.controllers;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ults.testing.junit5.model.ProductDto;
import com.ults.testing.junit5.model.ProductNameDto;
import com.ults.testing.junit5.services.ProductService;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping()
    public Page<ProductDto> getAllProducts(Pageable page) {
        return productService.getProducts(page);
    }

    @PostMapping()
    public ProductDto createProductById(@RequestBody ProductDto product) {
        return productService.saveProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
    }

    @GetMapping("/name")
    public Page<ProductNameDto> getAllProductNames(Pageable page) {
        return productService.getProductNames(page);
    }
}
