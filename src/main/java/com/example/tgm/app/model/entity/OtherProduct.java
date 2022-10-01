package com.example.tgm.app.model.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;


import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Table(name = "other_product")
@Entity
public class OtherProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "other_prod_title")
    private String title;


    @ManyToMany(mappedBy = "otherProducts", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Product> products;
}


