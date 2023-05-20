package com.fitsta.controller;

import com.fitsta.model.dto.Post;
import com.fitsta.model.service.PostInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/postInfo")
@CrossOrigin("*")
public class PostInfoController {

    @Autowired
    PostInfoService postInfoService;

    @GetMapping("/{myId}")
    public ResponseEntity<?> getMainPost(@PathVariable int myId) {
        List<Post> postList = postInfoService.getMainPost(myId);
        return new ResponseEntity<List<Post>>(postList, HttpStatus.OK);
    }

    @GetMapping("/detail/{userId}")
    public ResponseEntity<?> getUserPostList(@PathVariable int userId) {
        List<Post> postList = postInfoService.getUserPost(userId);
        return new ResponseEntity<List<Post>>(postList, HttpStatus.OK);
    }
}
