package org.ccs.app.core.authenticate.domain;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter @ToString
public class IssuedToken {
    @Id
    private String id;
    private Long accountId;
    private String token;

    public IssuedToken(Long accountId, String token) {
        this.accountId = accountId;
        this.token = token;
    }
}