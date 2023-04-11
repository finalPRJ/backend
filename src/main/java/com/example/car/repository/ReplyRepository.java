package com.example.car.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.car.entity.Reply;
public interface ReplyRepository extends JpaRepository<Reply, Integer> {
}
