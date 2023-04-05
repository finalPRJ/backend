package com.example.car.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.car.entity.Car;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer>, QuerydslPredicateExecutor<Car> {
}
