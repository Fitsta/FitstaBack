package com.fitsta.model.service;

import com.fitsta.model.dto.User;

import java.util.List;

public interface UserService {
    // 팔로우 순 20명 유저
    List<User> getUserList();
}
