package com.example.tgm.app.allTest.testControllers;

import com.example.tgm.app.allTest.services.service.TestOrderService;
import com.example.tgm.app.allTest.testEntity.TestOrder;
import com.example.tgm.app.allTest.testEntity.testDto.TestOrderDto;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@CrossOrigin("*")
@Slf4j
public class TestOrderController {
    private final TestOrderService testOrderService;

    @GetMapping("test/order/get-all")
    public ResponseEntity getAll() {
        try {
            return ResponseEntity.ok(testOrderService.getAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка отправки заказов");
        }
    }

    @PostMapping("test/order/create")
    public ResponseEntity saveTestOrder(@RequestBody TestOrderDto testOrderDto) {
        log.info("Мы получили из PostMan: {}", testOrderDto);
        try {
            testOrderService.saveTestOrder(testOrderDto);
            return ResponseEntity.ok("Продукт сохранен");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка создания заказа в тесте");
        }
    }
}
