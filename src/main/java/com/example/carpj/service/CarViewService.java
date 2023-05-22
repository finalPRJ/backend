package com.example.carpj.service;

import com.example.carpj.dto.CarViewDTO;
import com.example.carpj.entity.CarDic;
import com.example.carpj.entity.CarView;
import com.example.carpj.entity.Member;

import java.util.List;

public interface CarViewService {
//    boolean register(Long id, Integer cDNo); //특정 항목 조회 값 DB에 저장
    List<CarViewDTO> rank(); //전체 조회수 순위
    
    //연령별 조회수 순위
    //국산/수입별 조회수 순위
    //차종별 조회수 순위

    default CarView dtoToEntity(CarViewDTO dto) {
        CarDic carDic = CarDic.builder().cDNo(dto.getCDNo()).build();
        Member member = Member.builder().id(dto.getId()).build();
        CarView carView = CarView.builder()
                .cVNo(dto.getCVNo())
                .cDNo(carDic)
                .id(member)
                .count(dto.getCount())
                .build();
        return carView;
    }

    default CarViewDTO entityToDTO(CarView carView) {
        CarDic carDic = carView.getCDNo();
        Member member = carView.getId();
        CarViewDTO dto = CarViewDTO.builder()
                .cVNo(carView.getCVNo())
                .cDNo(carDic.getCDNo())
                .id(member.getId())
                .count(carView.getCount())
                .build();
        return dto;
    }
}