package org.ccs.app.config;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmazonCloudConfig {

    @Value("${aws.credentials.profile}")
    private String credentialsProfileName;

    @Value("${aws.region.static}")
    private String region;

    @Bean
    public AmazonS3 s3Client() {
        return AmazonS3ClientBuilder.standard()
                .withRegion(region)
                .withCredentials(this.profileCredentials()).build();
    }

    @Bean
    public AWSCredentialsProvider profileCredentials() {
        return new ProfileCredentialsProvider(credentialsProfileName);
    }
}
