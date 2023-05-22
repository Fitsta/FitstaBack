package com.fitsta.model.dao;

import com.fitsta.model.dto.Comment;

public interface CommentDao {
    // 댓글 등록
    void addComment(Comment comment);
    // 댓글 수정
    void updateComment(Comment comment);
    // 댓글 삭제
    void deleteComment(int commentId);
}
