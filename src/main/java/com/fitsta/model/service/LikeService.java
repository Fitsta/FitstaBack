package com.fitsta.model.service;

public interface LikeService {
    // 좋아요
    void like(int postId, int userId);
    // 좋아요 취소
    void unlike(int postId, int userId);
}
