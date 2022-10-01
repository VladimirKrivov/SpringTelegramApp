package com.example.tgm.app.services.service;

import com.example.tgm.app.model.entity.ProductInOrder;
import com.example.tgm.app.services.repositories.ProductInOrderRepositories;
import org.springframework.stereotype.Service;

@Service
public class ProductInOrderService {
    private final ProductInOrderRepositories productRepo;

    public ProductInOrderService(ProductInOrderRepositories productRepo) {
        this.productRepo = productRepo;
    }

    public void saveProdInOrder(ProductInOrder productInOrder){
        productRepo.save(productInOrder);
    }
}
