package com.example.tgm.app.model.dto;

import com.example.tgm.app.model.entity.OtherProduct;
import com.example.tgm.app.model.entity.Product;
import lombok.Data;

import javax.persistence.Lob;
import java.util.List;

@Data
public class ProductDto {

    private Long id;
    private String title;
    private String description;
    private String shortDescription;
    private Double price;
    private Integer count;
    @Lob
    private byte[] imageByte;

    private List<OtherProduct> otherProducts;

    public static ProductDto toDto(Product product) {
        ProductDto model = new ProductDto();
        model.setId(product.getId());
        model.setTitle(product.getTitle());
        model.setDescription(product.getDescription());
        model.setShortDescription(product.getShortDescription());
        model.setPrice(product.getPrice());
        model.setCount(product.getCount());
        model.setImageByte(product.getImageByte());
        model.setOtherProducts(product.getOtherProducts());
        return model;
    }

}
