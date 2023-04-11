package com.example.car.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.car.entity.Board;
public interface BoardRepository extends JpaRepository<Board, Integer> {
}
