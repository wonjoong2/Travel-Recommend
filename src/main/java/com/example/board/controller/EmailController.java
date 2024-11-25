package com.example.board.controller;

import com.example.board.service.EmailService;
import jakarta.mail.MessagingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/userAuthEmail")
    @ResponseBody
    public Map<String, String> mailSend(@RequestParam Map<String, Object> params) throws MessagingException {
        String email = (String) params.get("userEmail");
        String authCode = emailService.sendEmail(email);
        emailService.sendEmail(email);

        Map<String, String> response = new HashMap<>();
        response.put("message", "인증코드가 발송되었습니다.");
        response.put("authCode", authCode);
        return response;
    }

    @RequestMapping(value = "/mailIdFind", method = RequestMethod.POST)
    public String mailIdFind(@RequestParam Map<String, Object> params, Model model) {
        String result = emailService.mailIdFind(params);
        model.addAttribute("result", result);
        log.info(result);
        log.info(result);
        return "/mail/FindId";
    }


    @RequestMapping(value = "/mailPwFindPop", method = RequestMethod.POST)
    public String mailPwFindPop(@RequestParam Map<String, Object> params,Model model) {
        model.addAttribute("params", params);
        return "/mail/FindPw";
    }

    @RequestMapping(value = "/mailPwFind", method = RequestMethod.POST)
    @ResponseBody
    public int mailPwFind(@RequestParam Map<String, Object> params, Model model) {
        int result = emailService.mailPwFind(params);
        return result;
    }
}
