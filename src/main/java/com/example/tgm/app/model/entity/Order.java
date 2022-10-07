package com.example.tgm.app.model.entity;

import com.example.tgm.app.allTest.testEntity.TestRegistrationOrder;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Table(name = "order_product")
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "order_user_name")
    private String firstName;
    @Column(name = "order_phone")
    private String phoneNumber;
    @Column(name = "order_city")
    private String city;
    @Column(name = "order_street")
    private String street;
    @Column(name = "order_house_number")
    private String house;
    @Column(name = "order_person_count")
    private String person;
    @Column(name = "order_other")
    private String other;

    @OneToOne
    private Delivery delivery;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orders", cascade = CascadeType.REMOVE)
    List<ProductInOrder> RegistrationOrder;


//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinTable(name = "product_is_order",
//            joinColumns = @JoinColumn(name = "order_id"),
//            inverseJoinColumns = @JoinColumn(name = "product_id"))
//    private List<Product> products;
}
