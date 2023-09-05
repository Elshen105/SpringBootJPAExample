package com.jpaexample.service.impl;

import com.jpaexample.dto.ProductRequestDto;
import com.jpaexample.dto.ProductResponseDto;
import com.jpaexample.entity.Category;
import com.jpaexample.entity.Product;
import com.jpaexample.helper.ProductHelper;
import com.jpaexample.repository.ProductRepository;
import com.jpaexample.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public ProductResponseDto saveProduct(ProductRequestDto productRequest) {
        Product product = new Product(productRequest);
        return new ProductResponseDto(productRepository.save(product));

    }

    @Override
    public ProductResponseDto updateProduct(Integer id, ProductRequestDto productRequest) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setName(productRequest.getName());
            product.setCategory(new Category(productRequest.getCategoryId(), null));
            product.setPrice(productRequest.getPrice());

            return new ProductResponseDto(productRepository.save(product));
        }
        else throw new RuntimeException("Product is not found!");
    }

    @Override
    public ProductResponseDto getProductById(Integer id) {

        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isPresent())
            return new ProductResponseDto(optionalProduct.get());

        throw new RuntimeException("Product is not found");
    }

    @Override
    public List<ProductResponseDto> getAllProduct() {

        return ProductHelper.convert(productRepository.findAll());
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }


    @Override
    public ProductResponseDto getByName(String name) {
        Optional<Product> optionalProduct = productRepository.findByName(name);
        if (optionalProduct.isPresent())
            return new ProductResponseDto(optionalProduct.get());
        throw new RuntimeException("Product is not found");
    }

    @Override
    public ProductResponseDto getByNameAndPriceGreaterThan(String name, double price) {
        Optional<Product> optionalProduct = productRepository.findByNameAndPriceGreaterThan(name, price);
        if (optionalProduct.isPresent())
            return new ProductResponseDto(optionalProduct.get());
        throw new RuntimeException("Product is not found");
    }

    @Override
    public ProductResponseDto getByNameAndPriceLessThan(String name, double price) {
        Optional<Product> optionalProduct = productRepository.findByNameAndPriceLessThan(name, price);
        if (optionalProduct.isPresent())
            return new ProductResponseDto(optionalProduct.get());
        throw new RuntimeException("Product is not found");
    }

/*
    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(Integer id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent())
            return optionalProduct.get();
        throw new RuntimeException("Product Not Found!");
    }*/
}
