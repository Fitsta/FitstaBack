package com.fitsta.model.service;

import com.fitsta.model.dao.PostInfoDao;
import com.fitsta.model.dto.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostInfoServiceImpl implements PostInfoService {

    private PostInfoDao postInfoDao;

    @Autowired
    public void setPostInfoDao(PostInfoDao postInfoDao) {
        this.postInfoDao = postInfoDao;
    }

    @Override
    public List<Post> getMainPost(int myId) {
        // 내가 팔로우한 유
        List<Post> result = postInfoDao.getMyFollowerPostList(myId);
        System.out.println(result);
        result.addAll(postInfoDao.getPostOrderByLikeCount(myId));
        return result;
    }

    @Override
    public List<Post> getUserPost(int userId) {
        return postInfoDao.getUserPost(userId);
    }
}
