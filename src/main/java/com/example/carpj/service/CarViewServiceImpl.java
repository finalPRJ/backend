package com.example.carpj.service;

import com.example.carpj.dto.CarViewDTO;
import com.example.carpj.entity.CarView;
import com.example.carpj.entity.CarViewId;
import com.example.carpj.repository.CarViewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor //JPA 처리를 위한 의존성 주입
@Log4j2
public class CarViewServiceImpl implements CarViewService{
    private final CarViewRepository carViewRepository; //자동 주입 final

    @Override
    @Transactional
    public boolean register(CarViewDTO dto) { //특정 항목 조회 값 DB에 저장
        try {
            log.info("특정 항목 조회 값 DB에 저장-------------------");
            CarViewId vcId = new CarViewId(dto.getId(), dto.getCDNo()); //복합키
            Optional<CarView> result = carViewRepository.findById(vcId); //기존에 데이터가 있는지 확인하기 위해서, 해당 데이터가 있는지 확인
            CarView carView = dtoToEntity(dto);

            if(result.isPresent()) { //null이 아니면
                carView.updateViewCount(result.get().getCount()); //view count 1 증가
            } else { //null이면
                carView.setCount(1);
            }
            carViewRepository.save(carView);
            return true;

        } catch(Exception e) {
            log.info(e.getMessage());
            return false;
        }
    }

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
