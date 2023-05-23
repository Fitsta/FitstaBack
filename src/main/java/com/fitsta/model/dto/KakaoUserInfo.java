package com.fitsta.model.dto;

import lombok.*;

@Getter
@AllArgsConstructor
public class KakaoUserInfo {
    private Long id;
    private String email;
    private String nickname;
    private String profileImg;
}
