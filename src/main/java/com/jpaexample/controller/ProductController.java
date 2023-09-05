package com.jpaexample.controller;

import com.jpaexample.dto.ProductRequestDto;
import com.jpaexample.dto.ProductResponseDto;
import com.jpaexample.entity.Product;
import com.jpaexample.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/save")
    public ProductResponseDto saveProduct(@RequestBody ProductRequestDto productRequest) {
        return productService.saveProduct(productRequest);
    }

    @GetMapping("/{id}")
    public ProductResponseDto getProductById(@PathVariable Integer id) {
        return productService.getProductById(id);
    }

    @GetMapping("/all")
    public List<ProductResponseDto> getAllProducts() {
        return productService.getAllProduct();
    }

    @PutMapping("/update/{id}")
    public ProductResponseDto getProductById(@PathVariable Integer id, @RequestBody ProductRequestDto productRequest) {
        return productService.updateProduct(id, productRequest);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProductById(@PathVariable Integer id) {
        productService.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }



    @GetMapping("/name/{name}")
    public ProductResponseDto getByName(@PathVariable String name) {
        return productService.getByName(name);
    }

    @GetMapping("/greater/{name}/{price}")
    public ProductResponseDto getByNameAndPriceGreaterThan(@PathVariable String name, @PathVariable double price) {
        return productService.getByNameAndPriceGreaterThan(name, price);
    }

    @GetMapping("/less/{name}/{price}")
    public ProductResponseDto getByNameAndPriceLessThan(@PathVariable String name, @PathVariable double price) {
        return productService.getByNameAndPriceLessThan(name, price);
    }

}
