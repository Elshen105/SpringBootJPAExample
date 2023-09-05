package com.jpaexample.entity;

import com.jpaexample.dto.ProductRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DynamicUpdate
@NamedQueries(
        @NamedQuery(name = "findByName", query = "SELECT p FROM Product p WHERE p.name=?1")
)

@NamedNativeQueries(
        @NamedNativeQuery(name = "getByName", query = "SELECT * FROM product WHERE name=?")
)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;



    /*@JoinColumns(foreignKey = @ForeignKey(name = "FK_CATEGORY"),
            value = {@JoinColumn(name = "cat_name",
                    referencedColumnName = "category_name")}
    )*/

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cat_id")
    private Category category;
    private double price;

    public Product(ProductRequestDto productRequest) {
        this.name = productRequest.getName();
        this.category = new Category(productRequest.getCategoryId(), null);
        this.price = productRequest.getPrice();
    }

}
