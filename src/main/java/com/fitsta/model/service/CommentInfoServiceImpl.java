package com.fitsta.model.service;

import com.fitsta.model.dao.CommentInfoDao;
import com.fitsta.model.dto.CommentInfo;
import com.fitsta.model.dto.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentInfoServiceImpl implements CommentInfoService{

    private CommentInfoDao commentInfoDao;

    @Autowired
    public void setCommentInfoDao(CommentInfoDao commentInfoDao) {
        this.commentInfoDao = commentInfoDao;
    }
    @Override
    public List<CommentInfo> getCommentInfo(int postId) {
        return commentInfoDao.getCommentInfo(postId);
    }
}
