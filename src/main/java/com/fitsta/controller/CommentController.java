package com.fitsta.controller;

import com.fitsta.model.dto.Comment;
import com.fitsta.model.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comment")
@CrossOrigin("*")
public class CommentController {
    @Autowired
    CommentService commentService;

    // 댓글 등록("/regist")
    @PostMapping("/regist")
    public ResponseEntity<?> regist(@RequestBody Comment comment) {
        commentService.addComment(comment);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    // 댓글 수정("/update")
    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Comment comment) {
        commentService.updateComment(comment);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    // 댓글 삭제("/delete")
    @DeleteMapping("/delete/{commentId}")
    public ResponseEntity<?> delete(@PathVariable int commentId) {
        commentService.deleteComment(commentId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
