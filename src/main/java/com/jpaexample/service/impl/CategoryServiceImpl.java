package com.jpaexample.service.impl;

;
import com.jpaexample.dto.CategoryRequestDto;
import com.jpaexample.dto.CategoryResponseDto;
import com.jpaexample.entity.Category;
import com.jpaexample.repository.CategoryRepository;
import com.jpaexample.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;


    @Override
    public CategoryResponseDto saveCategory(CategoryRequestDto categoryRequest) {


        Category category = new Category(categoryRequest);


        return new CategoryResponseDto(categoryRepository.save(category));




    }

    @Override
    public CategoryResponseDto getCategoryById(Integer id) {
        return null;
    }
}
