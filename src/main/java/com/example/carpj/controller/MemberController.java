package com.example.carpj.controller;

import com.example.carpj.dto.MemberDTO;
import com.example.carpj.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/sign") //회원가입
    public String memberRegister(MemberDTO memberDTO) {
        log.info("sign...");
        String id = memberService.memberSign(memberDTO);
        System.out.println("id-----------"+id);
        return id;

    }

    @PostMapping("/login") //로그인
    public String login(MemberDTO memberDTO) {
        log.info("login...");
        log.info(memberDTO.toString());
        String check = memberService.memberLogin(memberDTO.getId(), memberDTO.getPw());
        System.out.println("check: " + check);

        return check;
    }
}
