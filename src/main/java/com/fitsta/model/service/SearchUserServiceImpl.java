package com.fitsta.model.service;

import com.fitsta.model.dao.SearchUserDao;
import com.fitsta.model.dto.SearchUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchUserServiceImpl implements SearchUserService {

    private SearchUserDao searchUserDao;

    @Autowired
    public void setUserDao(SearchUserDao searchUserDao) {
        this.searchUserDao = searchUserDao;
    }

    // 팔로워 수 상위 20명 유저(본인 제외)
    @Override
    public List<SearchUser> getUserListLimitTwenty(int myId) {
        return searchUserDao.getUserListLimitTwenty(myId);
    }

    // name, nickname 포함된 유저 검색
    @Override
    public List<SearchUser> searchUserByNameAndNickname(String myId, String keyword) {
        return searchUserDao.searchUserByNameAndNickname(myId, keyword);
    }

    // follower 정보 가져오기
    @Override
    public List<SearchUser> getFollowerList(int userId) {
        return searchUserDao.getFollowerList(userId);
    }

    // following 정보 가져오기
    @Override
    public List<SearchUser> getFollowingList(int userId) {
        return searchUserDao.getFollowingList(userId);
    }

}
