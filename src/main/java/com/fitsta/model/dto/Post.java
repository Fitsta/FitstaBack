package com.fitsta.model.dto;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class Post {
    // post 등록 수정 할때 사용하는 DTO
    private int userId;
    private String postComment;
    private String filterName;
    private String img;
}
