package com.fitsta.model.dto;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class Comment {
    // 댓글 수정 삭제시 사용
    private String comment;
    private int userId;
    private int postId;
    // 대댓글
    // private List<reply> replyList;
}