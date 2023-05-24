package com.fitsta.model.service;

import com.fitsta.model.dto.Post;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PostInfoService {

    // 내가 팔로우한 사람의 post + 좋아요순 상위 10개 post
    List<Post> getMainPost(int myId);

    // 특정 유저가 등록한 post
    List<Post> getUserPost(int userId, int myId);

}
