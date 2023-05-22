package com.fitsta.model.service;

import com.fitsta.model.dto.EnterUser;

import java.util.List;

public interface EnterUserService {
    // 회원 가입때 필요한 정보 넘기기
    void enterUser(EnterUser enterUser);
}
