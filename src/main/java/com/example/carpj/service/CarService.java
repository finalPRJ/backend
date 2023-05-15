package com.example.carpj.service;

import com.example.carpj.dto.CarDTO;
import com.example.carpj.entity.Car;
import com.example.carpj.dto.PageResultDTO;
import com.example.carpj.dto.PageRequestDTO;

import javax.persistence.Column;

public interface CarService {

    // 목록화
    PageResultDTO<CarDTO, Car> getList(PageRequestDTO requestDTO);

    // dto 값을 entity로 변환
    default Car dtoToEntity(CarDTO dto) {
        Car entity = Car.builder()
                .cno(dto.getCno())
                .platform(dto.getPlatform())
                .tag(dto.getTag())
                .type(dto.getType())
                .brand(dto.getBrand())
                .model(dto.getModel())
                .price(dto.getPrice())
                .pricer(dto.getPricer())
                .year(dto.getYear())
                .km(dto.getKm())
                .kmr(dto.getKmr())
                .oil(dto.getOil())
                .region(dto.getRegion())
                .link(dto.getLink())
                .img(dto.getImg())
                .build();
        return entity;
    }

    // entity 값을 dto로 변환
    default CarDTO entityToDto(Car entity) {
        CarDTO dto = CarDTO.builder()
                .cno(entity.getCno())
                .platform(entity.getPlatform())
                .tag(entity.getTag())
                .type(entity.getType())
                .brand(entity.getBrand())
                .model(entity.getModel())
                .price(entity.getPrice())
                .pricer(entity.getPricer())
                .year(entity.getYear())
                .km(entity.getKm())
                .kmr(entity.getKmr())
                .oil(entity.getOil())
                .region(entity.getRegion())
                .link(entity.getLink())
                .img(entity.getImg())
                .build();
        return dto;
    }
}


