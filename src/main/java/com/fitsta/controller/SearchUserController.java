package com.fitsta.controller;

import com.fitsta.model.dto.SearchUser;
import com.fitsta.model.service.SearchUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/searchUser")
@CrossOrigin("*")
public class SearchUserController {

    @Autowired
    SearchUserService searchUserService;

    @GetMapping("/{myId}")
    public ResponseEntity<?> getDetailList(@PathVariable int myId) {
        List<SearchUser> userList = searchUserService.getUserListLimitTwenty(myId);
        return new ResponseEntity<List<SearchUser>>(userList, HttpStatus.OK);
    }

    @GetMapping("/search/{myId}/{keyword}")
    public ResponseEntity<?> getSearchUserList(@PathVariable Map<String, String> map) {
        String myId = map.get("myId");
        String keyword = map.get("keyword");
        List<SearchUser> userList = searchUserService.searchUserByNameAndNickname(myId, keyword);
        return new ResponseEntity<List<SearchUser>>(userList, HttpStatus.OK);
    }

}