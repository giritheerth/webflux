package com.core.webFlux.repository;

import com.core.webFlux.dto.ProductDto;
import com.core.webFlux.entity.Product;
import org.springframework.data.domain.Range;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ProductRepository extends ReactiveMongoRepository<Product,String> {


    Flux<ProductDto> findByPriceBetween(Range<Double> closed);
}
