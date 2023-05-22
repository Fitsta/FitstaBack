package com.fitsta.controller;

import com.fitsta.model.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/follow")
@CrossOrigin("*")
public class FollowController {
    @Autowired
    FollowService followService;

    // 팔로우
    @PostMapping("/{followingId}")
    public ResponseEntity<?> follow(@PathVariable int followingId, int followerId) {
        followService.follow(followingId, followerId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    // 언팔로우
    @DeleteMapping("/{followingId}")
    public ResponseEntity<?> unfollow(@PathVariable int followingId,  int followerId) {
        followService.unFollow(followingId, followerId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
