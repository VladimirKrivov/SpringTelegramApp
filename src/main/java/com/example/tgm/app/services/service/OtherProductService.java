package com.example.tgm.app.services.service;

import com.example.tgm.app.model.entity.OtherProduct;
import com.example.tgm.app.services.repositories.OtherProductRepositories;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class OtherProductService {

    private final OtherProductRepositories otherProductRepo;

    public OtherProductService(OtherProductRepositories otherProductRepo) {
        this.otherProductRepo = otherProductRepo;
    }

    public List<OtherProduct> getAll(){
        return otherProductRepo.findAll();
    }
}
