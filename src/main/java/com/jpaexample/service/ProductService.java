package com.jpaexample.service;

import com.jpaexample.dto.ProductRequestDto;
import com.jpaexample.dto.ProductResponseDto;
import com.jpaexample.entity.Product;

import java.util.List;

public interface ProductService {
    ProductResponseDto saveProduct(ProductRequestDto productRequest);

    ProductResponseDto updateProduct(Integer id, ProductRequestDto productRequest);


    ProductResponseDto getProductById(Integer id);

    List<ProductResponseDto> getAllProduct();

    void deleteProduct(Integer id);

    ProductResponseDto getByName(String name);

    ProductResponseDto getByNameAndPriceGreaterThan(String name, double price);
    ProductResponseDto getByNameAndPriceLessThan(String name, double price);





//    Product getProductById(Integer id);

//    Optional<Product> getProductById(Integer id);




}
