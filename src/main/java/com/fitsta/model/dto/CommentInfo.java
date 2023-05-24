package com.fitsta.model.dto;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class CommentInfo {
    private String userId;
    private int commentId;
    private String profileImg;
    private String comment;
    private String date;
    private String nickname;
}
