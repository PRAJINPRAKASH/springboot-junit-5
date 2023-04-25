package com.ults.testing.junit5.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import com.ults.testing.junit5.services.ProductService;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {
    

    @MockBean
    private ProductService productService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testCreateProductById() {

    }

    @Test
    void testDeleteProductById() {

    }

    @Test
    void testGetAllProductNames() {

    }

    @Test
    void testGetAllProducts() throws Exception {

        when(productService.getProducts(any())).thenReturn(Page.empty());

        RequestBuilder request = MockMvcRequestBuilders
        .get("/api/v1/products")
        .accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"content\":[],\"pageable\":\"INSTANCE\",\"last\":true,\"totalElements\":0,\"totalPages\":1,\"sort\":{\"sorted\":false,\"unsorted\":true,\"empty\":true},\"numberOfElements\":0,\"first\":true,\"size\":0,\"number\":0,\"empty\":true}", false));

        verify(productService).getProducts(any());        
        verify(productService, times(1)).getProducts(any());        

    }
}
