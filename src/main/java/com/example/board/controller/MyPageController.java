package com.example.board.controller;

import com.example.board.DTO.Board;
import com.example.board.DTO.User;
import com.example.board.service.MyPageService;
import com.example.board.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/myPage")
@RequiredArgsConstructor
public class MyPageController {

    private final UserService userService;
    private final MyPageService myPageService;

    @RequestMapping(value = "/myPagePop" , method = RequestMethod.POST)
    public String myPagePop(@RequestParam Map<String, Object> params , Board vo, Model model, HttpSession session) {
        String userId = (String) session.getAttribute("userId");
        List<User> userDetail =  userService.userDetail(userId);
        System.out.println(userDetail);
        model.addAttribute("userDetail", userDetail.get(0));

        return "/mypage/myPagePop";

    }

    @RequestMapping(value = "/myTravelPop" , method = RequestMethod.POST)
    public String myTravelPop(@RequestParam Map<String, Object> params , Model model, HttpSession session) {
        String userId = (String) session.getAttribute("userId");
        int userSeq = Integer.parseInt(userService.userSeqCheck(userId));
        System.out.println("=================userSeq");
        System.out.println(userSeq);
        params.put("userSeq",userSeq);
        model.addAttribute("params", params);

        return "/mypage/myTravelPop";

    }

    @RequestMapping("/myTravelList")
    @ResponseBody
    public Map<String, Object> myTravelList(Model model,@RequestParam Map<String, Object> params) throws Exception {

        return myPageService.myTravelList(params);
    }
}
