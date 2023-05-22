package com.fitsta.model.service;

import com.fitsta.model.dao.CommentDao;
import com.fitsta.model.dto.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentDao commentDao;

    @Autowired
    public void setCommentDao(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    @Override
    public void addComment(Comment comment) {
        commentDao.addComment(comment);
    }

    @Override
    public void updateComment(Comment comment) {
        commentDao.updateComment(comment);
    }

    @Override
    public void deleteComment(int commentId) {
        commentDao.deleteComment(commentId);
    }
}
