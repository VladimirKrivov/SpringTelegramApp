package com.example.tgm.app.services.service;

import com.example.tgm.app.exceprions.NotFoundException;
import com.example.tgm.app.model.dto.OrderDto;
import com.example.tgm.app.model.dto.ProductDto;
import com.example.tgm.app.model.entity.Order;
import com.example.tgm.app.model.entity.ProductInOrder;
import com.example.tgm.app.services.repositories.OrderRepositories;
import com.example.tgm.app.telegram.service.TelegramService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

@Service
@Slf4j
public class OrderService {

    private final TelegramService telegramService;
    private final OrderRepositories orderRepo;
    private final ProductService productService;
    private final ProductInOrderService productInOrderService;

    public OrderService(TelegramService telegramService, OrderRepositories orderRepo, ProductService productService, ProductInOrderService productInOrderService) {
        this.telegramService = telegramService;
        this.orderRepo = orderRepo;
        this.productService = productService;
        this.productInOrderService = productInOrderService;
    }

    public List<Order> getAll() {
        return orderRepo.findAll();
    }
    public Order orderGetById(Long id){
        return orderRepo.findById(id).orElseThrow(() -> new NotFoundException("Произошла ошибка сервера! Не удалось найти заказ по заданному ID"));

    }

    public void saveOrder(Order order){
        orderRepo.save(order);
    }
    public long saveOrderAndGetId(Order order){
        Order orderCreate = orderRepo.save(order);
        return orderCreate.getId();
    }



}
