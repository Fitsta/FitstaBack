package com.fitsta.controller;

import com.fitsta.model.dto.SearchUser;
import com.fitsta.model.service.SearchUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/searchUser")
@CrossOrigin("*")
@Api(tags = "SearchUser Controller")
public class SearchUserController {

    @Autowired
    SearchUserService searchUserService;

    @GetMapping("/{myId}")
    @ApiOperation(value = "팔로워 수 상위 20명 유저 조회")
    public ResponseEntity<?> getDetailList(@PathVariable int myId) {
        List<SearchUser> userList = searchUserService.getUserListLimitTwenty(myId);
        return new ResponseEntity<List<SearchUser>>(userList, HttpStatus.OK);
    }

    @GetMapping("/search/{myId}/{keyword}")
    @ApiOperation(value = "로그인 유저를 제외한 유저 검색")
    public ResponseEntity<?> getSearchUserList(@PathVariable Map<String, String> map) {
        String myId = map.get("myId");
        String keyword = map.get("keyword");
        List<SearchUser> userList = searchUserService.searchUserByNameAndNickname(myId, keyword);
        return new ResponseEntity<List<SearchUser>>(userList, HttpStatus.OK);
    }

    @GetMapping("/searchFollower/{userId}")
    @ApiOperation(value = "팔로워 목록 정보 전달")
    public ResponseEntity<?> getFollowerList(@PathVariable int userId) {
        List<SearchUser> followerList = searchUserService.getFollowerList(userId);
        return new ResponseEntity<List<SearchUser>>(followerList, HttpStatus.OK);
    }

    @GetMapping("/searchFollowing/{userId}")
    @ApiOperation(value = "팔로잉 목록 정보 전달")
    public ResponseEntity<?> getFollowingList(@PathVariable int userId) {
        List<SearchUser> followingList = searchUserService.getFollowingList(userId);
        return new ResponseEntity<List<SearchUser>>(followingList, HttpStatus.OK);
    }
}