package com.example.tgm.app.controllers;

import com.example.tgm.app.model.dto.ProductDto;
import com.example.tgm.app.model.entity.Product;
import com.example.tgm.app.services.service.ProductService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Data
@RestController
public class ProductController {

    private final ProductService productService;


    @GetMapping("/allproduct")
    public ResponseEntity getAll() {
        try {
            List<Product> products = productService.listProduct();
            List<ProductDto> productDtoList =products.stream().map(ProductDto::toDto).toList();
            return ResponseEntity.ok(productDtoList);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

}
