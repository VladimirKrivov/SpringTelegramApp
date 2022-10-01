package com.example.tgm.app.allTest.testRepositories;

import com.example.tgm.app.allTest.testEntity.TestRegistrationOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRegOrderRepo extends CrudRepository<TestRegistrationOrder, Long> {

}
