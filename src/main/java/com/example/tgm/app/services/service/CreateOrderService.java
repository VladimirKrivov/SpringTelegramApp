package com.example.tgm.app.services.service;

import com.example.tgm.app.exceprions.CrashException;
import com.example.tgm.app.model.dto.CreateOrderDto;
import com.example.tgm.app.model.dto.ProductDto;
import com.example.tgm.app.model.entity.Order;
import com.example.tgm.app.model.entity.ProductInOrder;
import org.springframework.stereotype.Service;

@Service
public class CreateOrderService {
    private final OrderService orderService;
    private final ProductService productService;
    private final ProductInOrderService productInOrderService;
    private final DeliveryService deliveryService;

    public CreateOrderService(OrderService orderService, ProductService productService, ProductInOrderService productInOrderService, DeliveryService deliveryService) {
        this.orderService = orderService;
        this.productService = productService;
        this.productInOrderService = productInOrderService;
        this.deliveryService = deliveryService;
    }


    public void createOrder(CreateOrderDto create) {
        double allPrice = 0;
        for (ProductDto prod : create.getProducts()) {
            double price = productService.getById(prod.getId()).getPrice();
            allPrice += (price * prod.getCount());
        }
        if (allPrice != create.getAllPrice()) {
            throw new CrashException("Ошибка на сервере. Попробуйте позже");
        } else {
            Order model = new Order();
            model.setFirstName(create.getFirstName());
            model.setPhoneNumber(create.getPhoneNumber());
            model.setCity(create.getCity());
            model.setStreet(create.getStreet());
            model.setHouse(create.getHouse());
            model.setPerson(create.getPerson());
            model.setOther(create.getOther());
//      Необходимо реализовать доставку в react
            model.setDelivery(deliveryService.getByValue(create.getDelivery()));
            long orderNum = orderService.saveOrderAndGetId(model);
//        Добавление продуктов
            for (ProductDto prod : create.getProducts()) {
                ProductInOrder productInOrder = new ProductInOrder();
                productInOrder.setProducts(productService.getById(prod.getId()));
                productInOrder.setProdCount(prod.getCount());
                productInOrder.setOrders(orderService.orderGetById(orderNum));
                productInOrderService.saveProdInOrder(productInOrder);
            }
        }
    }
}
