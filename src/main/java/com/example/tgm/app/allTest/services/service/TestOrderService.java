package com.example.tgm.app.allTest.services.service;

import com.example.tgm.app.allTest.testEntity.TestOrder;
import com.example.tgm.app.allTest.testEntity.TestRegistrationOrder;
import com.example.tgm.app.allTest.testEntity.testDto.TestOrderDto;
import com.example.tgm.app.allTest.testEntity.testDto.TestProductDto;
import com.example.tgm.app.allTest.testRepositories.TestRegOrderRepo;
import com.example.tgm.app.allTest.testRepositories.TestOrderRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TestOrderService {
    private final TestOrderRepo testOrderRepo;
    private final TestProductService testProductService;
    private final TestRegOrderRepo testRegOrderRepo;

    public TestOrderService(TestOrderRepo testOrderRepo, TestProductService testProductService, TestRegOrderRepo testRegOrderRepo) {
        this.testOrderRepo = testOrderRepo;
        this.testProductService = testProductService;
        this.testRegOrderRepo = testRegOrderRepo;
    }

    public List<TestOrder> getAll() {
        return testOrderRepo.findAll();
    }


    public void saveTestOrder(TestOrderDto testOrderDto) {
        log.info("Заходим в сервис");
        TestOrder order = new TestOrder();


        order.setFirstName(testOrderDto.getFirstName());
        order.setPhoneNumber(testOrderDto.getPhoneNumber());
        log.info("Собранный OrderTest {}", order);
        testOrderRepo.save(order);


        for (TestProductDto a : testOrderDto.getTestProductDtoList()) {
            log.info("Происходит итерация с: {}", a);
            TestRegistrationOrder testReg = new TestRegistrationOrder();
            testReg.setTestProducts(testProductService.getById(a.getId()));
            testReg.setTestOrders(order);
            testReg.setProdCount(a.getCount());
            testRegOrderRepo.save(testReg);
        }


    }
}
