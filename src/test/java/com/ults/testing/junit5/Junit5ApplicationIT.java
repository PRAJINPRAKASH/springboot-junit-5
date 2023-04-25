package com.ults.testing.junit5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
class Junit5ApplicationIT {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void contextLoads() {
		String response = this.restTemplate.getForObject("/api", String.class);
		assertEquals("Hello World!",response);
	}

	@Test
	void getProducts() throws Exception{
		String response = this.restTemplate.getForObject("/api/v1/products", String.class);
		System.out.println(response);
		
		JSONAssert.assertEquals("{\"content\":[{\"id\":1,\"name\":\"p1\",\"price\":10.0,\"description\":\"P1 des\",\"quantity\":1,\"totalPrice\":10.0},{\"id\":2,\"name\":\"p2\",\"price\":20.0,\"description\":\"P2 des\",\"quantity\":1,\"totalPrice\":20.0}],\"pageable\":{\"sort\":{\"empty\":true,\"sorted\":false,\"unsorted\":true},\"offset\":0,\"pageSize\":20,\"pageNumber\":0,\"unpaged\":false,\"paged\":true},\"totalElements\":2,\"totalPages\":1,\"last\":true,\"size\":20,\"number\":0,\"sort\":{\"empty\":true,\"sorted\":false,\"unsorted\":true},\"numberOfElements\":2,\"first\":true,\"empty\":false}", 
				response, false);
	}
}
