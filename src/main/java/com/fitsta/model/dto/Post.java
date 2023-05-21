package com.fitsta.model.dto;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class Post {
    // post 등록 수정 삭제할때 사용하는 DTO
    private int userId;
    // postId 추가
    private int postId;
    private String postComment;
    private String filterName;
    private String img;
}
