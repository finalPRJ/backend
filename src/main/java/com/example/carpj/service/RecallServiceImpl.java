package com.example.carpj.service;

import com.example.carpj.dto.RecallDTO;
import com.example.carpj.entity.Recall;
import com.example.carpj.repository.RecallRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class RecallServiceImpl implements RecallService{
    private final RecallRepository recallRepository;

    @Override
    public List<RecallDTO> best4() { //recall 적게 개시된 TOP4
        try{
            log.info("------------------- Recall best4 -------------------");
            List<Recall> entity = recallRepository.findAll();
            List<RecallDTO> rList = new ArrayList<>();

            for(Recall recall : entity) {
                //ranking값이 -(음수)일 경우
                if(recall.getRanking().contains("-")) {
                    RecallDTO dto = entityToDTO(recall);
                    rList.add(dto);
                }
            }
            return rList.isEmpty() ? null : rList;
        } catch(Exception e) {
            log.info("오류");
            return null;
        }
    }

    @Override
    public List<RecallDTO> worst4() { //recall 많이 개시된 TOP4
        try{
            log.info("------------------- Recall worst4 -------------------");
            List<Recall> entity = recallRepository.findAll();
            List<RecallDTO> rList = new ArrayList<>();

            for(Recall recall : entity) {
                //ranking값이 숫자(양수)일 경우
                if(recall.getRanking().chars().allMatch(Character::isDigit)) {
                    RecallDTO dto = entityToDTO(recall);
                    rList.add(dto);
                }
            }
            return rList.isEmpty() ? null : rList;
        } catch(Exception e) {
            log.info("오류");
            return null;
        }
    }

    @Override
    public List<RecallDTO> worstInfo(String rate) { //recall된 브랜드 별 상세 정보
        try{
            log.info("------------------- Recall worstInfo -------------------");
            List<Recall> entity = recallRepository.findAll();
            List<RecallDTO> rList = new ArrayList<>();
            System.out.println(rate);
            for(Recall recall : entity) {
                //ranking값이 해당 브랜드 정보(순위)이고 알파벳이 포함되어 있는지
                if(recall.getRanking().contains(rate) && !recall.getRanking().chars().allMatch(Character::isDigit) && !recall.getRanking().contains("-")) {
                    RecallDTO dto = entityToDTO(recall);
                    rList.add(dto);
                }
            }
            return rList.isEmpty() ? null : rList;
        } catch(Exception e) {
            log.info("오류");
            return null;
        }
    }
}
