package com.example.carpj.controller;

import com.example.carpj.dto.CarViewDTO;
import com.example.carpj.service.CarViewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/view")
public class CarViewController {
    private final CarViewService carViewService;

    @PostMapping("register") //특정 항목 조회 값 DB에 저장
    public boolean register(@RequestBody CarViewDTO dto) {
        log.info("register...");
        System.out.println(dto.getId()+"----"+dto.getCDNo());
        boolean result = carViewService.register(dto);
        System.out.println("result----------- "+result);
        return result;
    }

    @PostMapping("/rank") //판매 순위
    public List<CarViewDTO> rank() {
        log.info("rank...");
        List<CarViewDTO> rank = carViewService.rank();
        System.out.println("rankResult----------- "+rank);
        return rank;
    }
}
