package com.example.board.service.impl;

import com.example.board.mapper.MyPageRepository;
import com.example.board.mapper.TravelRepository.GeneralTravelRepository;
import com.example.board.service.MyPageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class MyPageServiceImpl implements MyPageService {

    private final GeneralTravelRepository generalTravelRepository;

    @Override
    public Map<String, Object> myTravelList(Map<String, Object> params) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        String userSeqStr = (String) params.get("userSeq");
        Integer userSeq = Integer.parseInt(userSeqStr);
        map.put("myGeneralTravelList", generalTravelRepository.myGeneralTravelList(userSeq));

        System.out.println("====================map");
        System.out.println(map);
        return map;
    }
}
