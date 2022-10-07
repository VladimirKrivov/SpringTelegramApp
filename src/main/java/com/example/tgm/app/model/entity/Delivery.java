package com.example.tgm.app.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "delivery")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "delivery_name")
    private String name;
    @Column(name = "delivery_value")
    private String value;

}
