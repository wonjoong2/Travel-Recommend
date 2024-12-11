package com.example.board.controller;

import com.example.board.Manager.OpenApiManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(TravelController.class)
class TravelControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OpenApiManager openApiManager;

    @Test
    void fetch1_shouldReturnMockedResponse() throws Exception {
        // given
        String areaCode = "01";
        String sigunCode = "02";
        String pageNo = "1";

        // Mock Response 생성
        Map<String, Object> mockBody = new HashMap<>();
        mockBody.put("key1", "value1");
        mockBody.put("key2", "value2");

        ResponseEntity mockResponse = ResponseEntity.ok(mockBody);

        // Mock 설정
        when(openApiManager.fetch1(anyString(), anyString(), anyString()))
                .thenReturn(mockResponse);

        // when & then
        mockMvc.perform(get("/api/travel-api1")
                        .param("areaCode", areaCode)
                        .param("sigunCode", sigunCode)
                        .param("pageNo", pageNo)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()) // HTTP 200 상태 확인
                .andExpect(jsonPath("$.key1").value("value1")) // JSON 응답 검증
                .andExpect(jsonPath("$.key2").value("value2"));
    }

}
