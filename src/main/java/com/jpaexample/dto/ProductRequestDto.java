package com.jpaexample.dto;

import com.jpaexample.entity.Category;
import com.jpaexample.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDto {

    private String name;
    private Integer categoryId;
    private double price;


}
