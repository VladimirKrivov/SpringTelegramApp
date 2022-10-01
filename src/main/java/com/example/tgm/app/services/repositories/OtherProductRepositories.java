package com.example.tgm.app.services.repositories;

import com.example.tgm.app.model.entity.OtherProduct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OtherProductRepositories extends CrudRepository<OtherProduct, Long> {
    List<OtherProduct> findAll();
}

