package com.fitsta.controller;

import com.fitsta.model.dto.Post;
import com.fitsta.model.service.PostInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/postInfo")
@CrossOrigin("*")
@Api(tags = "PostInfo Controller")
public class PostInfoController {

    @Autowired
    PostInfoService postInfoService;

    @GetMapping("/{myId}")
    @ApiOperation(value = "main 화면 post 정보 조회")
    public ResponseEntity<?> getMainPost(@PathVariable int myId) {
        List<Post> postList = postInfoService.getMainPost(myId);
        return new ResponseEntity<List<Post>>(postList, HttpStatus.OK);
    }

    @GetMapping("/detail/{userId}")
    @ApiOperation(value = "유저가 등록한 post 조회")
    public ResponseEntity<?> getUserPostList(@PathVariable int userId) {
        List<Post> postList = postInfoService.getUserPost(userId);
        return new ResponseEntity<List<Post>>(postList, HttpStatus.OK);
    }
}
