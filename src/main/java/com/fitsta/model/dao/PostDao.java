package com.fitsta.model.dao;

import com.fitsta.model.dto.Post;

public interface PostDao {
    // post 조회
    Post getPost(int postId);
    // post 등록
    void addPost(Post post);
    // post 수정
    void updatePost(Post post);
    // post 삭제
    void deletePost(int postId);
}
