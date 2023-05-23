package com.fitsta.model.dao;

import org.apache.ibatis.annotations.Param;

public interface FollowDao {
    // follow
    void follow(@Param("followingId") int followingId,@Param("followerId") int followerId);
    // unfollow
    void unFollow(@Param("followingId") int followingId,@Param("followerId") int followerId);
}
