package com.fitsta.model.service;

import com.fitsta.model.dto.Comment;

public interface CommentService {
    // 댓글 등록
    void addComment(Comment comment);
    // 댓글 수정
    void updateComment(Comment comment);
    // 댓글 삭제
    void deleteComment(int commentId);
}
