package com.fitsta.model.dto;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class Comment {
    // 댓글 등록 수정 삭제시 사용
    private int commentId;
    private String comment;
    private int userId;
    private int postId;
    // 대댓글
    // private List<reply> replyList;
}