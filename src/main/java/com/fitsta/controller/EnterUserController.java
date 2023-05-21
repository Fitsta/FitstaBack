package com.fitsta.controller;

import com.fitsta.model.dto.Comment;
import com.fitsta.model.dto.EnterUser;
import com.fitsta.model.service.EnterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/enter")
@CrossOrigin("*")
public class EnterUserController {
    @Autowired
    EnterUserService enterUserService;

    // 회원 가입때 필요한 정보 넘기기("/")
    @PostMapping("/")
    public ResponseEntity<?> enter(@RequestBody EnterUser enterUser) {
        enterUserService.enterUser(enterUser);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
