package com.fitsta.model.dao;

import com.fitsta.model.dto.EnterUser;

import java.util.List;

public interface EnterUserDao {
    // 회원 가입때 필요한 정보 넘기기
    void enterUser(EnterUser enterUser);
    // 중복체크
    EnterUser check(String id);
    // 이메일로 아이디 받기
    int getUserIdByEmail(String email);
    // 이메일로 유저 정보 받기
    EnterUser getUserInfoByEmail(String email);

}
