package com.fitsta.model.dto;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class EnterUser {
    // 회원 가입 할때 사용하는 DTO
    private String name;        // nickname
    private String email;       // email => 이거 기준으로 있으면 등록된애 없으면 새로가입한애
    private String password;    // x
    private String nickname;    //nickname
    private String profileImg;  //profile_image

}
