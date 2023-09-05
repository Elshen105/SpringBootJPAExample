package com.jpaexample.helper;

import com.jpaexample.dto.ProductResponseDto;
import com.jpaexample.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductHelper {

    public static List<ProductResponseDto> convert(List<Product> products) {
        List<ProductResponseDto> productResponseList = new ArrayList<>();
        for (Product product : products) {
            ProductResponseDto responseDto = new ProductResponseDto();
            responseDto.setId(product.getId());
            responseDto.setName(product.getName());
            responseDto.setPrice(product.getPrice());
            productResponseList.add(responseDto);
        }
        return productResponseList;
    }

}
