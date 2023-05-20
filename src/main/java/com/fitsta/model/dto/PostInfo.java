package com.fitsta.model.dto;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class PostInfo {
    // main 화면에서 보여주는 포스팅 정보에 관한 DTO
    private int postId;
    private String postComment;
    private String imgName;
    private int likeCount;
    private int commentCount;
    private String userName;
    private String profileImg;
    private boolean isLike;
    private String filter;
}
