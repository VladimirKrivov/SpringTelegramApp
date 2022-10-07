package com.example.tgm.app.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class CreateOrderDto {

    private String firstName;
    private String phoneNumber;
    private String city;
    private String street;
    private String house;
    private String person;
    private String other;

    private Double allPrice;

    private String delivery;
    private List<ProductDto> products;
}
