package com.example.tgm.app.controllers;


import com.example.tgm.app.exceprions.CrashException;
import com.example.tgm.app.model.dto.CreateOrderDto;
import com.example.tgm.app.services.service.CreateOrderService;
import com.example.tgm.app.services.service.OrderService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Data
@RestController
@Slf4j
public class OrderController {
    private final OrderService orderService;
    private final CreateOrderService createOrderService;

    public OrderController(OrderService orderService, CreateOrderService createOrderService) {
        this.orderService = orderService;
        this.createOrderService = createOrderService;
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
    public ResponseEntity<String> createNewOrder(@RequestBody CreateOrderDto orderDto) {

        try {
            createOrderService.createOrder(orderDto);
            return ResponseEntity.ok("Заказ сохранен");
        } catch (CrashException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        } catch (Exception e) {
            log.info("Неудалось совершить заказ");
            return ResponseEntity.badRequest().body("Ошибка сервера");
        }
    }


}
