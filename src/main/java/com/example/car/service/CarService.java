package com.example.car.service;

import com.example.car.dto.CarDTO;
import com.example.car.entity.Car;
import com.example.car.dto.PageResultDTO;
import com.example.car.dto.PageRequestDTO;

import javax.persistence.Column;

public interface CarService {

    // 목록화
    PageResultDTO<CarDTO, Car> getList(PageRequestDTO requestDTO);

    // dto 값을 entity로 변환
    default Car dtoToEntity(CarDTO dto) {
        Car entity = Car.builder()
                .cno(dto.getCno())
                .plattform(dto.getPlattform())
                .tag(dto.getTag())
                .type(dto.getType())
                .brand(dto.getBrand())
                .model(dto.getModel())
                .price(dto.getPrice())
                .rprice(dto.getRprice())
                .year(dto.getYear())
                .km(dto.getKm())
                .rkm(dto.getRkm())
                .oiltype(dto.getOiltype())
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
                .plattform(entity.getPlattform())
                .tag(entity.getTag())
                .type(entity.getType())
                .brand(entity.getBrand())
                .model(entity.getModel())
                .price(entity.getPrice())
                .rprice(entity.getRprice())
                .year(entity.getYear())
                .km(entity.getKm())
                .rkm(entity.getRkm())
                .oiltype(entity.getOiltype())
                .region(entity.getRegion())
                .link(entity.getLink())
                .img(entity.getImg())
                .build();
        return dto;
    }
}


