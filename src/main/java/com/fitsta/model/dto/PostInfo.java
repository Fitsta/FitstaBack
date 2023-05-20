package com.fitsta.model.dto;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class PostInfo {
    // main 화면에서 보여주는 포스팅 정보에 관한 DTO
    private int postId;
    private int writerId;
    private String regDate;
    private String postComment;
    private String filterName;
    private String img;
    private int likeCount;
    private String userName;
    private int commentCount;
    private String profileImg;
    private boolean isLike;
}
