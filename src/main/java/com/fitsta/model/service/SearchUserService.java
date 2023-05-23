package com.fitsta.model.service;

import com.fitsta.model.dto.SearchUser;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface SearchUserService {

    // 팔로우 순 20명 유저
    List<SearchUser> getUserListLimitTwenty(int myId);

    // name, nickname 포함된 유저 검색
    List<SearchUser> searchUserByNameAndNickname(String myId, String keyword);

    // follower 목록
    List<SearchUser> getFollowerList(@PathVariable int userId);
    // following 목록
    List<SearchUser> getFollowingList(@PathVariable int userId);

}
