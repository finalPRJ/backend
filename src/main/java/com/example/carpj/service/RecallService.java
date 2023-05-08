package com.example.carpj.service;

import com.example.carpj.dto.RecallDTO;
import com.example.carpj.entity.Recall;

import java.util.List;

public interface RecallService {
    //recall 많이 개시된 TOP4
    List<RecallDTO> worst4();

    //recall 적게 개시된 TOP4
    List<RecallDTO> best4();

    //recall된 브랜드 별 상세 정보
    List<RecallDTO> worstInfo(String rate);

    //서비스 계층에서는 파라미터를 DTO 타입으로 받기 때문에 이를 JPA로 처리하기 위해서 엔티티 타입의 객체로 변환
    default Recall dtoToEntity(RecallDTO dto) {
        Recall recall = Recall.builder()
                .rNo(dto.getRNo())
                .brand(dto.getBrand())
                .model(dto.getModel())
                .reasons(dto.getReasons())
                .ranking(dto.getRanking())
                .amount(dto.getAmount())
                .build();
        return recall;
    }

    //엔티티 객체를 DTO 객체로 변환하는 entityToDto()
    default RecallDTO entityToDTO(Recall recall) {
        RecallDTO dto = RecallDTO.builder()
                .rNo(recall.getRNo())
                .brand(recall.getBrand())
                .model(recall.getModel())
                .reasons(recall.getReasons())
                .ranking(recall.getRanking())
                .amount(recall.getAmount())
                .build();
        return dto;
    }

}