package com.example.board.controller;

import com.example.board.DTO.Board;
import com.example.board.DTO.User;
import com.example.board.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/myPage")
@RequiredArgsConstructor
public class MyPageController {

    private final UserService userService;

    @RequestMapping(value = "/myPagePop" , method = RequestMethod.POST)
    public String BoardDetail(@RequestParam Map<String, Object> params , Board vo, Model model, HttpSession session) {
        String userId = (String) session.getAttribute("userId");
        List<User> userDetail =  userService.userDetail(userId);
        System.out.println(userDetail);
        System.out.println(userDetail);
        System.out.println(userDetail);
        System.out.println(userDetail);
        model.addAttribute("userDetail", userDetail);

        return "/mypage/myPagePop";

    }
}
