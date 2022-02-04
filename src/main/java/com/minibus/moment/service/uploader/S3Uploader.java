package com.minibus.moment.service.uploader;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;

@Slf4j
@RequiredArgsConstructor
@Component
public class S3Uploader {

    private final AmazonS3Client amazonS3Client;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    public String upload(MultipartFile multipartFile, String fileName) throws IOException {
        File uploadFile = convert(multipartFile);
        return upload(uploadFile, fileName);
    }

    private String upload(File uploadFile, String fileName) {
        String saveDirectory = "minibus-imange-testfolder/" + LocalDateTime.now() + "_" + fileName;
        String uploadImageUrl = putS3(uploadFile, saveDirectory);
        removeNewFile(uploadFile);
        return uploadImageUrl;
    }

    private String putS3(File uploadFile, String fileName) {
        amazonS3Client.putObject(new PutObjectRequest(bucket, fileName, uploadFile).withCannedAcl(CannedAccessControlList.PublicRead));
        return amazonS3Client.getUrl(bucket, fileName).toString();
    }

    private void removeNewFile(File targetFile) {
        if (targetFile.delete()) {
            log.info("임시파일 객체가 삭제되었습니다.");
        } else {
            log.info("임시파일 객체가 삭제되지 않았습니다.");
        }
    }

    private File convert(MultipartFile file) throws IOException {
        File convertFile = new File(file.getOriginalFilename());
        try (FileOutputStream fos = new FileOutputStream(convertFile)) {
            fos.write(file.getBytes());
        } catch (IOException e) {
            log.error("Error converting multipartFile to file", e);
        } return convertFile;
    }
}
