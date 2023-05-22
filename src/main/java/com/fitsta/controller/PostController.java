package com.fitsta.controller;

import com.fitsta.model.dto.Post;
import com.fitsta.model.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
@CrossOrigin("*")
public class PostController {
    @Autowired
    PostService postService;

    // 게시물 등록
    @PostMapping("/regist")
    public ResponseEntity<?> regist(@RequestBody Post post) {
        postService.addPost(post);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    // 게시물 수정
    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Post post) {
        postService.updatePost(post);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    // 게시물 삭제
    @DeleteMapping("/delete/{postId}")
    public ResponseEntity<?> delete(int postId) {
        postService.deletePost(postId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
