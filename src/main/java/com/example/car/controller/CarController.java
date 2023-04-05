package com.example.car.controller;

import com.example.car.dto.CarDTO;
import com.example.car.dto.PageRequestDTO;
import com.example.car.dto.PageResultDTO;
import com.example.car.entity.Car;
import com.example.car.service.CarService;
import com.example.car.service.CarServicelmpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/car")
@Log4j2
@RequiredArgsConstructor
public class CarController {

    @Autowired
    private final CarService service;

    @GetMapping("/list")
    public void list(PageRequestDTO pageRequestDTO, Model model) {
        log.info("list"+pageRequestDTO);
        model.addAttribute("result", service.getList(pageRequestDTO));
        
        // 출력 결과 테스트용
        PageResultDTO<CarDTO, Car> resultDTO = service.getList(pageRequestDTO);
        System.out.println("=========================================");
        for(CarDTO carDTO : resultDTO.getDtoList()) {
            System.out.println(carDTO);
        }
    }
    
}
