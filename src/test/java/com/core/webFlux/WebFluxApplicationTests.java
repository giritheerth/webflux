package com.core.webFlux;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.core.webFlux.controller.ProductController;
import com.core.webFlux.dto.ProductDto;
import com.core.webFlux.service.ProductService;

import reactor.core.publisher.Mono;

@WebFluxTest(ProductController.class)
class WebFluxApplicationTests {

	// inject webTestClient
	@Autowired
	private WebTestClient webTestClient;
	@Mock
	private ProductService productService;

	
	@Test
	public void addProductTest() {
		Mono<ProductDto> productDtoMono = Mono.just(new ProductDto("101", "mobile", 1, 10000));
		when(productService.saveProduct(productDtoMono)).thenReturn(productDtoMono);

		webTestClient.post().uri("/products")
				.body(Mono.just(productDtoMono), ProductDto.class)
				.exchange()
				.expectStatus().isOk();
	}
}
