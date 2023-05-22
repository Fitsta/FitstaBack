package com.fitsta.model.service;

import com.fitsta.model.dao.LikeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeServiceImpl implements LikeService{
    private LikeDao likeDao;
    @Autowired
    public void setLikeDao(LikeDao likeDao) {
        this.likeDao = likeDao;
    }
    @Override
    public void like(int postId) {
        likeDao.like(postId);
    }

    @Override
    public void unlike(int postId) {
        likeDao.unlike(postId);
    }
}
