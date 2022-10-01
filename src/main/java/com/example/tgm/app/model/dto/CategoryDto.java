package com.example.tgm.app.model.dto;

import com.example.tgm.app.model.entity.Category;
import com.example.tgm.app.model.entity.Product;
import lombok.Data;

import java.util.List;

@Data
public class CategoryDto {

    private Long id;
    private String title;
    private List<Product> products;

    public static CategoryDto toDto(Category category) {
        CategoryDto model = new CategoryDto();
        model.setId(category.getId());
        model.setTitle(category.getTitle());
        model.setProducts(category.getProducts());
        return model;
    }
}
