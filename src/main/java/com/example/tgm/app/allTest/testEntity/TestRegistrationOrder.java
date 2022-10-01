package com.example.tgm.app.allTest.testEntity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "test_reg_product")
@Entity
public class TestRegistrationOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "test_prod_count")
    private Integer prodCount;

    @ManyToOne
    @JoinColumn(name = "test_product_id")
    TestProduct testProducts;

    @ManyToOne
    @JoinColumn(name = "test_order_id")
    @JsonIgnore
    TestOrder testOrders;
}
