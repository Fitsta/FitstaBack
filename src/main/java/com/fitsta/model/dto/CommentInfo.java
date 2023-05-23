package com.fitsta.model.dto;
import lombok.*;
import java.sql.Date;
@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class CommentInfo {
    private String profileImg;
    private String comment;
    private Date date;
    private String nickname;
}
