package com.example.car.repository.search;

import com.example.car.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SearchBoardRepository {
    Board search1();

    Page<Object[]> searchPage(String type, Pageable pageable);
}
