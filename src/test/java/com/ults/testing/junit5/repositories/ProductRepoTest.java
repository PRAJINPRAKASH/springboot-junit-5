package com.ults.testing.junit5.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.ults.testing.junit5.model.ProductNameDto;

@DataJpaTest
public class ProductRepoTest {

    @Autowired
    ProductRepo productRepo;

    @Test
    void testFindBy() {
        Pageable pageable = PageRequest.of(0,3);
         Page<ProductNameDto> products =  productRepo.findBy(pageable);
         assertEquals(2, products.getNumberOfElements());
         
         assertThat(products.getContent())
         .hasSize(2)

         .allMatch(x -> x.getName() != null)
         .allMatch(x -> x.getId() != null)
         .anyMatch(x -> "p1".equals(x.getName()))
         .anyMatch(x -> "p2".equals(x.getName()))
         .noneMatch(x -> "".equals(x.getName()));
              

    }
}
