package com.fitsta.model.service;

public interface FollowService {
    // follow
    void follow(int followingId, int followerId);
    // unfollow
    void unFollow(int followingId, int followerId);
}
