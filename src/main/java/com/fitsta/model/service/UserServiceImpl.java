package com.fitsta.model.service;

import com.fitsta.model.dao.UserDao;
import com.fitsta.model.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    // 팔로우순 상위 20명 유저 불러오기
    @Override
    public List<User> getUserList() {
        return userDao.getUserList();
    }

}
