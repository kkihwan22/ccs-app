package org.ccs.app.entrypoints.common.service;

import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import lombok.RequiredArgsConstructor;
import org.ccs.app.entrypoints.common.model.FileDTO.PreSignedGenerateRequest;
import org.ccs.app.entrypoints.common.model.FileDTO.PreSignedResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.Date;

@RequiredArgsConstructor
@Service
public class FileServiceImpl implements FileService {
    private final static Logger log = LoggerFactory.getLogger(FileServiceImpl.class);

    private final AmazonS3 s3;

    @Value("${aws.s3.bucket-name}")
    private String bucketName;

    @Value("${aws.s3.pre-signed.expiration}")
    private long expiration;

    @Override
    public PreSignedResponse generatePreSignedUrl(PreSignedGenerateRequest request) {
        URL preSignedUrl = s3.generatePresignedUrl(request(bucketName, request.objectKey(), this.expiration));
        log.debug("pre-signed URL: {}", preSignedUrl.toString());
        return new PreSignedResponse(preSignedUrl.toString(), this.expiration);

    }

    private GeneratePresignedUrlRequest request(String bucketName, String objectKey, long expiration) {
        return new GeneratePresignedUrlRequest(bucketName, objectKey)
                .withMethod(HttpMethod.PUT)
                .withExpiration(new Date(expiration));
    }
}
