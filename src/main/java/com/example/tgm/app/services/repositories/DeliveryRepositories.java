package com.example.tgm.app.services.repositories;

import com.example.tgm.app.model.entity.Delivery;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DeliveryRepositories extends CrudRepository<Delivery, Long> {
    Optional<Delivery> findById(Long id);
    List<Delivery> findAll();
    Delivery findByValue(String value);
}
