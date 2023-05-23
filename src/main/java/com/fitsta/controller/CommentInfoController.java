package com.fitsta.controller;

import com.fitsta.model.dto.CommentInfo;
import com.fitsta.model.service.CommentInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commentInfo")
@CrossOrigin("*")
public class CommentInfoController {
    @Autowired
    CommentInfoService commentInfoService;

    // 댓글 정보 불러오기
    @GetMapping("/{postId}")
    @ApiOperation(value = "댓글 구성하는 정보 조회")
    public ResponseEntity<?> getCommentInfo(@PathVariable int postId) {
        List<CommentInfo> commentInfoList =  commentInfoService.getCommentInfo(postId);
        return new ResponseEntity<List<CommentInfo>>(commentInfoList, HttpStatus.OK);
    }
}
