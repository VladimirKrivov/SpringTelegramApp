package com.example.tgm.app.allTest.testEntity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Table(name = "test_order")
@Entity
public class TestOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "test_order_user_name")
    private String firstName;
    @Column(name = "test_order_phone")
    private String phoneNumber;



    @OneToMany(mappedBy = "testOrders")
    List<TestRegistrationOrder> testRegistrationOrder;
}
