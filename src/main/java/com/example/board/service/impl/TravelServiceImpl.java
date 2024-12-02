package com.example.board.service.impl;

import com.example.board.DTO.GeneralTravel;
import com.example.board.mapper.TravelRepository.GeneralTravelRepository;
import com.example.board.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

@Service
public class TravelServiceImpl implements TravelService {

    @Autowired
    private GeneralTravelRepository generalTravelRepository;

    @Override
    public int InsertGeneralTravel(Map<String, Object> params) {
        System.out.println("============fdsaf");
        System.out.println(params);
        GeneralTravel gT = new GeneralTravel();
        Integer userSeq = (Integer) params.get("userSeq");
        gT.setUserSeq(userSeq);
        gT.setAccomCount((String) params.get("accomCount"));
        gT.setChkBabyCarriage((String) params.get("chkBabyCarriage"));
        gT.setChkCreditCard((String) params.get("chkCreditCard"));
        gT.setChkPet((String) params.get("chkPet"));
        gT.setExpAgeRange((String) params.get("expAgeRange"));
        gT.setInfoCenter((String) params.get("infoCenter"));
        gT.setOpenDate((String) params.get("openDate"));
        gT.setRestDate((String) params.get("restDate"));
        gT.setUseSeason((String) params.get("useSeason"));
        gT.setUseTime((String) params.get("useTime"));
        gT.setCreateId((String) params.get("userId"));
        gT.setCreateDt(LocalDateTime.now());

        GeneralTravel saveGt = generalTravelRepository.save(gT);
        return saveGt.getUserSeq();
    }

    @Override
    public int InsertCulture(Map<String, Object> params) {
        return 0;
    }

    @Override
    public int InsertEvent(Map<String, Object> params) {
        return 0;
    }

    @Override
    public int InsertTourCourse(Map<String, Object> params) {
        return 0;
    }

    @Override
    public int InsertLeisureSports(Map<String, Object> params) {
        return 0;
    }

    @Override
    public int InsertLodging(Map<String, Object> params) {
        return 0;
    }

    @Override
    public int InsertShopping(Map<String, Object> params) {
        return 0;
    }

    @Override
    public int InsertFood(Map<String, Object> params) {
        return 0;
    }
}
