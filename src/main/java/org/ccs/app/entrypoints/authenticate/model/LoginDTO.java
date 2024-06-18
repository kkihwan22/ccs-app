package org.ccs.app.entrypoints.authenticate.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginDTO {

    public record LoginRequest(
            @NotBlank(message = "request.valid.email.required") @Email(message = "request.valid.invalid.email")
            String email,

            @NotBlank(message = "request.valid.password.required") @Size(min = 8, max = 64)
            String password
    ) {}

    public record TokenResponse(
            String accessToken, String refreshToken
    ) {
        public static TokenResponse of(String accessToken, String refreshToken) {
            return new TokenResponse(accessToken, refreshToken);
        }
    }
}
