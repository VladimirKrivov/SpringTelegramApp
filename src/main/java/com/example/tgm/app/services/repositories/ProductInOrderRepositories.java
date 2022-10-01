package com.example.tgm.app.services.repositories;

import com.example.tgm.app.model.entity.ProductInOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductInOrderRepositories extends CrudRepository<ProductInOrder, Long> {
}
