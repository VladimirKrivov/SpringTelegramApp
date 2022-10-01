package com.example.tgm.app.allTest.testEntity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Table(name = "test_product")
@Entity
public class TestProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "test_prod_title")
    private String title;
    @Column(name = "test_prod_count")
    private Integer count;

    @OneToMany(mappedBy = "testProducts")
    @JsonIgnore
    List<TestRegistrationOrder> testRegistrationOrder;
}
