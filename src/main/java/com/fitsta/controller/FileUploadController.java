package com.fitsta.controller;

import com.fitsta.model.dto.Post;
import com.fitsta.model.service.PostService;
import com.fitsta.model.service.S3Upload;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
@CrossOrigin("*")
public class FileUploadController {

    @Autowired
    PostService postService;

    private final S3Upload s3Upload;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("images") MultipartFile multipartFile, Post post) throws IOException {
        // 이거들어오고
        // private int userId;
        // private String postComment;
        // private String filterName;
        // String img 이거는 아래리턴 값으로 받아서 매퍼에 저장
        if (multipartFile.getSize() > 0) {
            String s3URL = s3Upload.upload(multipartFile);
            post.setImg(s3URL);
            postService.addPost(post);
        } else {
            postService.addPost(post);
        }
        System.out.println(post);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @PostMapping("/upload/update")
    public ResponseEntity<?> uploadFileUpdate(@RequestParam("images") MultipartFile multipartFile, Post post) throws IOException {
        if (multipartFile.getSize() > 0) {
            String s3URL = s3Upload.upload(multipartFile);
            post.setImg(s3URL);
            postService.updatePost(post);
        } else {
            postService.updatePost(post);
        }
        System.out.println(post);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}
