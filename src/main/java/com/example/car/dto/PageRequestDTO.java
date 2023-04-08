package com.example.car.dto;

import lombok.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.StringUtils;

@Builder
@AllArgsConstructor
@Data
public class PageRequestDTO {

    // 페이지
    private int page;
    private int size;

    // 검색 조건, 키워드 추가
    private String[] type;
    private String[] keyword;

    // 리스 게시판 검색에서 쓰일 것
    private String btype;       // 제목, 내용, 닉네임으로 검색
    private String bkeyword;    // 선택한 type에 대한 내용

    public PageRequestDTO() {
        this.page =1;
        this.size=20;
    }

    public Pageable getPageable(Sort sort) {
        return PageRequest.of(page-1, size, sort);
    }
}
