package com.fitsta.model.dao;

import org.apache.ibatis.annotations.Param;

public interface LikeDao {
    // 좋아요
    void like(@Param("postId") int postId, @Param("userId") int userId);
    // 좋아요 취소
    void unlike(@Param("postId") int postId, @Param("userId") int userId);
}
