package com.example.tgm.app.allTest.services.service;

import com.example.tgm.app.allTest.testEntity.TestProduct;
import com.example.tgm.app.allTest.testRepositories.TestProductRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.ws.rs.NotFoundException;
import java.util.List;

@Service
@Slf4j
public class TestProductService {
    private final TestProductRepo testProductRepo;

    public TestProductService(TestProductRepo testProductRepo) {
        this.testProductRepo = testProductRepo;
    }

    public List<TestProduct> getAll(){
        return testProductRepo.findAll();
    }

    public TestProduct getById(Long id){
        log.info("Поиск по следующему id: {}", id);
        return testProductRepo.findById(id).orElseThrow(NotFoundException::new);

    }
}
