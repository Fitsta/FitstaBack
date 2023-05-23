package com.fitsta.model.dao;

import com.fitsta.model.dto.Post;

import java.util.List;

public interface ProfileDao {
    int getFollowerCount(int userId);
    int getFollowingCount(int userId);
    List<Post> getPostList(int userId);
    String getProfileImg(int userId);
    String getUserNickname(int userId);
}
