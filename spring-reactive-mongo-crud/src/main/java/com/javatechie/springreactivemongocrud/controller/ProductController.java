package com.javatechie.springreactivemongocrud.controller;

import com.javatechie.springreactivemongocrud.dto.ProductDto;
import com.javatechie.springreactivemongocrud.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private ProductService service;

    @GetMapping
    public Flux<ProductDto> products() {
        return service.getProducts();
    }

    @GetMapping("/{id}")
    public Mono<ProductDto> getProduct(
            @PathVariable String id) {
        return service.getProduct(id);
    }

    @GetMapping("/product-range")
    public Flux<ProductDto> getProductBetweenRange(
            @RequestParam("min") double min,
            @RequestParam("max") double max) {
        return service.getProductInRange(min, max);
    }

    @PostMapping
    public Mono<ProductDto> saveProduct(
            @RequestBody Mono<ProductDto> productDtoMono) {
        return service.saveProduct(productDtoMono);
    }

    @PutMapping("/update/{id}")
    public Mono<ProductDto> updateProduct(
            @RequestBody Mono<ProductDto> productDtoMono,
            @PathVariable String id) {
        return service.updateProduct(productDtoMono, id);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteProduct(
            @PathVariable String id) {
        return service.deletProduct(id);
    }
}