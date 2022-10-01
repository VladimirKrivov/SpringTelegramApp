package com.example.tgm.app.controllers;


import com.example.tgm.app.model.dto.OrderDto;
import com.example.tgm.app.services.service.OrderService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Data
@RestController
@CrossOrigin("*")
@Slf4j
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/order/all")
    public ResponseEntity getAllOrders() {
        try {
            return ResponseEntity.ok(orderService.getAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PostMapping("/order/create-order")
    public ResponseEntity createNewOrder(@RequestBody OrderDto orderDto) {

        try {
            orderService.createOrder(orderDto);
            return ResponseEntity.ok("Продукт сохранен");
        } catch (Exception e) {
            log.info("Неудалось совершить заказ");
            return ResponseEntity.badRequest().body(orderDto);
        }
    }


}
