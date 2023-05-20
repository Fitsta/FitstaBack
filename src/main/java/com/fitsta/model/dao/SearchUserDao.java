package com.fitsta.model.dao;

import com.fitsta.model.dto.SearchUser;

import java.util.List;

public interface SearchUserDao {


    // 팔로우 순 20명 유저
    List<SearchUser> getUserList();
}
