package com.example.tgm.app.model.entity;

import com.example.tgm.app.allTest.testEntity.TestRegistrationOrder;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Table(name = "product")
@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "prod_title")
    private String title;
    @Column(name = "prod_description")
    private String description;
    @Column(name = "prod_short_description")
    private String shortDescription;
    @Column(name = "prod_price")
    private Double price;
    @Column(name = "prod_count")
    private Integer count;

    @Column(name = "prod_image_byte")
    @Lob
    private byte[] imageByte;


    @ManyToMany
    @JoinTable(name = "product_other_products",
            joinColumns = @JoinColumn(name = "products_id"),
            inverseJoinColumns = @JoinColumn(name = "other_products_id"))
    @JsonIgnore
    private List<OtherProduct> otherProducts;


//    Продукты в заказе
    @OneToMany(mappedBy = "products")
    @JsonIgnore
    List<ProductInOrder> ProductInOrder;



//    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "products", fetch = FetchType.EAGER)
//    @JsonIgnore
//    private List<Order> orders;
}
