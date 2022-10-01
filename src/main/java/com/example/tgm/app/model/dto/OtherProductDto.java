package com.example.tgm.app.model.dto;

import com.example.tgm.app.model.entity.OtherProduct;
import com.example.tgm.app.model.entity.Product;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class OtherProductDto {
    private Long id;
    private String title;
    private List<Product> products;

    public static OtherProductDto toDto(OtherProduct otherProduct){
        OtherProductDto model = new OtherProductDto();
        model.setId(otherProduct.getId());
        model.setTitle(otherProduct.getTitle());
        model.setProducts(otherProduct.getProducts());
        return model;
    }
}
