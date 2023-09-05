package com.jpaexample.dto;


import com.jpaexample.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponseDto {
    private Integer id;
    private String categoryName;

    public CategoryResponseDto(Category category) {
        this.id = category.getId();
        this.categoryName = category.getCategoryName();
    }

}
