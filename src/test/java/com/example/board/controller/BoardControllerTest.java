package com.example.board.controller;

import com.example.board.service.BoardService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BoardController.class)
class BoardControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BoardService boardService;

    @Test
    void testBoardRegister() throws Exception {

        // Mock 데이터 설정
        MockHttpSession session = new MockHttpSession();
        session.setAttribute("userId", "testUser");

        // boardService.InsertBoard 메서드의 Mock 동작 정의
        when(boardService.InsertBoard(any())).thenReturn(1); // 항상 1 반환

        // 요청 데이터
        String jsonParams = "{\"boardTitle\":\"Test Title\",\"boardContent\":\"Test Content\"}";

        // POST 요청 테스트
        mockMvc.perform(post("/board/BoardRegister")
                        .session(session) // 세션 데이터 추가
                        .contentType(MediaType.APPLICATION_JSON) // JSON 요청
                        .content(jsonParams)) // 요청 데이터
                .andExpect(status().isOk()) // HTTP 상태 코드 200 확인
                .andExpect(content().string("1")); // 반환값이 1인지 확인
    }
}
