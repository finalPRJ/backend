package com.example.carpj.controller;

import com.example.carpj.dto.CarDTO;
import com.example.carpj.dto.PageRequestDTO;
import com.example.carpj.dto.PageResultDTO;
import com.example.carpj.entity.Car;
import com.example.carpj.service.CarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
@Log4j2
@RequiredArgsConstructor
public class CarController {

    @Autowired
    private final CarService service;

    @GetMapping("/list")
    public ResponseEntity<PageResultDTO<CarDTO, Car>> list(PageRequestDTO pageRequestDTO, Model model) {
        log.info("list"+pageRequestDTO);
        model.addAttribute("result", service.getList(pageRequestDTO));

        return new ResponseEntity<>(service.getList(pageRequestDTO), HttpStatus.OK);
    }
}
