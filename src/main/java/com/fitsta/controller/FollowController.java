package com.fitsta.controller;

import com.fitsta.model.dao.FollowDao;
import com.fitsta.model.dto.Follow;
import com.fitsta.model.service.FollowService;
import com.sun.tools.jconsole.JConsoleContext;
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
    @PostMapping("/")
    public ResponseEntity<?> follow(@RequestBody Follow follow) {
        followService.follow(follow.getFollowingId(), follow.getFollowerId());
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    // 언팔로우
    @PostMapping("/unfollow")
    public ResponseEntity<?> unfollow(@RequestBody Follow follow) {
        followService.unFollow(follow.getFollowingId(), follow.getFollowerId());
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
