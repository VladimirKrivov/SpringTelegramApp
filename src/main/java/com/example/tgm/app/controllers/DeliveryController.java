package com.example.tgm.app.controllers;

import com.example.tgm.app.model.dto.DeliveryDto;
import com.example.tgm.app.services.service.DeliveryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeliveryController {
    private final DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @GetMapping("/get-delivery")
    public ResponseEntity getAll() {
        try {
            List<DeliveryDto> list = deliveryService.getAll().stream().map(DeliveryDto::toDto).toList();
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
