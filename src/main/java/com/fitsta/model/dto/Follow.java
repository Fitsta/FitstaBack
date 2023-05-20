package com.fitsta.model.dto;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class Follow {
    // follow unfollow 하는 DTO
    // insert delete
    private int followingId;
    private int followerId;
}
