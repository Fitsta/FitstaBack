package com.fitsta.model.dao;

import com.fitsta.model.dto.SearchUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface SearchUserDao {

    // 팔로워 수 상위 20명 유저
    List<SearchUser> getUserListLimitTwenty(int myId);

    // name, nickname 포함된 유저 검색
    List<SearchUser> searchUserByNameAndNickname(@Param("myId") String myId, @Param("keyword") String keyword);

    // follower 목록
    List<SearchUser> getFollowerList(@PathVariable int userId);
    // following 목록
    List<SearchUser> getFollowingList(@PathVariable int userId);
}
