package com.jpaexample.service;

import com.jpaexample.dto.CategoryRequestDto;
import com.jpaexample.dto.CategoryResponseDto;
import com.jpaexample.entity.Category;
import com.jpaexample.entity.Product;

import java.util.Optional;

public interface CategoryService {
    CategoryResponseDto saveCategory(CategoryRequestDto categoryRequest);
    CategoryResponseDto getCategoryById(Integer id);
}
