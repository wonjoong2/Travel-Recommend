package com.example.board.controller;

import com.example.board.DTO.Board;
import com.example.board.Manager.OpenApiManager;
import com.example.board.service.TravelService;
import com.example.board.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.Map;

@RequiredArgsConstructor
@Controller
@Slf4j
@RequestMapping("/travel")
public class TravelController {

    private final OpenApiManager openApiManager;
    private final TravelService travelService;
    private final UserService userService;

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
        String sigunCode = (String) params.get("sigunCode");
        String pageNo = (String) params.get("pageNo");
        return ResponseEntity.ok(openApiManager.fetch1(areaCode,sigunCode,pageNo).getBody());
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

    @GetMapping("/api/travel-api3")
    public ResponseEntity<?> fetch3(@RequestParam Map<String, Object> params) throws UnsupportedEncodingException {
        String areaCode = (String) params.get("areaCode");
        return ResponseEntity.ok(openApiManager.fetch3(areaCode).getBody());
    }

    @RequestMapping(value = "/InsertTravelInfo", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public int InsertTravelInfo(@RequestParam Map<String, Object> params, HttpSession session) {
        int result = 0;
        String userId = (String) session.getAttribute("userId");
        int userSeq = Integer.parseInt(userService.userSeqCheck(userId));
        params.put("userSeq",userSeq);
        params.put("userId",userId);

        String contentTypeId = (String) params.get("contentTypeId");

        System.out.println("====================");
        System.out.println(params);
        System.out.println(contentTypeId);
        
        //일반 관광지
        if(contentTypeId.equals("12")){
            result = travelService.InsertGeneralTravel(params);
        }
        //문화시설
        else if(contentTypeId.equals("14")){
            result = travelService.InsertCulture(params);
        }
        //행사/공연/축제
        else if(contentTypeId.equals("15")){
            result = travelService.InsertEvent(params);
        }
        //관광 코스
        else if(contentTypeId.equals("25")){
            result = travelService.InsertTourCourse(params);
        }
        //레포츠
        else if(contentTypeId.equals("28")){
            result = travelService.InsertLeisureSports(params);
        }
        //숙박
        else if(contentTypeId.equals("32")){
            result = travelService.InsertLodging(params);
        }
        //쇼핑
        else if(contentTypeId.equals("38")){
            result = travelService.InsertShopping(params);
        }
        //음식
        else if(contentTypeId.equals("39")){
            result = travelService.InsertFood(params);
        }
        return result;
    }

}
