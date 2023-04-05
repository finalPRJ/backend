package com.example.car.service;

import com.example.car.dto.CarDTO;
import com.example.car.dto.PageRequestDTO;
import com.example.car.dto.PageResultDTO;
import com.example.car.entity.Car;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CarServiceTest {

    @Autowired
    private CarService service;
    @Test
    public void testList() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(1).size(10).build();

        PageResultDTO<CarDTO, Car> resultDTO = service.getList(pageRequestDTO);

        for(CarDTO carDTO : resultDTO.getDtoList()) {
            System.out.println(carDTO);
        }
    }

    @Test
    public void testSearch() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(20)
                .type("p")
                .keyword("K-Car")
                .build();

        PageResultDTO<CarDTO, Car> resultDTO = service.getList(pageRequestDTO);

        System.out.println("PREV: "+ resultDTO.isPrev());
        System.out.println("NEXT: "+resultDTO.isNext());
        System.out.println("TOTAL: "+resultDTO.getTotalPage());

        System.out.println("=========================================");
        for(CarDTO carDTO : resultDTO.getDtoList()) {
            System.out.println(carDTO);
        }

        System.out.println("=========================================");
        resultDTO.getPageList().forEach(i -> System.out.println(i));
    }
}
