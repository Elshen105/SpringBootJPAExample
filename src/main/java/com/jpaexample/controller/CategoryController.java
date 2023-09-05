package com.jpaexample.controller;

import com.jpaexample.dto.CategoryRequestDto;
import com.jpaexample.dto.CategoryResponseDto;
import com.jpaexample.entity.Category;
import com.jpaexample.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
public class CategoryController {


    private final CategoryService categoryService;

    @PostMapping("/save")
    public CategoryResponseDto saveCategory(@RequestBody CategoryRequestDto categoryRequest) {
        return categoryService.saveCategory(categoryRequest);
    }
}
