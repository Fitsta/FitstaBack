package com.fitsta.model.service;

public interface LikeService {
    // 좋아요
    void like(int postId);
    // 좋아요 취소
    void unlike(int postId);
}
