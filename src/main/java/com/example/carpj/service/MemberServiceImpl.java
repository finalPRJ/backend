package com.example.carpj.service;

import com.example.carpj.dto.MemberDTO;
import com.example.carpj.entity.Member;
import com.example.carpj.entity.Role;
import com.example.carpj.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;

    @Override
    public String memberSign(MemberDTO dto) { //회원가입
        try {
            Member entity = dtoToEntity(dto);

            validate(entity);
            log.info("memberSign-------------------"+dto);
            entity.setRole(Role.USER);
            memberRepository.save(entity);
            return entity.getId();
        } catch (Exception e) {
            log.info(e.getMessage());
            return null;
        }
    }

    @Override
    public String memberLogin(String id, String pw) { //로그인
        log.info("memberCheck-------------------");
        if (id == null)
            return null;
        Optional<Member> result = memberRepository.findById(id);
        if (!result.isPresent()) //null일 경우
            return null;
        log.info("result:" + result);
        log.info("db password = {}, input password = {}", result.get().getPw(), pw);
        log.info("pw Check: " + result.get().getPw().equals(pw));
        if (result.get().getPw().equals(pw)) {
            return id;
        }
        return null;
    }

    private void validate(final Member member) {
        if(member == null) {
            log.warn("Entity cannot be null.");
            throw new RuntimeException("Entity cannot be null.");
        }
        Optional<Member> result = memberRepository.findById(member.getId());
        if (result.isPresent()) //null이 아닐 경우 = 이미 존재하는 아이디일 경우
            throw new IllegalStateException("Entity cannot be null.");
    }
}
