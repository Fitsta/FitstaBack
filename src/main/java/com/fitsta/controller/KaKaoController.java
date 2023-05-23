package com.fitsta.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@RestController
@RequestMapping("/api/kakao")
@CrossOrigin("*")
public class KaKaoController {

    private String clientId = "";

    KakaoAPI kakaoApi = new KakaoAPI();

    @ResponseBody
    @RequestMapping(value = "/login", method = {RequestMethod.GET})
    public String main() {
        String url = "https://kauth.kakao.com/oauth/authorize?client_id=" +
                clientId +
                "&redirect_uri=http://localhost:8080/kakao_login/kakao&response_type=code";
        System.out.println("login 컨트롤러 접근");
        return url;
    }

    @RequestMapping(value="/kakao_login/kakao")
    public RedirectView kakaoCallback(@RequestParam String code, HttpSession session) {

        RedirectView redirectView = new RedirectView();

        //1. 코드전달
        String access_token = kakaoApi.getAccessToken(code);

        //2. 인증코드로 토큰 전달
        HashMap<String, Object> userInfo = kakaoApi.getUserInfo(access_token);

        System.out.println("2. login info : " + userInfo);
        System.out.println("2-1. login info : " + userInfo.toString());

        if(userInfo.get("email") != null) {
            session.setAttribute("userId", userInfo.get("email"));
            session.setAttribute("access_token", access_token);
        }

        // redirectView.addStaticAttribute("email", userInfo.get("email"));
        redirectView.setUrl("http://localhost:8081");

        return redirectView;
    }

}
