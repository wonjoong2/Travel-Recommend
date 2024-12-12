package com.example.board.controller;

import com.example.board.DTO.Comment;
import com.example.board.service.CommentService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@Slf4j
public class CommentController {

    private final CommentService commentService;

    @ResponseBody
    @GetMapping("/comment/list")
    public List<Comment> commentList(@RequestParam Map<String, Object> params) {

        return commentService.commentList(params);
    }

    @RequestMapping(value = "/comment/add", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public int commentRegister(@RequestParam Map<String, Object> params, HttpSession session) {
        int result = 0;
        result = commentService.commentRegister(params);
        return result;
    }
}