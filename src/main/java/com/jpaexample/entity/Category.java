package com.jpaexample.entity;


import com.jpaexample.dto.CategoryRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @Column(name = "category_name", unique = true)
    @Column(name = "category_name")
    private String categoryName;

    public Category(CategoryRequestDto categoryRequest) {
        this.categoryName = categoryRequest.getCategoryName();
    }

}
