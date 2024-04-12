package org.ccs.app.core.authenticate.model;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter @ToString
public class TokenResult {
    private String tokenType = "Bearer";
    private String accessToken;
    private String refreshToken;
    private LocalDateTime expiredAt;

    public TokenResult(String accessToken, String refreshToken, Long expirationMs) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.expiredAt = LocalDateTime.now().plusSeconds(expirationMs);
    }
}
