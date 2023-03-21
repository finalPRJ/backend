package com.example.carpj.controller;

import com.example.carpj.dto.RecallDTO;
import com.example.carpj.service.RecallService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/recall")
public class RecallController {
    private final RecallService recallService;

    @PostMapping("/best")
    public List<RecallDTO> best() { //recall 적게 된 TOP4
        log.info("best.....");
        List<RecallDTO> rList = recallService.best4();
        return rList;
    }

    @PostMapping("/worst")
    public List<RecallDTO> worst() { //recall 많이 된 TOP4
        log.info("worst.....");
        List<RecallDTO> rList = recallService.worst4();
        return rList;
    }

    @PostMapping("/worstInfo")
    public List<RecallDTO> worstInfo(@RequestParam("rate") String rate) { //recall 많이 된 브랜드 별 상세 정보
        log.info("worstInfo.....");
        List<RecallDTO> rList = recallService.worstInfo(rate);
        return rList;
    }
}
