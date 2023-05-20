package com.fitsta.model.dao;

import com.fitsta.model.dto.User;

import java.util.List;

public interface UserDao {
    // 팔로우 순 20명 유저
    List<User> getUserList();
}
