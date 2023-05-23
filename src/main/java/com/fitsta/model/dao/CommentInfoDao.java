package com.fitsta.model.dao;

import com.fitsta.model.dto.CommentInfo;

import java.util.List;

public interface CommentInfoDao {
    // 댓글 정보 조회
    List<CommentInfo> getCommentInfo(int postId);
}
