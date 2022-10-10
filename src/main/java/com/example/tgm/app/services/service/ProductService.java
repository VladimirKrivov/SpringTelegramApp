package com.example.tgm.app.services.service;

import com.example.tgm.app.model.entity.Product;
import com.example.tgm.app.services.repositories.ProductRepositories;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.ws.rs.NotFoundException;
import java.util.List;

@Service
@Slf4j
public class ProductService {

    private final ProductRepositories productRepo;

    public ProductService(ProductRepositories productRepo) {
        this.productRepo = productRepo;
    }

    public List<Product> listProduct() {
        return productRepo.findAll();
    }

    public Product getById(Long id) {
        log.info("Поиск по следующему id: {}", id);
        return productRepo.findById(id).orElseThrow(NotFoundException::new);

    }

}
