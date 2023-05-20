package com.fitsta.model.dto;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class EnterUser {
    // 회원 가입 할때 사용하는 DTO
    private String name;
    private String email;
    private String password;
    private String nickname;
    private String profileImg;

}
