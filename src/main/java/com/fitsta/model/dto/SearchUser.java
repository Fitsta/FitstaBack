package com.fitsta.model.dto;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class SearchUser {

    // 추천유저, 유저검색, follower 목록, following 목록
    private int userId;
    private String profileImg;
    private String nickname;
    private String name;
    private int followerCount;
    private boolean isFollow;

}
