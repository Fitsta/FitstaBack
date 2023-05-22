package com.fitsta.controller;

import com.fitsta.model.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/like")
@CrossOrigin("*")
public class LikeController {
    @Autowired
    LikeService likeService;

    // like
    @PostMapping("/{postId}")
    public ResponseEntity<?> like(int postId, int userId) {
        likeService.like(postId, userId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    // disLike
    @DeleteMapping("/{postId}")
    public ResponseEntity<?> disLike(int postId, int userId) {
        likeService.unlike(postId, userId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
