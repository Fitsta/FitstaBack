package com.fitsta.model.dto;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class Like {
    // 좋아요 좋아요 해제 하는 DTO
    // insert delete
    private int postId;
    private int userId;
}
