package org.ccs.app.entrypoints.common.model;

import lombok.Getter;
import lombok.ToString;

@Getter @ToString
public class PreSignedResponse {
    private String url;
    private Long expirationTime;

    public PreSignedResponse(String url, Long expirationTime) {
        this.url = url;
        this.expirationTime = expirationTime;
    }
}