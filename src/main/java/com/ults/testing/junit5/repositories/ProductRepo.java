package com.ults.testing.junit5.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ults.testing.junit5.entities.Product;
import com.ults.testing.junit5.model.ProductNameDto;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long>{
    
    Page<ProductNameDto> findBy(Pageable pageable);
}
