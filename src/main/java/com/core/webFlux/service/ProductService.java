package com.core.webFlux.service;

import com.core.webFlux.dto.ProductDto;
import com.core.webFlux.entity.Product;
import com.core.webFlux.repository.ProductRepository;
import com.core.webFlux.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Range;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {
    // inject react mongo
    @Autowired
    private ProductRepository productRepository;

    // all the products
    public Flux<ProductDto> getProducts() {
        return productRepository.findAll().map(AppUtils::entityToDto);
    }

    // single product
    public Mono<ProductDto> getProduct(String id) {
        return productRepository.findById(id).map(AppUtils::entityToDto);
    }

    // product in range
    public Flux<ProductDto> getProductsInRange(double min, double max) {
        return productRepository.findByPriceBetween(Range.closed(min, max));
    }

    // save
    public Mono<ProductDto> saveProduct(Mono<ProductDto> productDtoMono) {
        return productDtoMono.map(AppUtils::dtoToEntity)
                .flatMap(productRepository::insert)
                .map(AppUtils::entityToDto);
    }

    // update
    public Mono<ProductDto> updateProduct(Mono<ProductDto> productDtoMono, String id) {
        return productRepository.findById(id)
                .flatMap(p -> productDtoMono.map(AppUtils::dtoToEntity))
                .doOnNext(e->e.setId(id))
                .flatMap(productRepository::save)
                .map(AppUtils::entityToDto);
    }

    // delete
    public Mono<Void> deleteProduct(String id){
        return productRepository.deleteById(id);
    }

}
