package com.fitsta.model.service;

import com.fitsta.model.dao.PostDao;
import com.fitsta.model.dto.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService{
    private PostDao postDao;

    @Autowired
    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }

    @Override
    public void addPost(Post post) {
        postDao.addPost(post);
    }

    @Override
    public void updatePost(Post post) {
        postDao.updatePost(post);
    }

    @Override
    public void deletePost(int postId) {
        postDao.deletePost(postId);
    }
}
