package com.example.tgm.app.services.repositories;

import com.example.tgm.app.model.entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepositories extends CrudRepository<Order, Long> {

    Optional<Order> findById(Long id);
    List<Order> findAll();
}
