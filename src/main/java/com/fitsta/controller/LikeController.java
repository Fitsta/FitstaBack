package com.fitsta.controller;

import com.fitsta.model.dto.Like;
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
    @PostMapping("/")
    public ResponseEntity<?> like(@RequestBody Like like) {
        likeService.like(like.getPostId(), like.getUserId());
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    // disLike
    @PostMapping("/dislike")
    public ResponseEntity<?> disLike(@RequestBody Like like) {
        likeService.unlike(like.getPostId(), like.getUserId());
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
