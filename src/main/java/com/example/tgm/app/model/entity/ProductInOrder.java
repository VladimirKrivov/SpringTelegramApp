package com.example.tgm.app.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "product_in_order")
public class ProductInOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "prod_count")
    private Integer prodCount;

    @ManyToOne
    @JoinColumn(name = "product_id")
    Product products;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonIgnore
    Order orders;
}
