package com.example.tgm.app.allTest.testControllers;

import com.example.tgm.app.allTest.services.service.TestProductService;
import com.example.tgm.app.allTest.testEntity.TestProduct;
import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Data
@RestController
@CrossOrigin("*")
public class TestProductController {
    private final TestProductService testProductService;

    @GetMapping("/test/product/get-all")
    public List<TestProduct> getAll(){
        return testProductService.getAll();
    }
}
