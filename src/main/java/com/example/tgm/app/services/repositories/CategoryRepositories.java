package com.example.tgm.app.services.repositories;

import com.example.tgm.app.model.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepositories extends CrudRepository<Category, Long> {
    List<Category> findAll();
}
