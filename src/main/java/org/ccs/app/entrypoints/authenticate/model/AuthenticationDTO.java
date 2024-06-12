package org.ccs.app.entrypoints.authenticate.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AuthenticationDTO {

    public record LoginRequest(
            @NotBlank(message = "request.valid.email.required") @Email(message = "request.valid.invalid.email")
            String email,

            @NotBlank(message = "request.valid.password.required") @Size(min = 8, max = 64)
            String password
    ) {}
}
