package com.fitsta.controller;

import com.fitsta.model.dto.EnterUser;
import com.fitsta.model.service.EnterUserService;
import com.fitsta.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/local/")
@CrossOrigin("*")
public class LocalLoginEnterController {

    @Autowired
    EnterUserService enterUserService;

    @Autowired
    private JWTUtil jwtUtil;
    private static final String SUCCESS = "succes";
    private static final String FAIL = "fail";

    @PostMapping("/")
    public ResponseEntity<?> login(@RequestBody EnterUser enterUser) {
        // 유저 있는지 검사
        EnterUser user = enterUserService.check(enterUser.getEmail());
        if (user == null || !enterUser.getPassword().equals(user.getPassword()))
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        // 아이디 비밀번호 일치하는 경우

        Map<String, Object> result = new HashMap<String, Object>();
        HttpStatus status = null;
        int id = enterUserService.getUserIdByEmail(user.getEmail());
        try {
            result.put("access-token", jwtUtil.createToken(user.getEmail(), user.getPassword()));
            result.put("message", SUCCESS);
            result.put("email", user.getEmail());
            result.put("name", user.getName());
            result.put("id", id);
            result.put("nickname", user.getNickname());
            result.put("profileImg", user.getProfileImg());
            status = HttpStatus.OK;
        } catch (UnsupportedEncodingException e) {
            result.put("message", FAIL);
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Map<String, Object>>(result, status);
    }
}
