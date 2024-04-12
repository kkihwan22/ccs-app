package org.ccs.app.entrypoints.authenticate.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.ToString;

@Getter @ToString
public class LoginRequest {

    @NotBlank(message = "request.valid.email.required")
    @Email(message = "request.valid.invalid.email")
    private String email;

    @NotBlank(message = "request.valid.password.required")
    @Size(min = 8, max = 64)
    private String password;
}
