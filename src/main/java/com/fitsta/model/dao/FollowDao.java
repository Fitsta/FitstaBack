package com.fitsta.model.dao;

public interface FollowDao {
    // follow
    void follow(int followingId);
    // unfollow
    void unFollow(int followingId);
}
