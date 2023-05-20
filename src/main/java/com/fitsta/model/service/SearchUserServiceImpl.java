package com.fitsta.model.service;

import com.fitsta.model.dao.SearchUserDao;
import com.fitsta.model.dto.SearchUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchUserServiceImpl implements SearchUserService {

    private SearchUserDao userDao;

    @Autowired
    public void setUserDao(SearchUserDao userDao) {
        this.userDao = userDao;
    }

    // 팔로우순 상위 20명 유저 불러오기
    @Override
    public List<SearchUser> getUserList() {
        return userDao.getUserList();
    }

}
