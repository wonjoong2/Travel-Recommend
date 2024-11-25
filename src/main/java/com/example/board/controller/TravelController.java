package com.example.board.controller;

import com.example.board.Manager.OpenApiManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.util.Map;

@RequiredArgsConstructor
@Controller
@Slf4j
@RequestMapping("/travel")
public class TravelController {

    private final OpenApiManager openApiManager;
    //private final TravelService travelService;

    /*
    *
    *
    * */
    @RequestMapping("/TravelList")
    public String TravelList(Model model) {
//        List<Board> boardList = boardService.BoardList();
//        model.addAttribute("BoardList", boardList);

        return "/travel/TravelList";
    }

    @GetMapping("/travel-api")
    public ResponseEntity<?> fetch() throws UnsupportedEncodingException {
        return ResponseEntity.ok(openApiManager.fetch().getBody());
    }

}
