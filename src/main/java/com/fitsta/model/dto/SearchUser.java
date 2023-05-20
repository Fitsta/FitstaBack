package com.fitsta.model.dto;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class SearchUser {

    private String profileImg;
    private String nickname;
    private String name;
    private boolean follow = true;

}
