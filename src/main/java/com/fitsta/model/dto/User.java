package com.fitsta.model.dto;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class User {

    private String profileImg;
    private String nickname;
    private String name;
    private boolean follow = true;

}
