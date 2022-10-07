package com.example.tgm.app.services.service;

import com.example.tgm.app.exceprions.NotFoundException;
import com.example.tgm.app.model.entity.Delivery;
import com.example.tgm.app.services.repositories.DeliveryRepositories;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryService {
    private final DeliveryRepositories deliveryRepo;

    public DeliveryService(DeliveryRepositories deliveryRepo) {
        this.deliveryRepo = deliveryRepo;
    }

    public Delivery getById(Long id) {
        return deliveryRepo.findById(id).orElseThrow(() -> new NotFoundException("Произошла ошибка сервера! Не удалось найти способ доставки по заданному ID"));

    }

    public Delivery getByValue(String value) {
        return deliveryRepo.findByValue(value);
    }

    public List<Delivery> getAll(){
        return deliveryRepo.findAll();
    }
}
