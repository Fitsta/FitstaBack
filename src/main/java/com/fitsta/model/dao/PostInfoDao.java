package com.fitsta.model.dao;

import com.fitsta.model.dto.Post;

import java.util.List;

public interface PostInfoDao {

    // 좋아요순 상위 10개 post
    List<Post> getPostOrderByLikeCount(int myId);

    // 내가 팔로우한 사람의 post
    List<Post> getMyFollowerPostList(int myId);

    // 특정 유저가 등록한 post
    List<Post> getUserPost(int userId);

}
