package com.fitsta.controller;

import com.fitsta.model.dto.EnterUser;
import com.fitsta.model.service.EnterUserService;
import com.fitsta.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class KaKaoController {

    @Autowired
    EnterUserService enterUserService;

    @Autowired
    private JWTUtil jwtUtil;

    private static final String SUCCESS = "succes";
    private static final String FAIL = "fail";
    private String clientId = "a7e51c2902f13febf913e240bbf81f77";

    KakaoAPI kakaoApi = new KakaoAPI();

    @ResponseBody
    @RequestMapping(value = "/login", method = {RequestMethod.GET})
    public String main() {
        String url = "https://kauth.kakao.com/oauth/authorize?client_id=" +
                clientId +
                "&redirect_uri=http://localhost:8080/kakao_login/kakao&response_type=code";
        return url;
    }

    @RequestMapping(value="/kakao_login/kakao")
    public RedirectView kakaoCallback(@RequestParam String code, HttpSession session) {

        RedirectView redirectView = new RedirectView();

        // 1. 코드전달
        String access_token = kakaoApi.getAccessToken(code);

        // 2. 인증코드로 토큰 전달
        HashMap<String, Object> userInfo = kakaoApi.getUserInfo(access_token);

        if(userInfo.get("email") != null) {
            session.setAttribute("userId", userInfo.get("email"));
            session.setAttribute("access_token", access_token);
        }
        redirectView.setUrl("http://localhost:8081/kakao/" + userInfo.get("email"));
        redirectView.addStaticAttribute("user", userInfo);

        // 3. 기존 디비에 아이디 없으면 가입

        String email = userInfo.get("email").toString();
        String nickname = userInfo.get("nickname").toString();
        String profileImg = userInfo.get("profileImg").toString();

        if (enterUserService.getUserInfoByEmail(email) == null) {
            EnterUser user = new EnterUser();
            user.setEmail(email);
            user.setName(nickname);
            user.setProfileImg(profileImg);
            user.setNickname(nickname);
            enterUserService.enterUser(user);
        }

        return redirectView;
    }

    @GetMapping("/kakao/{email}")
    public ResponseEntity<?> kakaoLogin(@PathVariable String email) throws UnsupportedEncodingException {
        EnterUser user = enterUserService.getUserInfoByEmail(email);
        int id = enterUserService.getUserIdByEmail(user.getEmail());
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("access-token", jwtUtil.createToken(user.getEmail(), user.getPassword()));
        result.put("message", SUCCESS);
        result.put("email", user.getEmail());
        result.put("name", user.getName());
        result.put("id", id);
        result.put("nickname", user.getNickname());
        result.put("profileImg", user.getProfileImg());
        return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
    }

}
