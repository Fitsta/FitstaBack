package com.fitsta.controller;

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
    public ResponseEntity<?> enter(@RequestBody EnterUser user) {
        if (enterUserService.check(user.getEmail()) != null) {
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
        enterUserService.enterUser(user);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    // userId로 이름받기
    @GetMapping("/{userId}")
    public ResponseEntity<?> getNickname(@PathVariable int userId) {
        String nickName = enterUserService.getUserNickname(userId);
        return new ResponseEntity<String>(nickName, HttpStatus.OK);
    }
}
