package com.example.carpj.service;

import com.example.carpj.dto.CarViewDTO;
import com.example.carpj.entity.CarView;
import com.example.carpj.repository.CarViewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor //JPA 처리를 위한 의존성 주입
@Log4j2
public class CarViewServiceImpl implements CarViewService{
    private final CarViewRepository carViewRepository; //자동 주입 final

    @Override
    @Transactional
    public List<CarViewDTO> rank() { //전체 조회수 순위
        try {
            log.info("전체 조회수 순위-------------------");
            List<CarView> entity = carViewRepository.findAll(Sort.by(Sort.Direction.DESC, "count"));
            List<CarViewDTO> viewList = new ArrayList<>();

            for(CarView carView : entity) {
                CarViewDTO dto = entityToDTO(carView);
                viewList.add(dto);
            }
            return viewList;
        } catch(Exception e) {
            log.info(e.getMessage());
            return null;
        }
    }
}
