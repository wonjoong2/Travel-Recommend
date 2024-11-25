package com.example.board.Manager;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class OpenApiManager {
    private final String BASE_URL = "http://apis.data.go.kr/B551011/KorService1";
    private final String apiUri = "/detailInfo1";
    private final String serviceKey = "?ServiceKey=b2dGzeG6B3jL/B7DSWnpmASzrOYq7/X5t5eOQT01hikFxhxcfQJZTaWlRXAtRnBipog91ECkVA3tz/wOBrsbPA==";
    private final String defaultQueryParam = "&MobileOS=ETC&MobileApp=AppTest&_type=json";
    private final String numOfRows = "&numOfRows=10";
    private final String contentId = "&contentId=2987549";
    private final String contentTypeId = "&contentTypeId=25";


    private String makeUrl() throws UnsupportedEncodingException {
        return BASE_URL +
                apiUri +
                serviceKey +
                defaultQueryParam +
                numOfRows +
                contentId +
                contentTypeId;
    }

    public ResponseEntity<?> fetch() throws UnsupportedEncodingException {
        System.out.println(makeUrl());
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<?> entity = new HttpEntity<>(new HttpHeaders());
        ResponseEntity<Map> resultMap = restTemplate.exchange(makeUrl(), HttpMethod.GET, entity, Map.class);
        System.out.println(resultMap.getBody());
        return resultMap;

    }
}
