package com.fitsta.model.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class S3Upload {

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;
    private final AmazonS3 amazonS3;

    public String upload(MultipartFile multipartFile) throws IOException {
        // S3에 저장되는 파일의 이름이 중복되지 않기 위해서
        // UUID로 생성한 랜덤 값과 파일 이름을 연결하여 S3에 업로드 하겠습니다.
        String s3FileName = UUID.randomUUID() + "-" + multipartFile.getOriginalFilename();

        // 그리고 Spring server 에서 S3로 파일을 업로드해야 하는데
        // 이 때 파일의 사이즈를 ContentLength 로 S3에 알려주기 위해서 ObjectMetadata 를 사용합니다.
        ObjectMetadata objMeta = new ObjectMetadata();
        // 주소로 접근 했을때 이미지 보여줌
        objMeta.setContentType(multipartFile.getContentType());
        // 주소로 접근 했을때 다운로드됨
        // objMeta.setContentLength(multipartFile.getInputStream().available());

        // 그리고 이제 S3 API 메소드인 putObject를 이용하여 파일 Stream을 열어서 S3에 파일을 업로드 합니다.
        amazonS3.putObject(bucket, s3FileName, multipartFile.getInputStream(), objMeta);
        // 이미지 볼 수 있는 url 준다.
        return amazonS3.getUrl(bucket, s3FileName).toString();
    }
}
