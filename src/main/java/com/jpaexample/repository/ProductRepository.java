package com.jpaexample.repository;

import com.jpaexample.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
//    Optional<Product> getByName(String name);

    Optional<Product> findByName(String name);
    Optional<Product> findByNameAndPriceLessThan(String name, double price);
    Optional<Product> findByNameAndPriceGreaterThan(String name, double price);
}
