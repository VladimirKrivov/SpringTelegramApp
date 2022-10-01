package com.example.tgm.app.controllers;

import com.example.tgm.app.model.dto.CategoryDto;
import com.example.tgm.app.model.entity.Category;
import com.example.tgm.app.services.service.CategoryService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Data
@RestController
@CrossOrigin("*")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/allcategory")
    public ResponseEntity getAll() {
        try {
            List<Category> categoryList = categoryService.listCategory();
            List<CategoryDto> categoryDtoList =categoryList.stream().map(CategoryDto::toDto).toList();
            return ResponseEntity.ok(categoryDtoList);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

}
