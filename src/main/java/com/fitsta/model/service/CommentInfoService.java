package com.fitsta.model.service;

import com.fitsta.model.dto.CommentInfo;
import com.fitsta.model.dto.Post;

import java.util.List;

public interface CommentInfoService {
    // 댓글 정보 조회
    List<CommentInfo> getCommentInfo(int postId);
}
