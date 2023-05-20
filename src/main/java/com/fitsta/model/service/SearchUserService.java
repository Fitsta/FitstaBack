package com.fitsta.model.service;

import com.fitsta.model.dto.SearchUser;

import java.util.List;

public interface SearchUserService {

    // 팔로우 순 20명 유저
    List<SearchUser> getUserListLimitTwenty(int myId);

    // name, nickname 포함된 유저 검색
    List<SearchUser> searchUserByNameAndNickname(String myId, String keyword);

}
