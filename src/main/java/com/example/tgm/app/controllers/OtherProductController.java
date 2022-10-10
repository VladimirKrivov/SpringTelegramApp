package com.example.tgm.app.controllers;

import com.example.tgm.app.model.dto.OtherProductDto;
import com.example.tgm.app.model.entity.OtherProduct;
import com.example.tgm.app.services.service.OtherProductService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Data
@RestController
public class OtherProductController {
    private final OtherProductService otherProductService;

    @GetMapping("/allotherproduct")
    public ResponseEntity getAll() {
        try {
            List<OtherProduct> otherProducts = otherProductService.getAll();
            List<OtherProductDto> otherProductDtoList =otherProducts.stream().map(OtherProductDto::toDto).toList();
            return ResponseEntity.ok(otherProductDtoList);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
