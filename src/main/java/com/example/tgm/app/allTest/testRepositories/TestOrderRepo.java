package com.example.tgm.app.allTest.testRepositories;

import com.example.tgm.app.allTest.testEntity.TestOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TestOrderRepo extends CrudRepository<TestOrder, Long> {
    List<TestOrder> findAll();
    Optional<TestOrder> findById(Long id);
}
