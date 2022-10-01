package com.example.tgm.app.services.service;

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

    public void saveOrder(Order order){
        orderRepo.save(order);
    }


    public void createOrder(OrderDto orderDto) throws TelegramApiException {
        Order model = new Order();
        model.setFirstName(orderDto.getFirstName());
        model.setCity(orderDto.getCity());
        model.setHouse(orderDto.getHouse());
        model.setOther(orderDto.getOther());
        model.setPerson(orderDto.getPerson());
        model.setPhoneNumber(orderDto.getPhoneNumber());
        model.setStreet(orderDto.getStreet());
        model.setDelivery("Какая-то доставка!");
        if (orderDto.getDelivery().equals("delivery")) {
            model.setDelivery("Доставка");
        } else {
            model.setDelivery("Самовывоз");
        }
        orderRepo.save(model);




        for (ProductDto a : orderDto.getProducts()){
            ProductInOrder productInOrder = new ProductInOrder();
            productInOrder.setProducts(productService.getById(a.getId()));
            productInOrder.setProdCount(a.getCount());
            productInOrder.setOrders(model);

            productInOrderService.saveProdInOrder(productInOrder);
            telegramService.toMessage(model);
        }


    }
}
