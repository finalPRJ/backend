package com.example.carpj.controller;

import com.example.carpj.dto.CarDTO;
import com.example.carpj.dto.PageRequestDTO;
import com.example.carpj.dto.PageResultDTO;
import com.example.carpj.entity.Car;
import com.example.carpj.service.CarService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/car")
@Log4j2
@RequiredArgsConstructor
public class CarController {

    @Autowired
    private final CarService service;

    @GetMapping("/list")
    public ResponseEntity<PageResultDTO<CarDTO, Car>> list(PageRequestDTO pageRequestDTO, Model model) throws JsonProcessingException {
        log.info("list"+pageRequestDTO);
        model.addAttribute("result", service.getList(pageRequestDTO));
        PageResultDTO<CarDTO, Car> carList = service.getList(pageRequestDTO);

        //검색한 차량과 유사한 차량 불러오기
        log.info("getSimilarCars...");
        String sentence = service.searchSentence(pageRequestDTO); //검색어를 유사한 차량 검색할 수 있는 문장으로 변환
        System.out.println("==========================================="+sentence);

        if(sentence != null) { //검색어가 있을 경우에
            String url = "http://localhost:3030/get_similar_cars?sentence='" + sentence+"'";
            //flask에 전달하기

            RestTemplate restTemplate = new RestTemplate();
            //flask에서 모델 돌려서 비슷한 유형 차 top6 담아오기
            String response = restTemplate.getForObject(url, String.class);

            ObjectMapper objectMapper = new ObjectMapper();
            List<Map<String, Object>> mapList = objectMapper.readValue(response, new TypeReference<List<Map<String, Object>>>() {});

            carList.setResponse(mapList); //유사한 차량 결과도 담기
            System.out.println("===========================================response: "+mapList);
            //이 respone를 flask에서 값을 받아서 react로 전달
        }

        return new ResponseEntity<>(carList, HttpStatus.OK);
    }
}
