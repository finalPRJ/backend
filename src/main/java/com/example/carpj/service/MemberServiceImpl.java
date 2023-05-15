package com.example.carpj.service;

import com.example.carpj.dto.MemberDTO;
import com.example.carpj.entity.Member;
import com.example.carpj.entity.Role;
import com.example.carpj.jwt.JwtTokenProvider;
import com.example.carpj.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class MemberServiceImpl implements MemberService, UserDetailsService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        Optional<Member> result = memberRepository.findById(id);

        if (!result.isPresent()) //null일 경우
            throw new UsernameNotFoundException(id);

        return User.builder()
                .username(result.get().getId())
                .password(result.get().getPw())
                .roles(result.get().getRole().toString())
                .build();
    }

    @Override
    public String memberSign(MemberDTO dto) { //회원가입
        try {
            Member entity = dtoToEntity(dto);

            validate(entity);
            log.info("memberSign-------------------"+dto);
            entity.setPw(passwordEncoder.encode(entity.getPw()));
            entity.setRole(Role.USER);
            memberRepository.save(entity);
            return entity.getId();
        } catch (Exception e) {
            log.info(e.getMessage());
            return null;
        }
    }

//    @Override
//    public String memberLogin(String id, String pw) { //로그인
//        log.info("memberCheck-------------------");
//        if (id == null)
//            return null;
//        Optional<Member> result = memberRepository.findById(id);
//        if (!result.isPresent()) //null일 경우
//            return null;
//        log.info("result:" + result);
//        log.info("db password = {}, input password = {}", result.get().getPw(), pw);
//        log.info("pw Check: " + passwordEncoder.matches(result.get().getPw(), pw));
//        if (passwordEncoder.matches(result.get().getPw(), pw)) {
//            return id;
//        }
//        return null;
//    }
    @Transactional
    @Override
    public String memberLogin(String id, String pw){
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 E-MAIL 입니다."));
        if (!passwordEncoder.matches(pw, member.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }
        // 로그인에 성공하면 email, roles 로 토큰 생성 후 반환
        return jwtTokenProvider.createToken(member.getUsername(), member.getRoles());
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
