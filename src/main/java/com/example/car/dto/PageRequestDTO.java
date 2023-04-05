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

    public PageRequestDTO() {
        this.page =1;
        this.size=10;
    }

    public Pageable getPageable(Sort sort) {
        return PageRequest.of(page-1, size, sort);
    }
}
