package com.example.board.controller;

import com.example.board.DTO.Board;
import com.example.board.DTO.Travel;
import com.example.board.Manager.OpenApiManager;
import com.example.board.service.TravelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Controller
@Slf4j
@RequestMapping("/travel")
public class TravelController {

    private final OpenApiManager openApiManager;
    private final TravelService travelService;

    /*
    *
    *
    * */
    @RequestMapping("/TravelList")
    public String TravelList(Model model) {

        return "/travel/TravelList";
    }

    @GetMapping("/api/travel-api1")
    public ResponseEntity<?> fetch1(@RequestParam Map<String, Object> params) throws UnsupportedEncodingException {
        String areaCode = (String) params.get("areaCode");
        String pageNo = (String) params.get("pageNo");
        return ResponseEntity.ok(openApiManager.fetch1(areaCode,pageNo).getBody());
    }

    @PostMapping(value = "/api/travelDetail")
    public String travelDetail(@RequestParam Map<String, Object> params , Board vo, Model model) {
        model.addAttribute("TravelDetail", params);
        return "/travel/TravelDetail";
    }

    @GetMapping("/api/travel-api2")
    public ResponseEntity<?> fetch2(@RequestParam Map<String, Object> params) throws UnsupportedEncodingException {
        String contentId = (String) params.get("contentId");
        String contentTypeId = (String) params.get("contentTypeId");
        return ResponseEntity.ok(openApiManager.fetch2(contentId,contentTypeId).getBody());
    }

}
