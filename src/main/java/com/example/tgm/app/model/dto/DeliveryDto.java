package com.example.tgm.app.model.dto;

import com.example.tgm.app.model.entity.Delivery;
import lombok.Data;

@Data
public class DeliveryDto {
    private Long id;
    private String name;
    private String value;

    public static DeliveryDto toDto(Delivery delivery){
        DeliveryDto model = new DeliveryDto();
        model.setId(delivery.getId());
        model.setName(delivery.getName());
        model.setValue(delivery.getValue());
        return model;
    }

}
