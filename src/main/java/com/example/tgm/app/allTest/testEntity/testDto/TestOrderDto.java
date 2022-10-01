package com.example.tgm.app.allTest.testEntity.testDto;

import com.example.tgm.app.allTest.testEntity.TestOrder;
import lombok.Data;

import java.util.List;

@Data
public class TestOrderDto {

    private String firstName;
    private String phoneNumber;
    private List<TestProductDto> testProductDtoList;

//    public static TestOrderDto toModel(TestOrder testOrder){
//        TestOrderDto model = new TestOrderDto();
//        model.setFirstName(testOrder.getFirstName());
//        model.setPhoneNumber(testOrder.getPhoneNumber());
//        model.se
//        return null;
//    }
}

