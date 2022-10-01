package com.example.tgm.app.allTest.testRepositories;

import com.example.tgm.app.allTest.testEntity.TestProduct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TestProductRepo extends CrudRepository<TestProduct, Long> {
    List<TestProduct> findAll();
    Optional<TestProduct> findById(Long id);
}
