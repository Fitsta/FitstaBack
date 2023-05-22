package com.fitsta.model.dao;

public interface LikeDao {
    // 좋아요
    void like(int postId);
    // 좋아요 취소
    void unlike(int postId);
}
