package com.example.tgm.app.services.repositories;

import com.example.tgm.app.model.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepositories extends CrudRepository<Product, Long> {
    List<Product> findAll();
    Optional<Product> findById(Long id);
}
