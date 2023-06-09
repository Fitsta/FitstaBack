package com.fitsta.model.service;

import com.fitsta.model.dao.EnterUserDao;
import com.fitsta.model.dto.EnterUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterUserServiceImpl implements EnterUserService{

    private EnterUserDao enterUserDao;

    @Autowired
    public void setEnterUserDao(EnterUserDao enterUserDao) {
        this.enterUserDao = enterUserDao;
    }

    @Override
    public void enterUser(EnterUser enterUser) {
        enterUserDao.enterUser(enterUser);
    }

    @Override
    public EnterUser check(String id) {
        return enterUserDao.check(id);
    }

    @Override
    public int getUserIdByEmail(String email) {
        return enterUserDao.getUserIdByEmail(email);
    }

    @Override
    public EnterUser getUserInfoByEmail(String email) {
        return enterUserDao.getUserInfoByEmail(email);
    }

    @Override
    public void updateUserInfo(EnterUser enterUser) {
        enterUserDao.updateUserInfo(enterUser);
    }

    @Override
    public void updateUserInfoWhthImg(EnterUser enterUser) {
        enterUserDao.updateUserInfoWhthImg(enterUser);
    }

    @Override
    public String getUserNickname(int userId) {
        return enterUserDao.getUserNickname(userId);
    }
}
