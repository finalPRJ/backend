package com.example.carpj.entity;
<<<<<<< HEAD
=======

>>>>>>> 698735a6ea6fcfaf3c1bd15db650d5fd2d9631c9
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
<<<<<<< HEAD

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
=======
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
>>>>>>> 698735a6ea6fcfaf3c1bd15db650d5fd2d9631c9

@Entity
@Builder
@Data
@AllArgsConstructor //필드 값을 다 넣은 생성자
@NoArgsConstructor //기본 생성자
<<<<<<< HEAD
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name; //이름

    @Email
    @Column(nullable = false)
    private String email; //이메일

    private String imageUrl; //프로필

    @NotNull
    @Enumerated(EnumType.STRING)
    private AuthProvider provider;

    private String providerId; //외부 인증 제공자의 사용자 식별자 저장
=======
@Table(name = "member")
public class Member implements UserDetails {
    @Id
    private String id; //아이디(이메일)

    @Column(length = 1000, nullable = false)
    private String pw; //패스워드

    private String name; //이름

    private String nickname; //닉네임

    private String phone; //전화번호

    private String address; //주소

    private String detail_Address; //상세 주소

    private String location_Num; //우편번호

    private Integer age; //나이

    private String platform; //토큰

    @Enumerated(EnumType.STRING)
    private Role role;

    @ElementCollection(fetch = FetchType.EAGER)
    @Builder.Default
    private List<String> roles = new ArrayList<>();


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return pw;
    }

    @Override
    public String getUsername() {
        return id;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

>>>>>>> 698735a6ea6fcfaf3c1bd15db650d5fd2d9631c9
}
