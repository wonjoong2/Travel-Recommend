package com.example.board.Manager;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class OpenApiManager {
    private final String BASE_URL = "http://apis.data.go.kr/B551011/KorService1";
    //지역기반 관광정보조회
    private final String apiUri1 = "/areaBasedList1";
    //소개정보조회
    private final String apiUri2 = "/detailIntro1";
    private final String serviceKey = "?ServiceKey=b2dGzeG6B3jL/B7DSWnpmASzrOYq7/X5t5eOQT01hikFxhxcfQJZTaWlRXAtRnBipog91ECkVA3tz/wOBrsbPA==";
    private final String defaultQueryParam = "&MobileOS=ETC&MobileApp=AppTest&_type=json";
    private final String numOfRows = "&numOfRows=10";

    private String makeUrl1(String areaCode) throws UnsupportedEncodingException {
        return BASE_URL +
                apiUri1 +
                serviceKey +
                defaultQueryParam +
                numOfRows +
                "&areaCode=" + areaCode;
    }

    private String makeUrl2(String contentId, String contentTypeId) throws UnsupportedEncodingException {
        return BASE_URL +
                apiUri2 +
                serviceKey +
                defaultQueryParam +
                numOfRows +
                "&contentTypeId=" + contentTypeId +
                "&contentId=" + contentId;

    }

    public ResponseEntity<?> fetch1(String areaCode) throws UnsupportedEncodingException {
        System.out.println(makeUrl1(areaCode));
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<?> entity = new HttpEntity<>(new HttpHeaders());
        ResponseEntity<Map> resultMap = restTemplate.exchange(makeUrl1(areaCode), HttpMethod.GET, entity, Map.class);
        System.out.println(resultMap.getBody());
        return resultMap;

    }

    public ResponseEntity<?> fetch2(String contentId, String contentTypeId) throws UnsupportedEncodingException {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<?> entity = new HttpEntity<>(new HttpHeaders());
        ResponseEntity<Map> resultMap = restTemplate.exchange(makeUrl2(contentId, contentTypeId), HttpMethod.GET, entity, Map.class);
        System.out.println(resultMap.getBody());
        return resultMap;

    }
}
