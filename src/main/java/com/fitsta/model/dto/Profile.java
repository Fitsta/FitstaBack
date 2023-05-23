package com.fitsta.model.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class Profile {
    private String nickname;
    private String profileImg;
    private int postCount;
    private int followerCount;
    private int followingCount;
    private List<Post> postList;
}
