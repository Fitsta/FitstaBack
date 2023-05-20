package com.fitsta.controller;

import com.fitsta.model.dto.SearchUser;
import com.fitsta.model.service.SearchUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/searchUser")
@CrossOrigin("*")
public class SearchUserController {

    @Autowired
    SearchUserService userService;

    @GetMapping("/")
    public ResponseEntity<?> getDetailList() {
        List<SearchUser> userList = userService.getUserList();
        return new ResponseEntity<List<SearchUser>>(userList, HttpStatus.OK);
    }
}