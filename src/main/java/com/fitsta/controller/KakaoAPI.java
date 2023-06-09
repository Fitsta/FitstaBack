package com.fitsta.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Value;

public class KakaoAPI {

    private String clientId = "";
    private String clientSecret = "";

    public String getAccessToken(String code) {

        String accessToken = "";
        String refreshToken = "";
        String reqURL = "https://kauth.kakao.com/oauth/token";

        try {
            URL url = new URL(reqURL);
            // 해당 주소의 페이지로 접속
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            //InputStream으로 응답 헤더와 메시지를 읽어들이겠다는 옵션을 정의한다.
            conn.setDoOutput(true);

            //writer: 출력, reader: 입력
            //POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            StringBuilder sb= new StringBuilder();
            sb.append("grant_type=authorization_code");
            sb.append("&client_id=" + clientId);
            sb.append("&client_secret=" + clientSecret);
//            sb.append("&redirect_url=https://minsung.site/kakao_login/kakao");
//            sb.append("&redirect_url=http://3.38.88.28/kakao_login/kakao");
            sb.append("&redirect_url=http://localhost:8080/kakao_login/kakao");
            sb.append("&code=" + code);

            bw.write(sb.toString());
            // 그리고 스트림의 버퍼를 비워준다.
            bw.flush();

            int responsCode = conn.getResponseCode();

            //요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String line = "";
            String result = "";
            //파일의 한줄한줄을 읽어서 출력한다.
            while((line = br.readLine())!=null) {
                result += line;
            }

            //json 형식으로 파시변환
            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result);

            accessToken = element.getAsJsonObject().get("access_token").getAsString();
            refreshToken = element.getAsJsonObject().get("refresh_token").getAsString();

            // 스트림을 닫는다.
            br.close();
            bw.close();

        }catch(Exception e) {
            e.printStackTrace();
        }

        return accessToken;
    }

    public HashMap<String, Object> getUserInfo(String access_token) {

        HashMap<String, Object> userInfo = new HashMap<String, Object>();
        String reqUrl = "https://kapi.kakao.com/v2/user/me";


        //access_token을 이용하여 사용자 정보 조회
        try {
            URL url = new URL(reqUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setRequestProperty("Authorization", "Bearer " + access_token);

            int responseCode = conn.getResponseCode();
//            System.out.println("responseCode : " + responseCode);


            //요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String line = "";
            String result = "";

            while((line = br.readLine())!=null) {
                result += line;
            }

//            System.out.println("resopnse body =" + result);

            //Gson 라이브러리로 JSON파싱
            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result);

            String email = "";
            String profileImg = "";
            String nickname = "";

            boolean has_email = element.getAsJsonObject().get("kakao_account").getAsJsonObject().get("has_email").getAsBoolean();
            if(has_email) {
                email = element.getAsJsonObject().get("kakao_account").getAsJsonObject().get("email").getAsString();
                nickname = element.getAsJsonObject().get("properties").getAsJsonObject().get("nickname").getAsString();
                profileImg = element.getAsJsonObject().get("properties").getAsJsonObject().get("profile_image").getAsString();
            }

            userInfo.put("email", email);
            userInfo.put("nickname", nickname);
            userInfo.put("profileImg", profileImg);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return userInfo;
    }

}