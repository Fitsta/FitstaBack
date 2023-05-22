package com.fitsta.model.service;

import com.fitsta.model.dao.FollowDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowServiceImpl implements  FollowService{
    private FollowDao followDao;

    @Autowired
    public void setFollowDao(FollowDao followDao) {
        this.followDao = followDao;
    }
    @Override
    public void follow(int followingId) {
        followDao.follow(followingId);
    }

    @Override
    public void unFollow(int followingId) {
        followDao.unFollow(followingId);
    }
}
