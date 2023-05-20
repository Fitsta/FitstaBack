package com.fitsta.model.service;

import com.fitsta.model.dto.SearchUser;

import java.util.List;

public interface SearchUserService {

    // 팔로우 순 20명 유저
    List<SearchUser> getUserList();

}
