package com.example.car.service;

import com.example.car.dto.CarDTO;
import com.example.car.dto.PageRequestDTO;
import com.example.car.dto.PageResultDTO;
import com.example.car.entity.Car;
import com.example.car.entity.QCar;
import com.example.car.repository.CarRepository;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import lombok.extern.log4j.Log4j2;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;

import java.util.function.Function;


@Service
@Log4j2
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository repository;

    // Querydsl 처리
    private BooleanBuilder getSearch(PageRequestDTO requestDTO) {
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        QCar qCar = QCar.car;

        String[] type = requestDTO.getType();
        String[] keyword = requestDTO.getKeyword();

        BooleanExpression expression1 = qCar.cno.gt(0);

        booleanBuilder.and(expression1);

        if(type == null || type[0].trim().length() == 0) {// 검색 조건이 없는 경우
            return booleanBuilder;
        }

        // 검색 조건 타입
        BooleanBuilder conditionBuilder = new BooleanBuilder();
        for(int i =0; i< type.length; i++) {

            if (type[i].contains("platform")) {     // 플랫폼  (테스트: 성공)
                conditionBuilder.and(qCar.platform.contains(keyword[i]));
            }
            if (type[i].contains("tag")) {     // 태그(국산/수입) (테스트: 성공)
                conditionBuilder.and(qCar.tag.contains(keyword[i]));
            }
            if (type[i].contains("type")) {     // 차종 (테스트: 성공)
                conditionBuilder.and(qCar.type.contains(keyword[i]));
            }
            if (type[i].contains("brand")) {     // 브랜드 (테스트: 성공)
                conditionBuilder.and(qCar.brand.contains(keyword[i]));
            }
            if (type[i].contains("model")) {     // 모델 이름 (테스트: 성공)
                conditionBuilder.and(qCar.model.contains(keyword[i]));
            }
            if (type[i].contains("oil")) {     // 연료 타입 (테스트: 성공)
                conditionBuilder.and(qCar.oil.contains(keyword[i]));
            }
            if (type[i].contains("price")) {     // 가격
                if (type.length == 1) { //keyword=[1200만원, 1600만원]
                    int keyword1_1 = Integer.parseInt(keyword[0].replace("만원", "0000"));
                    int keyword2_1 = Integer.parseInt(keyword[1].replace("만원", "0000"));

                    conditionBuilder.and(qCar.pricer.between(keyword1_1, keyword2_1));
                } else if (type.length > 1){ //keyword=[K-Car, 1200만원,1600만원]
                    String[] keyword1 = StringUtils.split(keyword[i], ",");
                    int keyword1_1 = Integer.parseInt(keyword1[0].replace("만원", "0000"));
                    int keyword2_1 = Integer.parseInt(keyword1[1].replace("만원", "0000"));

                    conditionBuilder.and(qCar.pricer.between(keyword1_1, keyword2_1));
                }
            }
            if (type[i].contains("km")) {       // 주행거리
                if (type.length == 1) {
                    int keyword1_1 = Integer.parseInt(keyword[0].replace("km", ""));
                    int keyword2_1 = Integer.parseInt(keyword[1].replace("km", ""));

                    conditionBuilder.and(qCar.kmr.between(keyword1_1, keyword2_1));
                } else if (type.length > 1){
                    String[] keyword1 = StringUtils.split(keyword[i], ",");
                    int keyword1_1 = Integer.parseInt(keyword1[0].replace("km", ""));
                    int keyword2_1 = Integer.parseInt(keyword1[1].replace("km", ""));

                    conditionBuilder.and(qCar.kmr.between(keyword1_1, keyword2_1));
                }
            }
            if (type[i].contains("year")) {     // 연식
                if (type.length == 1) {
                    int keyword1_1 = Integer.parseInt(keyword[0].replace("년", ""));
                    int keyword2_1 = Integer.parseInt(keyword[1].replace("년", ""));

                    conditionBuilder.and(qCar.year.between(keyword1_1, keyword2_1));
                } else if (type.length > 1){
                    String[] keyword1 = StringUtils.split(keyword[i], ",");
                    int keyword1_1 = Integer.parseInt(keyword1[0].replace("년", ""));
                    int keyword2_1 = Integer.parseInt(keyword1[1].replace("년", ""));

                    conditionBuilder.and(qCar.year.between(keyword1_1, keyword2_1));
                }
            }
        }

        // 검색 조건 통합
        booleanBuilder.and(conditionBuilder);

        return booleanBuilder;
    }

    @Override
    public PageResultDTO<CarDTO, Car> getList(PageRequestDTO requestDTO) {
        Pageable pageable = requestDTO.getPageable(Sort.by("cno").descending());

        BooleanBuilder booleanBuilder = getSearch(requestDTO);  // 검색 조건 처리

        Page<Car> result = repository.findAll(booleanBuilder, pageable);  // Querydsl 사용

        Function<Car, CarDTO> fn = (entity -> entityToDto(entity));

        return new PageResultDTO<>(result, fn);
    }
}
