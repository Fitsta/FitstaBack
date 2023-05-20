package com.fitsta.controller;

import com.fitsta.model.dto.User;
import com.fitsta.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/review")
@CrossOrigin("*")
public class ReviewController {

    @Autowired
    UserService userService;

    @GetMapping("/detail")
    public ResponseEntity<?> getDetailList() {
        System.out.println(123);
        List<User> userList = userService.getUserList();
        return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
    }
}