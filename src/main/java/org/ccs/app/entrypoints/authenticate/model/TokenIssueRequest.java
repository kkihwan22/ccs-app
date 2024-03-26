package org.ccs.app.entrypoints.authenticate.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Getter @ToString
public class TokenIssueRequest {

    @NotBlank
    private String token;
}
