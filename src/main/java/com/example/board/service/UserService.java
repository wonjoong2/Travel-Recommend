package com.example.board.service;

import java.util.Map;

public interface UserService {

    int InsertUser(Map<String, Object> params);
    int IdCheck(Map<String, Object> params);
    int loginIdCheck(Map<String, Object> params);
    String loginPwdCheck(Map<String, Object> params);
    int userUpdatePw(Map<String, Object> params);
}
