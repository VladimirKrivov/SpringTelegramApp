package com.example.tgm.app.services.service;

import com.example.tgm.app.model.entity.Category;
import com.example.tgm.app.services.repositories.CategoryRepositories;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepositories categoryRepo;

    public CategoryService(CategoryRepositories categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public List<Category> listCategory(){
        return categoryRepo.findAll();
    }
}
