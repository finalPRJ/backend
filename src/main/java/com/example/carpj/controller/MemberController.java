package com.example.carpj.controller;

<<<<<<< HEAD
import com.example.carpj.exception.ResourceNotFoundException;
import com.example.carpj.entity.Member;
import com.example.carpj.repository.MemberRepository;
import com.example.carpj.security.CurrentUser;
import com.example.carpj.security.UserPrincipal;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequestMapping("/member")
public class MemberController {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @GetMapping("/me")
    @PreAuthorize("hasRole('USER')")
    public Member getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        System.out.println("=================================user/me=================================");
        //현재 인증된 사용자 정보 가져온다.
        return memberRepository.findById(userPrincipal.getId()) //사용자의 식별자를 기반으로 사용자를 조회하여 반환
                .orElseThrow(() -> new ResourceNotFoundException("Member", "id", userPrincipal.getId()));
=======
import com.example.carpj.dto.MemberDTO;
import com.example.carpj.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

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
>>>>>>> 698735a6ea6fcfaf3c1bd15db650d5fd2d9631c9
    }
}
