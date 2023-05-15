package com.example.carpj.repository;

import com.example.carpj.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);
=======

public interface MemberRepository extends JpaRepository<Member, String> {
>>>>>>> 698735a6ea6fcfaf3c1bd15db650d5fd2d9631c9
}
