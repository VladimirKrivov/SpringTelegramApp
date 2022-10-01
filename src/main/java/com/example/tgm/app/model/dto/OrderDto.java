package com.example.tgm.app.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderDto {

    private Integer allPrice;
    private String city;
    private String delivery;
    private String firstName;
    private String house;
    private String other;
    private String person;
    private String phoneNumber;
//    private Long[] productsId;
    private String street;
//    new code
    private List<ProductDto> products;
}
