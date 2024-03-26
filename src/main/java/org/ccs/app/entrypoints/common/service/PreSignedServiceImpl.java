package org.ccs.app.entrypoints.common.service;

import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import lombok.RequiredArgsConstructor;
import org.ccs.app.entrypoints.common.model.PreSignedResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.Date;

@RequiredArgsConstructor
@Service
public class PreSignedServiceImpl implements PreSignedService {
    private final static Logger log = LoggerFactory.getLogger(PreSignedServiceImpl.class);

    private final AmazonS3 s3Client;

    @Value("${aws.s3.bucket-name}")
    private String bucketName;

    @Value("${aws.s3.pre-signed.expiration}")
    private long expiration;

    @Override
    public PreSignedResponse generate(String objectKey) {
        URL preSigned = s3Client.generatePresignedUrl(request(bucketName, objectKey, this.expiration));
        log.debug("pre-signed URL: {}", preSigned.toString());
        return new PreSignedResponse(preSigned.toString(), this.expiration);
    }

    private GeneratePresignedUrlRequest request(String bucketName, String objectKey, long expiration) {
        return new GeneratePresignedUrlRequest(bucketName, objectKey)
                .withMethod(HttpMethod.PUT)
                .withExpiration(new Date(expiration));
    }
}
